package com.myfirstapplicationexample.smartec.MvpTest.view;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.myfirstapplicationexample.smartec.MvpTest.R;
import com.myfirstapplicationexample.smartec.MvpTest.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private MainActivityPresenter mainActivityPresenter;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText ageEditText;
    private Button button;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_login);

        mainActivityPresenter = new MainActivityPresenter(this);
        initViews();
    }

    private void initViews() {
        nameEditText = findViewById(R.id.editText);
        emailEditText = findViewById(R.id.editText2);
        ageEditText = findViewById(R.id.editText3);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userFirstName = !nameEditText.getText().toString().isEmpty() ? nameEditText.getText().toString() : "";
                String userEmail = !emailEditText.getText().toString().isEmpty() ? emailEditText.getText().toString() : "";
                Integer userAge = !ageEditText.getText().toString().isEmpty() ?
                        Integer.valueOf(ageEditText.getText().toString()) : null;
                mainActivityPresenter.updateUserInfo(userFirstName, userEmail, userAge);
            }
        });

    }

    @Override
    public void updateUserViewSucess() {
        Toast.makeText(this, "User Sucess !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUserViewFailure() {
        Toast.makeText(this, "User Failed !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        final Handler handler1 = new Handler(Looper.getMainLooper());
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainActivityPresenter.startUserService();
            }
        }, 2000);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
