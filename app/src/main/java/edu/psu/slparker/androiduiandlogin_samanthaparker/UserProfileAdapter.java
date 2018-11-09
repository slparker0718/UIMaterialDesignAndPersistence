
package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.MyViewHolder> {

    private ArrayList<UserProfile> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView_firstName;
        TextView textView_lastName;
        TextView textView_emailAddress;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView_firstName = (TextView) itemView.findViewById(R.id.textView_AllUsers_FirstName);
            this.textView_lastName = (TextView) itemView.findViewById(R.id.textView_AllUsers_LastName);
            this.textView_emailAddress = (TextView) itemView.findViewById(R.id.textView_AllUsers_EmailAddress);
        }
    }

    public UserProfileAdapter(ArrayList<UserProfile> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_users_list_view, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textView_firstname = holder.textView_firstName;
        TextView textView_lastname = holder.textView_lastName;
        TextView textView_emailaddress = holder.textView_emailAddress;

        textView_firstname.setText(dataSet.get(listPosition).getFirstname());
        textView_lastname.setText(dataSet.get(listPosition).getLastName());
        textView_emailaddress.setText(dataSet.get(listPosition).getEmailAddress());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
