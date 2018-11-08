package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView textView_welcome;
    private TextView textView_firstname;
    private TextView textView_lastname;
    private TextView textView_username;
    private TextView textView_emailaddress;
    private TextView textView_birthdate;
    private TextView textView_mobilephone;
    private Button button_viewallusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        textView_welcome = findViewById(R.id.textView_welcome);
        textView_firstname = findViewById(R.id.textView_firstname);
        textView_lastname = findViewById(R.id.textView_lastname);
        textView_username = findViewById(R.id.textView_username);
        textView_emailaddress = findViewById(R.id.textView_emailaddress);
        textView_birthdate = findViewById(R.id.textView_birthdate);
        textView_mobilephone = findViewById(R.id.textView_mobilephone);
        button_viewallusers = findViewById(R.id.button_view_all_users);

        Intent intent = getIntent();

        String firstname = intent.getStringExtra("FIRSTNAME");
        String lastname = intent.getStringExtra("LASTNAME");
        String username = intent.getStringExtra("USERNAME");
        String emailaddress = intent.getStringExtra("EMAILADDRESS");
        String birthdate = intent.getStringExtra("BIRTHDATE");
        String mobilephone = intent.getStringExtra("MOBILEPHONE");

        StringBuilder welcomeBuilder = new StringBuilder(100);
        welcomeBuilder.append(getString(R.string.textView_welcome) + " " + firstname + " " + lastname + "!");
        textView_welcome.setText(welcomeBuilder);

        StringBuilder firstNameBuilder = new StringBuilder( 50);
        firstNameBuilder.append(getString(R.string.textView_firstname) + " " + firstname);
        textView_firstname.setText(firstNameBuilder);

        StringBuilder lastNameBuilder = new StringBuilder( 50);
        lastNameBuilder.append(getString(R.string.textView_lastname) + " " + lastname);
        textView_lastname.setText(lastNameBuilder);

        StringBuilder userNameBuilder = new StringBuilder( 50);
        userNameBuilder.append(getString(R.string.textView_username) + " " + username);
        textView_username.setText(userNameBuilder);

        StringBuilder emailAddressBuilder = new StringBuilder( 50);
        emailAddressBuilder.append(getString(R.string.textView_emailaddress) + " " + emailaddress);
        textView_emailaddress.setText(emailAddressBuilder);

        StringBuilder birthDateBuilder = new StringBuilder( 50);
        birthDateBuilder.append(getString(R.string.textView_birthdate) + " " + birthdate);
        textView_birthdate.setText(birthDateBuilder);

        StringBuilder mobilePhoneBuilder = new StringBuilder( 50);
        mobilePhoneBuilder.append(getString(R.string.textView_mobilephone) + " " + mobilephone);
        textView_mobilephone.setText(mobilePhoneBuilder);

        button_viewallusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSuccessActivity.this, ViewAllUsersActivity.class));
            }
        });
    }

}
