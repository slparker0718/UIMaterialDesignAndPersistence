package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserProfileAdapter extends ArrayAdapter {

    public UserProfileAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.all_users_list_view, parent, false);
        }

        UserProfile userProfile = (UserProfile) getItem(position);

        TextView textViewFirstName = (TextView) listItemView.findViewById(R.id.textView_AllUsers_FirstName);
        textViewFirstName.setText(userProfile.getFirstname());

        TextView textViewLastName = (TextView) listItemView.findViewById(R.id.textView_AllUsers_LastName);
        textViewLastName.setText(userProfile.getLastName());

        TextView textViewEmailAddress = (TextView) listItemView.findViewById(R.id.textView_AllUsers_EmailAddress);
        textViewEmailAddress.setText(userProfile.getEmailAddress());

        return listItemView;
    }
}
