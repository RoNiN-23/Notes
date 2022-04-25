package com.example.nodes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.nodes.MyConstants;

/**
	@brief Класс реалицующий SQL запросы

	Данный класс позволяет при помощи ранее прописанных запросов, создать, запустить или обновить базу данных
*/
public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context) {
        super(context, MyConstants.DB_NAME, null, MyConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyConstants.TABLE_STRUCTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyConstants.DROP_TABLE);
        onCreate(db);
    }
}
