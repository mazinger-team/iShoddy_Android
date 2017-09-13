package com.mazinger.ishoddy.domain.managers.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_FILE_NAME = "ishoddy.sqlite";
    public static final int DATABASE_VERSION = 1;
    public static final SQLiteDatabase.CursorFactory NO_CURSOR_FACTORY = null;
    public static final long INVALID_ID = -1;

    public DBHelper(Context context)
    {
        this(context, DATABASE_FILE_NAME, NO_CURSOR_FACTORY, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onOpen(SQLiteDatabase db)
    {
        super.onOpen(db);

        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        for (String script : DBConstants.CREATE_DATABASE_SCRIPTS)
        {
            db.execSQL(script);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion == 1 && newVersion == 2) // v1 --> v2
        {
            db.execSQL(DBConstants.UPDATE_DATABASE_SCRIPTS);
        }
        else if (oldVersion == 1 && newVersion == 3)
        {
            // ...
        }
    }
}
