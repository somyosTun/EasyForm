package app.somyost.easyform.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Chaiwoot on 17/9/2560.
 */

public class MyManager {

    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;


    // Alt * Int    Contrucktor
    public MyManager(Context context) {
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase(); // write Database

    }

    public long addNameToSQLite(String strName,
                                String strGender,
                                String strProvince) {
        ContentValues contentValues = new ContentValues(); // change string To Integer
        contentValues.put("Name",strName);
        contentValues.put("Gender",strGender);
        contentValues.put("Province",strProvince);
        return sqLiteDatabase.insert("nameTABLE",null,contentValues); // return object sqLiteDatabase
    }// Alt * Enter    Return


} // Main Class
