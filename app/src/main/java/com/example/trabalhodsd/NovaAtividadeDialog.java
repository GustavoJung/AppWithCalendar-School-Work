package com.example.trabalhodsd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class NovaAtividadeDialog extends AppCompatDialogFragment {

    private EditText nome;
    private EditText data;
    private AtividadeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (AtividadeListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_form, null);

        builder.setView(view).setTitle("Nova Atividade").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Criar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nomeAtividade = nome.getText().toString();
                String dataAtividade = data.getText().toString();
                listener.setText(view, nomeAtividade, dataAtividade);
            }
        });

        nome = view.findViewById(R.id.nome_atividade);
        data = view.findViewById(R.id.data_atividade);
        return builder.create();
    }

    public interface AtividadeListener {
        void setText(View v, String nome, String data);
    }
}
