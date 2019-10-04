package com.example.trabalhodsd.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.trabalhodsd.DAO.AppDatabase;
import com.example.trabalhodsd.DAO.DAOUser;
import com.example.trabalhodsd.model.User;

public class UserRepository {
    private DAOUser dao;
    private LiveData<User>user;

    UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.DAOuser();
        user = dao.findByName("Nome");
    }

    LiveData<User> getUserName() {
        return user;
    }

    public void insert (User user) {
        new insertAsyncTask(dao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private DAOUser mAsyncTaskDao;

        insertAsyncTask(DAOUser dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
