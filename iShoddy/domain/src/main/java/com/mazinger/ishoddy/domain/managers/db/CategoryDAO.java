package com.mazinger.ishoddy.domain.managers.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

import static com.mazinger.ishoddy.domain.managers.db.DBConstants.ALL_COLUMNS_ACTIVITY;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.KEY_ACTIVITY_ACTIVE;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.KEY_ACTIVITY_ID;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.KEY_ACTIVITY_MODIFICATION_DATE;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.KEY_ACTIVITY_NAME;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.KEY_ACTIVITY_URL_LOGO;
import static com.mazinger.ishoddy.domain.managers.db.DBConstants.TABLE_ACTIVITY;

public class CategoryDAO implements DAOReadable<Category>, DAOWritable<Category>
{
    private static final long EMPTY_CATEGORY = 0;

    private SQLiteDatabase dbReadConnection;
    private SQLiteDatabase dbWriteConnection;

    public CategoryDAO(DBHelper dbHelper)
    {
        dbReadConnection = dbHelper.getReadableDatabase();
        dbWriteConnection = dbHelper.getWritableDatabase();
    }

    public CategoryDAO(Context context)
    {
        this(new DBHelper(context));
    }

    @Override
    public @Nullable List<Category> query(String where, String[] whereArgs, String orderBy) {

        Cursor c = dbReadConnection.query(TABLE_ACTIVITY,
                ALL_COLUMNS_ACTIVITY,   // columns I want to obtain
                where,                  // where
                whereArgs,              // where args
                orderBy,                // order by
                null,                   // group
                null);                  // having

        if (c == null || c.getCount() == 0) {

            return null;
        }

        List<Category> categoryList = new ArrayList<>();

        while (c.moveToNext()) {

            long id = c.getLong(c.getColumnIndex(KEY_ACTIVITY_ID));
            String name = c.getString(c.getColumnIndex(KEY_ACTIVITY_NAME));
            int active = c.getInt(c.getColumnIndex(KEY_ACTIVITY_ACTIVE));
            String urlLogo = c.getString(c.getColumnIndex(KEY_ACTIVITY_URL_LOGO));
            String modificationDate = c.getString(c.getColumnIndex(KEY_ACTIVITY_MODIFICATION_DATE));

            //-- TODO: Dates Conversion --
//            Cursor cursor = database.rawQuery(
//                    "SELECT item_id AS _id," +
//                            " (strftime('%s', added_on) * 1000) AS added_on," + " added_by, quantity, units" +
//                            " FROM current_list", new String[0]);
//            long millis = cursor.getLong(cursor.getColumnIndexOrThrow("added_on"));
//
//            Date addedOn = new Date(millis);
            //--

            Category category = Category.of(id, name, active > 0 ? true : false)
                    .setUrlLogo(urlLogo)
                    .setModificationDate(modificationDate);

            categoryList.add(category);
        }

        return categoryList;
    }

    @Override
    public @Nullable Category query(long id)
    {
        String idAsString = String.format("%d", id);
        List<Category> categories = query(KEY_ACTIVITY_ID + " = ?", new String[]{idAsString}, KEY_ACTIVITY_ID);

        if (categories == null || categories.size() == 0) {

            return null;
        }

        return categories.get(0);
    }

    @Override
    public List<Category> query()
    {
        return  query("", null, KEY_ACTIVITY_ID);
    }

    @Override
    public long insert(@NonNull Category element)
    {
        if (element == null)
        {
            return EMPTY_CATEGORY;
        }

        dbWriteConnection.beginTransaction();
        long id = DBHelper.INVALID_ID;

        try
        {
            id = dbWriteConnection.insert(TABLE_ACTIVITY, null, getContentValues(element));
            dbWriteConnection.setTransactionSuccessful();
        } finally
        {
            dbWriteConnection.endTransaction();
        }

        return id;
    }

    private ContentValues getContentValues(Category category)
    {
        final ContentValues contentValues = new ContentValues();

        if (category == null)
        {
            return contentValues;
        }

        contentValues.put(KEY_ACTIVITY_ID, category.getId());
        contentValues.put(KEY_ACTIVITY_NAME, category.getName());
        contentValues.put(KEY_ACTIVITY_ACTIVE, category.isActive());
        contentValues.put(KEY_ACTIVITY_MODIFICATION_DATE, category.getModificationDate());
        contentValues.put(KEY_ACTIVITY_URL_LOGO, category.getUrlLogo());

        return contentValues;
    }

    @Override
    public long update(long id, Category element)
    {
        return 0;
    }

    @Override
    public long delete(long id)
    {
        return delete(KEY_ACTIVITY_ID + " = ?", "" + id);
    }

    @Override
    public long delete(Category element)
    {
        return delete(element.getId());
    }

    @Override
    public void deleteAll()
    {
        delete(null, null);
    }

    @Override
    public long delete(String where, String... whereClause)
    {
        dbWriteConnection.beginTransaction();
        int deleteRegs = 0;

        try
        {
            deleteRegs = dbWriteConnection.delete(TABLE_ACTIVITY, where, whereClause);

            dbWriteConnection.setTransactionSuccessful();
        }
        finally
        {
            dbWriteConnection.endTransaction();
        }

        return deleteRegs;
    }

    @Override
    public int numRecords() {

        List<Category> categoryList = query();

        return categoryList == null ? 0 : categoryList.size();
    }
}






























