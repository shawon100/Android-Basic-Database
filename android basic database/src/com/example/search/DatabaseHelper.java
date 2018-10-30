package com.example.search;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="information";
	private static final String TABLE_NAME="user";
	private static final String KEY_ID="id";
	private static final String KEY_NAME="name";
	private static final String KEY_PN="phone_number";
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"( "+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT, "+KEY_PN+" TEXT );";
        db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void addinfo(Userinfo info)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(KEY_NAME, info.getName());
		values.put(KEY_PN, info.getPhone_number());
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	
	public List<Userinfo> getUser()
	{
		List<Userinfo>userlist=new ArrayList<Userinfo>();
		String sql="SELECT * FROM "+TABLE_NAME;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(sql,null);
		
		if(cursor.moveToFirst())
		{
			do{
				
				Userinfo info=new Userinfo();
				info.setId(Integer.parseInt(cursor.getString(0)));
				info.setName(cursor.getString(1));
				info.setPhone_number(cursor.getString(2));
				userlist.add(info);
				
				
			}while(cursor.moveToNext());
		}
		
		
		
		return userlist;
		
	}
	public List<Userinfo> getUser(String ndata)
	{
		List<Userinfo>userlist=new ArrayList<Userinfo>();
		String sql="SELECT * FROM "+TABLE_NAME+" Where name='"+ndata+"'";
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(sql,null);
		
		if(cursor.moveToFirst())
		{
			do{
				
				Userinfo info=new Userinfo();
				info.setId(Integer.parseInt(cursor.getString(0)));
				info.setName(cursor.getString(1));
				info.setPhone_number(cursor.getString(2));
				userlist.add(info);
				
				
			}while(cursor.moveToNext());
		}
		
		
		
		return userlist;
		
	}

}
