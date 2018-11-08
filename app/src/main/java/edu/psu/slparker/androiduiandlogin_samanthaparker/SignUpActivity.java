package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText editText_firstName;
    private EditText editText_lastName;
    private EditText editText_userName;
    private EditText editText_password;
    private EditText editText_emailAddress;
    private EditText editText_birthdate;
    private EditText editText_mobilePhone;
    private Button button_signup_submit;
    private PersistenceUserProfile persistenceUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editText_firstName = (EditText) findViewById(R.id.editText_firstname);
        editText_lastName = (EditText) findViewById(R.id.editText_lastname);
        editText_userName = (EditText) findViewById(R.id.editText_username);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_emailAddress = (EditText) findViewById(R.id.editText_emailaddress);
        editText_birthdate = (EditText) findViewById(R.id.editText_birthdate);
        editText_mobilePhone = (EditText) findViewById(R.id.editText_mobilephone);
        button_signup_submit = (Button) findViewById(R.id.button_signup_submit);

        button_signup_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editText_firstName.getText().toString();
                Toast.makeText(getApplicationContext(), firstName, Toast.LENGTH_SHORT).show();
                String lastName = editText_lastName.getText().toString();
                String userName = editText_userName.getText().toString();
                String password = editText_password.getText().toString();
                String emailAddress = editText_emailAddress.getText().toString();
                String birthdate = editText_birthdate.getText().toString();
                String mobilePhone = editText_mobilePhone.getText().toString();

                UserProfile user = new UserProfile(firstName, lastName, userName, password, emailAddress, birthdate, mobilePhone);
                persistenceUserProfile.insert(user);

                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                Toast.makeText(getApplicationContext(), "Successfully created user.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        persistenceUserProfile = new PersistenceUserProfile(this);
    }
}
