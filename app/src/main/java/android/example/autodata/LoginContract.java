package android.example.autodata;

import android.content.Context;

public interface LoginContract {
    interface LoginView {

    }

    interface LoginPresenter {
        void onButtonWasClicked();
        void showDbLog();
    }

    interface LoginRepository {
        void addUser(String login, String password);
    }
}
