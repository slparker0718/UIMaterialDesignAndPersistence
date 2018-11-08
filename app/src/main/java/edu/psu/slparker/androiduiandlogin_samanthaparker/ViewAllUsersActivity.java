package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAllUsersActivity extends AppCompatActivity {

    private ListView listView_AllUsers;
    private ArrayList<UserProfile> userProfiles;
    private UserProfileAdapter userProfileAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        listView_AllUsers = (ListView) findViewById(R.id.listView_AllUsers);

        PersistenceUserProfile persistenceUserProfile = new PersistenceUserProfile(this);
        userProfiles = persistenceUserProfile.getDataFromDB();

        userProfileAdapter  = new UserProfileAdapter(this,
                R.layout.all_users_list_view,
                userProfiles);

        listView_AllUsers.setAdapter(userProfileAdapter);
    }
}
