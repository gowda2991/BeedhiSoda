package com.pickwick.ppapers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pickwick.ppapers.DTOs.ExcerptDTO;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "exerptify.db";

    public static final String TABLE_NAME_BOOK = "books";
    public static final String COL_1_BOOK = "book_id";
    public static final String COL_2_BOOK = "book_name";
    public static final String COL_3_BOOK = "cover_image";

    public static final String TABLE_NAME_EXCERPT = "excerpts";
    public static final String COL_1_EXCERPT = "excerpt_id";
    public static final String COL_2_EXCERPT = "book_id";
    public static final String COL_3_EXCERPT = "excerpt_text";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_BOOK + "(" + COL_1_BOOK + " integer primary key autoincrement, "
                + COL_2_BOOK + " varchar(200), " + COL_3_BOOK + " blob )");

        db.execSQL("INSERT INTO books(book_name)\n" +
                "  VALUES(\"test book 1\")");
        db.execSQL("INSERT INTO books(book_name)\n" +
                "  VALUES(\"test book 2\")");
        db.execSQL("INSERT INTO books(book_name)\n" +
                "  VALUES(\"test book 3\")");

        db.execSQL("create table " + TABLE_NAME_EXCERPT + "(" + COL_1_EXCERPT + " integer primary key autoincrement, "
                + COL_2_EXCERPT + " integer, " + COL_3_EXCERPT + " varchar(1000), " +
                " foreign key (" + COL_2_EXCERPT + ")" + " references " + TABLE_NAME_BOOK + "(" + COL_1_BOOK + ")" +
                " )");

        db.execSQL("insert into excerpts (book_id, excerpt_text) values (1, \"Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1  Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 Para 1 \")");
        db.execSQL("insert into excerpts (book_id, excerpt_text) values (2, \"Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2 Para 2\")");
        db.execSQL("insert into excerpts (book_id, excerpt_text) values (3, \"Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 Para 3 \")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME_BOOK);
        db.execSQL("drop table if exists " + TABLE_NAME_EXCERPT);
        onCreate(db);
    }

    public List<ExcerptDTO> getExcerptsList() {

        String sql = "select e." + COL_1_BOOK + ", e." + COL_1_EXCERPT + ", b." + COL_2_BOOK + ", e." + COL_3_EXCERPT +
                " from " + TABLE_NAME_BOOK + " b join " + TABLE_NAME_EXCERPT + " e on e.book_id = b.book_id";

        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);

        ArrayList<ExcerptDTO> excerptList = new ArrayList<>();
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    int bookId = Integer.parseInt(cursor.getString(0));
                    int excerptId = Integer.parseInt(cursor.getString(1));
                    String bookName = cursor.getString(2);
                    String excerptText = cursor.getString(3);
                    ExcerptDTO dto = new ExcerptDTO(bookId, excerptId, bookName, excerptText);
                    excerptList.add(dto);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return excerptList;
    }
}
