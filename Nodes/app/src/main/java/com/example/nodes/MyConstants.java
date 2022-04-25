package com.example.nodes;
/**
	@brief Класс создания базы данных и таблицы, а также последующее её обновление

	Используя SQL запросы, создается и обнавляется база данных и таблицы в ней
*/
public class MyConstants {
    public static final String TABLE_NAME = "Nodes";
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DB_NAME = "dbNodes.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," +
            DESCRIPTION + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
