package com.example.yolofitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import androidx.annotation.Nullable;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CLASS_TABLE = "CLASS_TABLE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CLASS_NAME = "CLASS_NAME";
    public static final String COLUMN_CLASS_DESCRIPT = "CLASS_DESCRIPT";
    public static final String COLUMN_INSTRUCTOR = "INSTRUCTOR";
    public static final String COLUMN_DIFFICULT = "DIFFICULT";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_HOUR = "HOUR";
    public static final String COLUMN_CAP = "CAP";
    public static final String COLUMN_ID2 = "ID2";
    public static final String COLUMN_USER = "USER";
    public static final String COLUMN_PASS = "PASS";
    public static final String COLUMN_IDENTITY = "IDENTITY";





    public DatabaseHelper(@Nullable Context context) {

        super(context, "Database.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        String classtable = "CREATE TABLE " + CLASS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CLASS_NAME + " TEXT, " + COLUMN_CLASS_DESCRIPT + " TEXT, " + COLUMN_INSTRUCTOR + " TEXT, " + COLUMN_DIFFICULT + " TEXT, "+ COLUMN_TIME + " TEXT, " + COLUMN_HOUR + " TEXT, " + COLUMN_CAP + " TEXT)";
        String usertable = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_ID2 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER + " TEXT, " + COLUMN_PASS + " TEXT, " + COLUMN_IDENTITY +" TEXT)";
        sqldb.execSQL(usertable);
        sqldb.execSQL(classtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqldb, int i, int i1) {
        sqldb.execSQL("DROP TABLE if exists " + CLASS_TABLE);
        sqldb.execSQL("DROP TABLE if exists " + USER_TABLE);
        onCreate(sqldb);


    }


    public boolean addOne(ClassModel classModel) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues cvalue = new ContentValues();
        cvalue.put(COLUMN_CLASS_NAME, classModel.getName());
        cvalue.put(COLUMN_CLASS_DESCRIPT, classModel.getDescription());
        cvalue.put(COLUMN_INSTRUCTOR,classModel.getInstructor());
        cvalue.put(COLUMN_DIFFICULT,classModel.getDifficulty());
        cvalue.put(COLUMN_TIME,classModel.getDate());
        cvalue.put(COLUMN_HOUR,classModel.getHours());
        cvalue.put(COLUMN_CAP,classModel.getCapacity());

        long insert = sqldb.insert(CLASS_TABLE, null, cvalue);
        return insert != -1;

    }

    public boolean deleteone(ClassModel classModel) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CLASS_TABLE + " WHERE " + COLUMN_ID + " = " + classModel.getId();
        Cursor cursor = sqldb.rawQuery(queryString, null);
        return cursor.moveToFirst();

    }
    public void cancelclass(int id) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CLASS_TABLE + " WHERE " + COLUMN_ID + " = " + id;
        sqldb.execSQL(queryString);
    }

    public List<ClassModel> getAll() {
        List<ClassModel> allList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CLASS_TABLE;
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor cursor = sqldb.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                int classID = cursor.getInt(0);
                String className = cursor.getString(1);
                String classDes = cursor.getString(2);
                String classinstructor = cursor.getString(3);
                String classdifficulty=cursor.getString(4);
                String classdate=cursor.getString(5);
                String classhours=cursor.getString(6);
                String classcap=cursor.getString(7);
                ClassModel newclass = new ClassModel(classID, className, classDes,classinstructor,classdifficulty,classdate,classhours,classcap);
                allList.add(newclass);

            } while (cursor.moveToNext());
        } else {

        }

        cursor.close();
        sqldb.close();
        return allList;
    }

    public List<ClassModel> getOwnedClass(String instructor){
        List<ClassModel> ownclass = new ArrayList<>();
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor oc = sqldb.rawQuery("SELECT * FROM CLASS_TABLE where INSTRUCTOR = ?", new String[]{instructor});
        if (oc.moveToFirst()) {
            do {
                int classID = oc.getInt(0);
                String className = oc.getString(1);
                String classDes = oc.getString(2);
                String classdifficulty=oc.getString(4);
                String classinstructor = oc.getString(3);
                String classdate=oc.getString(5);
                String classhours=oc.getString(6);
                String classcap=oc.getString(7);
                ClassModel newclass = new ClassModel(classID, className, classDes,classinstructor,classdifficulty,classdate,classhours,classcap);
                ownclass.add(newclass);

            } while (oc.moveToNext());
        } else {

        }

        oc.close();
        sqldb.close();
        return ownclass;
    }

    public List<ClassModel> search(String classname){
        List<ClassModel> ownclass = new ArrayList<>();
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor oc = sqldb.rawQuery("SELECT * FROM CLASS_TABLE where CLASS_NAME = ?", new String[]{classname});
        if (oc.moveToFirst()) {
            do {
                int classID = oc.getInt(0);
                String className = oc.getString(1);
                String classDes = oc.getString(2);
                String classdifficulty=oc.getString(4);
                String classinstructor = oc.getString(3);
                String classdate=oc.getString(5);
                String classhours=oc.getString(6);
                String classcap=oc.getString(7);
                ClassModel newclass = new ClassModel(classID, className, classDes,classinstructor,classdifficulty,classdate,classhours,classcap);
                ownclass.add(newclass);

            } while (oc.moveToNext());
        } else {

        }

        oc.close();
        sqldb.close();
        return ownclass;
    }

    public boolean addUser(UserModel userModel) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLUMN_USER, userModel.getUsername());
        value.put(COLUMN_PASS, userModel.getPassword());
        value.put(COLUMN_IDENTITY, userModel.getIdentity());
        long result = sqldb.insert(USER_TABLE, null, value);
        return result != -1;

    }

    public boolean Verify_Account(String username) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor member_Account = sqldb.rawQuery("SELECT * FROM USER_TABLE where USER = ?", new String[]{username});
        if (member_Account.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean Verify_password(String username, String password, String identity){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor Accountinfo = sqldb.rawQuery("SELECT* FROM USER_TABLE where USER = ? and PASS = ? and IDENTITY = ?", new String[]{username, password, identity});
        if (Accountinfo.getCount()>0){
            return true;
        }else{
            return false;

        }
    }
    public boolean Verify_Classname(String classname, String instructor) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        Cursor classn = sqldb.rawQuery("SELECT * FROM CLASS_TABLE where CLASS_NAME = ? and INSTRUCTOR = ?", new String[]{classname,instructor});
        if (classn.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void UpdateClass(int id, String instructor,String difficult,String date,String hours,String capacity){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String query = "UPDATE " + CLASS_TABLE + " SET " + COLUMN_INSTRUCTOR +
            " = '" + instructor + "' , " + COLUMN_DIFFICULT + " = '" + difficult + "' , " +
                COLUMN_TIME + " = '" + date + "' , " + COLUMN_HOUR + " = '" + hours + "' , " + COLUMN_CAP+ " = '" + capacity + "' WHERE " +  COLUMN_ID + "= '" + id +"'";
        sqldb.execSQL(query);
    }

//    public Cursor getWordMatches(String query, String[] columns) {
//        String selection = COLUMN_CLASS_NAME + " MATCH ?";
//        String[] selectionArgs = new String[] {query+"*"};
//
//        return query(selection, selectionArgs, columns);
//    }
//
//    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
//        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
//        builder.setTables(CLASS_TABLE);
//
//        Cursor cursor = builder.query(getReadableDatabase(),
//                columns, selection, selectionArgs, null, null, null);
//
//        if (cursor == null) {
//            return null;
//        } else if (!cursor.moveToFirst()) {
//            cursor.close();
//            return null;
//        }
//        return cursor;
//    }

//    public boolean Verify_identify(String member_identity ){
//        SQLiteDatabase sqldb = this.getWritableDatabase();
//        Cursor identify = sqldb.rawQuery("SELECT * FROM USER_TABLE where IDENTITY = ?", new String[]{member_identity});
//        if (identify.getCount()>0){
//            return true;
//        }else{
//            return false;
//        }
//    }
}
