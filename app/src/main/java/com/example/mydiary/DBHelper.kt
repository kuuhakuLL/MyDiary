/*
package com.example.mydiary

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DB_NAME: String? = "test"
val DB_VERSION: Int = 1

class DBHelper(context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {

    val TABLE_NAME: String = "users";
    val LOGIN: String = "login";
    val PASSW: String = "passw";
    val CREATE_TABLE: String  = "create table $TABLE_NAME ( _id integer primary key autoincrement, $LOGIN , $PASSW )"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
*/
