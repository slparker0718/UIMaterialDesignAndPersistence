package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_login_email_or_id;
    private EditText editText_login_password;
    private Button  button_login;
    private Button button_signup;
    private ArrayList<UserProfile> userProfiles;
    private PersistenceUserProfile persistenceUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_login_email_or_id = (EditText) findViewById(R.id.editText_login_email_or_id);
        editText_login_password = (EditText) findViewById(R.id.editText_login_password);
        button_login = (Button) findViewById(R.id.button_login);
        button_signup = (Button) findViewById(R.id.button_signup);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        persistenceUserProfile = new PersistenceUserProfile(this);
        userProfiles = persistenceUserProfile.getDataFromDB();
    }

    private void validateInput() {

        UserProfile userProfile = null;
        if (userProfiles != null && !userProfiles.isEmpty()) {

            String user = editText_login_email_or_id.getText().toString();
            String password = editText_login_password.getText().toString();

            for (UserProfile up : userProfiles) {
                if (up.getUsername().equals(user)) {
                    userProfile = up;
                    break;
                }
            }
            if (userProfile == null) {
                Toast.makeText(getApplicationContext(), R.string.toast_username_not_found, Toast.LENGTH_LONG).show();
            } else {
                if (!userProfile.getPassword().equals(password)) {
                    Toast.makeText(getApplicationContext(), R.string.toast_incorrect_password, Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    intent.putExtra("FIRSTNAME", userProfile.getFirstname());
                    intent.putExtra( "LASTNAME", userProfile.getLastName());
                    intent.putExtra("USERNAME", userProfile.getUsername());
                    intent.putExtra("EMAILADDRESS", userProfile.getEmailAddress());
                    intent.putExtra("BIRTHDATE", userProfile.getBirthdate());
                    intent.putExtra("MOBILEPHONE", userProfile.getMobilePhone());
                    startActivity(intent);
                }
            }
        }
    }
}
