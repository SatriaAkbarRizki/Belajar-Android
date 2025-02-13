package com.example.loginslincing.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.loginslincing.model.LoginModel

class LoginDatabase(context: Context)  : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    companion object {
        private const val DATABASE_NAME = "Login.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "my_login"
        const val COLUMN_ID = "id"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_ADDRESS = "address"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun onCreate(db: SQLiteDatabase) {
        val queryDatabase = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PASSWORD TEXT,
                $COLUMN_ADDRESS TEXT
            )""".trimIndent()
        db.execSQL(queryDatabase)
    }

    fun insertSignUp(data : LoginModel) {
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, data.Email)
            put(COLUMN_PASSWORD, data.Password)
            put(COLUMN_ADDRESS, data.Address)
        }
        val db : SQLiteDatabase = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
    }

    fun readDataLogin(): List<LoginModel> {
        val dataList = mutableListOf<LoginModel>()
        val cursor: Cursor = readableDatabase.query(TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(COLUMN_ID))
                val email = getString(getColumnIndexOrThrow(COLUMN_EMAIL))
                val pass = getString(getColumnIndexOrThrow(COLUMN_PASSWORD))
                val address = getString(getColumnIndexOrThrow(COLUMN_ADDRESS))
                dataList.add(LoginModel(id.toInt(), email, pass, address))
            }
        }

        cursor.close()
        return dataList
    }

    fun deleteData(index : Int){
        val whereClause : String = "COLUMN_ID = ?"
        val whereArgs = arrayOf(index.toString())
        writableDatabase.delete(TABLE_NAME,  whereClause, whereArgs)
    }

}