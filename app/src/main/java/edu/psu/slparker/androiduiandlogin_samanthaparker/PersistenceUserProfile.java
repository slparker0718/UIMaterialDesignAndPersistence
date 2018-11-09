package edu.psu.slparker.androiduiandlogin_samanthaparker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PersistenceUserProfile implements IPersistence {

    public DatabaseAccess databaseAccess;

    public PersistenceUserProfile(Context context){
        this.databaseAccess = new DatabaseAccess(context);
    }

    public void delete(Object o)
    {
        UserProfile userProfile = (UserProfile) o;
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        sqLiteDatabase.delete(UserProfileTable.TABLE_NAME, UserProfileTable.COLUMN_NAME_ID + " = ?",new String[] { userProfile.getId().toString() });
    }

    public void edit(Object o)
    {
        UserProfile userProfile = (UserProfile) o;
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserProfileTable.COLUMN_NAME_FIRSTNAME, userProfile.getFirstname());
        contentValues.put(UserProfileTable.COLUMN_NAME_LASTNAME, userProfile.getLastName());
        contentValues.put(UserProfileTable.COLUMN_NAME_USERNAME, userProfile.getUsername());
        contentValues.put(UserProfileTable.COLUMN_NAME_EMAILADDRESS, userProfile.getEmailAddress());
        contentValues.put(UserProfileTable.COLUMN_NAME_BIRTHDATE, userProfile.getBirthdate());
        contentValues.put(UserProfileTable.COLUMN_NAME_PASSWORD, userProfile.getPassword());
        contentValues.put(UserProfileTable.COLUMN_NAME_MOBILEPHONE, userProfile.getMobilePhone());

        sqLiteDatabase.update(UserProfileTable.TABLE_NAME, contentValues, UserProfileTable.COLUMN_NAME_ID + " = ?",new String[] { userProfile.getId().toString() });
        sqLiteDatabase.close();
    }

    public void insert(Object o)
    {
        UserProfile userProfile = (UserProfile) o;
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserProfileTable.COLUMN_NAME_FIRSTNAME, userProfile.getFirstname());
        contentValues.put(UserProfileTable.COLUMN_NAME_LASTNAME, userProfile.getLastName());
        contentValues.put(UserProfileTable.COLUMN_NAME_USERNAME, userProfile.getUsername());
        contentValues.put(UserProfileTable.COLUMN_NAME_EMAILADDRESS, userProfile.getEmailAddress());
        contentValues.put(UserProfileTable.COLUMN_NAME_BIRTHDATE, userProfile.getBirthdate());
        contentValues.put(UserProfileTable.COLUMN_NAME_PASSWORD, userProfile.getPassword());
        contentValues.put(UserProfileTable.COLUMN_NAME_MOBILEPHONE, userProfile.getMobilePhone());

        sqLiteDatabase.insert(UserProfileTable.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList getDataFromDB()
    {
        ArrayList<UserProfile> userProfiles = new ArrayList<UserProfile>();
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(UserProfileTable.select(), null);
        cursor.moveToFirst();

        if(cursor != null && cursor.moveToFirst()){

            do {
                String firstName = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_FIRSTNAME));
                String lastName = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_LASTNAME));
                String userName = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_USERNAME));
                String password = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_PASSWORD));
                String emailAddress = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_EMAILADDRESS));
                String birthdate = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_BIRTHDATE));
                String mobilePhone = cursor.getString(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_MOBILEPHONE));
                Long Id = cursor.getLong(cursor.getColumnIndex(UserProfileTable.COLUMN_NAME_ID));

                UserProfile userProfile = new UserProfile(firstName, lastName, userName, password, emailAddress, birthdate, mobilePhone, Id);
                userProfiles.add(userProfile);

            } while (cursor.moveToNext()) ;
        }

        return userProfiles;
    }

}
