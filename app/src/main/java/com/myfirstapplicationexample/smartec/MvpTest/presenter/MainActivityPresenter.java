package com.myfirstapplicationexample.smartec.MvpTest.presenter;

import com.myfirstapplicationexample.smartec.MvpTest.model.User;

/**
 * Created by Abdelrahman Ibrahim on 3/15/2019.
 */
public class MainActivityPresenter {

    private User user;
    private View view;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
    }

    public void updateUserInfo(String name, String email, Integer age) {
        user.setUserName(name);
        user.setUserEmail(email);
        user.setAge(age);
        view.showProgressBar();
    }

    public void startUserService() {
        if (!user.getUserEmail().isEmpty()
                || !user.getUserName().isEmpty()
                || user.getAge() != null) {
            view.hideProgressBar();
            view.updateUserViewSucess();
        } else {
            view.hideProgressBar();
            view.updateUserViewFailure();
        }
    }

    public interface View {

        void updateUserViewSucess();

        void updateUserViewFailure();

        void showProgressBar();

        void hideProgressBar();

    }


}
