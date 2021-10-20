package com.example.yolofitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CLASS_TABLE = "CLASS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CLASS_NAME = "CLASS_NAME";
    public static final String COLUMN_CLASS_DESCRIPT = "CLASS_DESCRIPT";
    public static final String User_name = "memberName";
    public static final String Password = "password";
    public static final String identity = "AccountIdentity";



    public DatabaseHelper(@Nullable Context context) {

        super(context, "class.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        String createTableStatement = "CREATE TABLE " + CLASS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CLASS_NAME + " TEXT, " + COLUMN_CLASS_DESCRIPT + " TEXT)";
        sqldb.execSQL(createTableStatement);
        sqldb.execSQL("create TABLE users(User_name TEXT primary key, password TEXT, identity TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqldb, int i, int i1) {
        sqldb.execSQL("drop TABLE if exists users");

    }


    public boolean addOne(ClassModel classModel) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues cvalue = new ContentValues();
        cvalue.put(COLUMN_CLASS_NAME, classModel.getName());
        cvalue.put(COLUMN_CLASS_DESCRIPT, classModel.getDescription());

        long insert = sqldb.insert(CLASS_TABLE, null, cvalue);
        return insert != -1;

    }

    public boolean deleteone(ClassModel classModel) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CLASS_TABLE + " WHERE " + COLUMN_ID + " = " + classModel.getId();
        Cursor cursor = sqldb.rawQuery(queryString, null);
        return cursor.moveToFirst();

    }

    public List<ClassModel> getAll() {
        List<ClassModel> allList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CLASS_TABLE;
        SQLiteDatabase sqldb = this.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                int classID = cursor.getInt(0);
                String className = cursor.getString(1);
                String classDes = cursor.getString(2);

                ClassModel newclass = new ClassModel(classID, className, classDes);
                allList.add(newclass);

            } while (cursor.moveToNext());
        } else {

        }

        cursor.close();
        sqldb.close();
        return allList;
    }

    public boolean add_accountdata(String User_name, String Password, String identity) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("memberName", User_name);
        value.put("password", Password);
        value.put( "identity",identity);
        long Account = sqldb.insert("users", null, value);
        if (Account == 1) {
            return false;

        } else {
            return true;
        }


    }

    public boolean Verify_Account(String member_username) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor member_Account = sqldb.rawQuery("SELECT * FROM users where member_username = ?", new String[]{member_username});
        if (member_Account.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean Verify_password(String member_username, String password){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor Accountinfo = sqldb.rawQuery("SELECT* FROM users where member_username = ? and password = ?", new String[]{member_username, password});
        if (Accountinfo.getCount()>0){
            return true;
        }else{
            return false;

        }
    }
    public boolean Verify_identify(String member_identity){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor identify = sqldb.rawQuery("SELECT * FROM users where identify = ?", new String[]{member_identity});
        if (identify.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
