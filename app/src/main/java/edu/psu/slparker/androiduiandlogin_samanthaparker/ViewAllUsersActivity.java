package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAllUsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView_viewAllUsers;
    private ArrayList<UserProfile> userProfiles;
    //private UserProfileAdapter userProfileAdapter;
    private LinearLayoutManager linearLayoutManager;
    private static RecyclerView.Adapter userProfileAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        recyclerView_viewAllUsers = (RecyclerView) findViewById(R.id.recyclerView_viewAllUsers);
        recyclerView_viewAllUsers.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_viewAllUsers.setLayoutManager(linearLayoutManager);

        PersistenceUserProfile persistenceUserProfile = new PersistenceUserProfile(this);
        userProfiles = persistenceUserProfile.getDataFromDB();


        userProfileAdapter = new UserProfileAdapter(userProfiles);
        recyclerView_viewAllUsers.setAdapter(userProfileAdapter);
    }
}
