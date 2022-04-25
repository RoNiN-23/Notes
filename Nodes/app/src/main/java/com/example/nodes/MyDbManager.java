package com.example.nodes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 @brief Класс реалицующий логику работы запросов БД

 */

public class MyDbManager {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        myDbHelper = new MyDbHelper(context);
    }
    public void openDb(){                                                                       //Открытие БД
        db = myDbHelper.getWritableDatabase();
    }
    /**
	@brief Метод записи данных в базу данных

	Считав с определённых полей заголовок и саму заметку этот метод добавляет ID (Уникальный идентификатор) и записывает ёё в базу данных
*/
    public void insertToDb(String title, String description){                                   //Метод записи в БД
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.TITLE, title);
        cv.put(MyConstants.DESCRIPTION, description);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }
    /**
        @brief Метод чтения из базы данных

        Чтение из базы данных происходит в массив, а точнее в List, который затем возвращает выше указанный метод
    */
    public List<String> getFromDb(){                                                            //Метод чтения из БД
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null,
                null, null, null,null);

        while (cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MyConstants.TITLE));
            tempList.add(title);
        }
        cursor.close();
        return tempList;
    }

    public void closeDb(){                                                                      //Закрытие БД
        myDbHelper.close();
    }
}
