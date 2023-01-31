package com.example.backgroudtask.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.backgroudtask.contacts.Contacts;
import com.example.backgroudtask.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ Params.TABLE_NAME+ "(" + Params.KEY_ID+ " INTEGER PRIMARY KEY, " + Params.KEY_NAME + " TEXT, "+ Params.KEY_PHONE+" TEXT )" ;
        Log.d("kashish", create);
        db.execSQL(create);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues() ;

        values.put(Params.KEY_NAME, contacts.getName());
//        values.put(Params.KEY_ID, contacts.getId()); you should not set ID cuz it's PRIMARY KEY
        values.put(Params.KEY_PHONE, contacts.getNumber());
        db.insert(Params.TABLE_NAME, null, values);
        Log.d("kashish", "Value inserted");
        db.close();
    }
    public void getContacts(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Params.TABLE_NAME, new String[]{Params.KEY_ID, Params.KEY_NAME, Params.KEY_PHONE},id+"=?", new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
                Log.d("kashish", cursor.getString(0));
                Log.d("kashish", cursor.getString(1));
                Log.d("kashish", cursor.getString(2));
                Log.d("kashish", cursor.getString(3));
        }
    }
    public List<Contacts> getAllContacts(){
        List<Contacts> contactsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setNumber(cursor.getString(2));
                contactsList.add(contacts);
            }while(cursor.moveToNext());
        }
        return contactsList;

    }
    public int updateContact(Contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getNumber());
//        db.close(); //can't use 'close()' here cuz we have to use update() below
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID+"=?", new String[]{String.valueOf(contact.getId())}); //it returns number of affected rows

    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor curson = db.rawQuery(query, null);
        return curson.getCount();
    }
}
