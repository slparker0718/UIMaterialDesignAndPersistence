package edu.psu.slparker.androiduiandlogin_samanthaparker;

public class UserProfileTable {

    public static final String TABLE_NAME = "UserProfile";
    public static final String COLUMN_NAME_ID = "Id";
    public static final String COLUMN_NAME_FIRSTNAME = "FirstName";
    public static final String COLUMN_NAME_LASTNAME = "LastName";
    public static final String COLUMN_NAME_USERNAME = "Username";
    public static final String COLUMN_NAME_BIRTHDATE = "BirthDate";
    public static final String COLUMN_NAME_MOBILEPHONE = "MobilePhone";
    public static final String COLUMN_NAME_EMAILADDRESS= "EmailAddress";
    public static final String COLUMN_NAME_PASSWORD = "Password";

    public static String create() {
        return new String("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_FIRSTNAME + " TEXT," +
                COLUMN_NAME_LASTNAME + " TEXT," +
                COLUMN_NAME_USERNAME + " TEXT," +
                COLUMN_NAME_BIRTHDATE + " TEXT," +
                COLUMN_NAME_MOBILEPHONE + " TEXT," +
                COLUMN_NAME_EMAILADDRESS + " TEXT," +
                COLUMN_NAME_PASSWORD + " TEXT)");
    }

    public static String select()
    {
        return new String("SELECT * FROM "+TABLE_NAME);
    }

    public static final String delete(){
        return "DROP TABLE IF EXISTS " +TABLE_NAME;
    }
}
