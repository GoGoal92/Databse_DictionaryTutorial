package com.example.databse_dictionarytutorial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_sql extends SQLiteOpenHelper {

	SQLiteDatabase mdb;
	private static String DB_PATH = "/data/data/com.example.databse_dictionarytutorial/databases/";
	Context con;

	public Database_sql(Context context) {
		super(context, "dic.db", null, 1);
		// TODO Auto-generated constructor stub
		this.con = context;
	}

	private void createDir() throws IOException {
		File localFile = new File(DB_PATH);
		if (!localFile.exists()) {
			localFile.mkdir();
			copyDataBase();
		}
	}

	public void copyDataBase() throws IOException {
		InputStream localInputStream = this.con.getAssets().open("dic.db");
		FileOutputStream localFileOutputStream = new FileOutputStream(DB_PATH
				+ "dic.db");
		byte[] arrayOfByte = new byte[1024];
		while (true) {
			int i = localInputStream.read(arrayOfByte);
			if (i <= 0) {
				localFileOutputStream.flush();
				localFileOutputStream.close();
				localInputStream.close();
				return;
			}
			localFileOutputStream.write(arrayOfByte, 0, i);
		}
	}

	public void copying() {
		// TODO Auto-generated method stub
		try {
			createDir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public ArrayList<get> getselect_all_data(String string) {
		// TODO Auto-generated method stub

		ArrayList<get> list = new ArrayList<get>();
		mdb = getReadableDatabase();
		String sql = "SELECT * FROM dic WHERE  word LIKE '%"+string+"'";
		Cursor c = mdb.rawQuery(sql, null);
		if (c.moveToFirst()) {
			do {
				get eg = new get();
				eg.setWord(c.getString(0));
				eg.setGrammar(c.getString(1));
				eg.setDetail(c.getString(1));
				list.add(eg);
			} while (c.moveToNext());

		}
		mdb.close();
		return list;
	}

}
