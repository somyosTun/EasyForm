package app.somyost.easyform.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chaiwoot on 17/9/2560.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    private Context context;
    public static final String database_name = "easyForm.db";
    private static final int database_version = 1;
    private static final String database_name_table = "create table nameTABLE (" +
            "id integer primary key," +
            "Name text," +
            "Gender text," +
            "Province text);";

    //create construcktor     Ctrl * Ins
    public MyOpenHelper(Context context) {
        // construcktor Error  Alt * Enter  ## Insert Super
        super(context,database_name,null,database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(database_name_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
