package com.mazinger.ishoddy.domain.managers.db;

public class DBConstants {
    
    //-- BEGIN TABLE ACTIVITY --//--
    public static final String TABLE_ACTIVITY = "ACTIVITY";

    // Table field constants
    public static final String KEY_ACTIVITY_UNIQUE = "_id";
    public static final String KEY_ACTIVITY_ID = "ID";
    public static final String KEY_ACTIVITY_NAME = "NAME";
    public static final String KEY_ACTIVITY_ACTIVE = "ACTIVE";
    public static final String KEY_ACTIVITY_MODIFICATION_DATE = "MODIFICATION_DATE";
    public static final String KEY_ACTIVITY_URL_LOGO = "URL_LOGO";

    public static final String[] ALL_COLUMNS_ACTIVITY = {
            KEY_ACTIVITY_UNIQUE,
            KEY_ACTIVITY_ID,
            KEY_ACTIVITY_NAME,
            KEY_ACTIVITY_ACTIVE,
            KEY_ACTIVITY_MODIFICATION_DATE,
            KEY_ACTIVITY_URL_LOGO
    };

    public static final String SQL_SCRIPT_CREATE_ACTIVITY_TABLE =
            "create table " + TABLE_ACTIVITY
                    + "( "
                    + KEY_ACTIVITY_UNIQUE + " integer PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + KEY_ACTIVITY_ID + " integer NOT NULL, "
                    + KEY_ACTIVITY_NAME + " text NOT NULL, "
                    + KEY_ACTIVITY_ACTIVE + " integer NOT NULL, "
                    + KEY_ACTIVITY_MODIFICATION_DATE + " timestamp, "
                    + KEY_ACTIVITY_URL_LOGO + " TEXT"
                    + ");";

    //-- TODO: Final database schema? --
//    public static final String SQL_SCRIPT_CREATE_ACTIVITY_TABLE =
//            "create table " + TABLE_ACTIVITY
//                    + "( "
//                    + KEY_ACTIVITY_UNIQUE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
//                    + KEY_ACTIVITY_ID + " INTEGER NOT NULL, "
//                    + KEY_ACTIVITY_NAME + " TEXT NOT NULL,"
//                    + KEY_ACTIVITY_ACTIVE + " INTEGER NOT NULL, "
//                    + KEY_ACTIVITY_MODIFICATION_DATE + " TIMESTAMP NOT NULL,"
//                    + KEY_ACTIVITY_URL_LOGO + " TEXT"
//                    + ");";
    //--

    // -- END TABLE ACTIVITY --//--

    public static final String DROP_DATABASE_SCRIPTS = "";
    public static final String UPDATE_DATABASE_SCRIPTS = "";


    public static final String[] CREATE_DATABASE_SCRIPTS = {SQL_SCRIPT_CREATE_ACTIVITY_TABLE};
}






























