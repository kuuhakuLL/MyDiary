package com.example.mydiary.helpers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mydiary.models.Task

class DBHelper(context: Context?) :
    SQLiteOpenHelper(
        context,
            DATABASE_NAME,
        null,
            DATABASE_VERSION
    ) {
    var cursor: Cursor? = null
    var columns: Array<String>? = null
    var selection: String? = null
    var selectionArgs: Array<String>? = null
    var groupBy: String? = null
    var having: String? = null
    var orderBy: String? = null

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table $TABLE_TASKS"+
                "( $KEY_ID integer primary key, $KEY_NAME text, $KEY_DESCRIPTION text, $KEY_START text, $KEY_TIMER text, $KEY_DATE text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists $TABLE_TASKS")
        onCreate(db)
    }

    fun addTask(task: Task):Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, task.name)
        contentValues.put(KEY_DESCRIPTION, task.description)
        contentValues.put(KEY_START, task.start)
        contentValues.put(KEY_TIMER, task.timer)
        contentValues.put(KEY_DATE, task.date)
        val success = db.insert(TABLE_TASKS, null, contentValues)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    fun getDayTasks(date:String): MutableList<Task>{
        val db = this.writableDatabase
        var tasks: MutableList<Task> = ArrayList()
        selection = "$KEY_DATE == ?"
        selectionArgs = arrayOf(date)
        orderBy = KEY_START
        cursor = db.query(TABLE_TASKS, null, selection, selectionArgs, null, null, orderBy)
        if (cursor != null) {
            if (cursor!!.moveToFirst()) {
                do {
                    var id = cursor!!.getInt(cursor!!.getColumnIndex(KEY_ID))
                    var name = cursor!!.getString(cursor!!.getColumnIndex(KEY_NAME))
                    var description = cursor!!.getString(cursor!!.getColumnIndex(KEY_DESCRIPTION))
                    var start = cursor!!.getString(cursor!!.getColumnIndex(KEY_START))
                    var finish = cursor!!.getString(cursor!!.getColumnIndex(KEY_TIMER))
                    var date = cursor!!.getString(cursor!!.getColumnIndex(KEY_DATE))

                    var task = Task(id, name, description, start, finish, date)
                    tasks.add(task)

                } while (cursor!!.moveToNext())
            }
        }
        return tasks
    }

//    fun getTask(id: Int): Task? {
//        val db = this.writableDatabase
//        selection = "$KEY_ID == ?"
//        selectionArgs = arrayOf(id.toString())
//        orderBy = KEY_START
//        var task: Task? = null
//        cursor = db.query(TABLE_TASKS, null, selection, selectionArgs, null, null, orderBy)
//        if (cursor == null) {
//            cursor!!.moveToFirst()
//            var name = cursor!!.getString(cursor!!.getColumnIndex(KEY_NAME))
//            var description = cursor!!.getString(cursor!!.getColumnIndex(KEY_DESCRIPTION))
//            var start = cursor!!.getString(cursor!!.getColumnIndex(KEY_START))
//            var finish = cursor!!.getString(cursor!!.getColumnIndex(KEY_TIMER))
//            var date = cursor!!.getString(cursor!!.getColumnIndex(KEY_DATE))
//            task = Task(id, name, description, start, finish, date)
//        }
//        return task
//    }

    companion object {
        const val DATABASE_VERSION = 3
        const val DATABASE_NAME = "contactDb"
        const val TABLE_TASKS = "Tasks"
        const val KEY_ID = "Id"
        const val KEY_NAME = "Name"
        const val KEY_DESCRIPTION = "Description"
        const val KEY_START = "Start"
        const val KEY_TIMER = "Timer"
        const val KEY_DATE = "Date"


    }
}