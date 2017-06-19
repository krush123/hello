package com.example.student.contextmanagement;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

/**
 * Created by student on 19/6/17.
 */

 class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMPANY = "comapny";
    public static final String COLUMN_ID = "Name";
    public static final String COLUMN_COMMENT = "domain";

    private static final String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMPANY + "( " + COLUMN_ID
            + " text not null, " + COLUMN_COMMENT
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        onCreate(db);
    }

}
