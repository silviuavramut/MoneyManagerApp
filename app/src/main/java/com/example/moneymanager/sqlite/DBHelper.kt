package com.example.moneymanager.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.moneymanager.model.Expense
import com.example.moneymanager.model.User

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
        db?.execSQL(SQL_CREATE_ENTRIES2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db?.execSQL(SQL_DELETE_ENTRIES)
        db?.execSQL(SQL_DELETE_ENTRIES2)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertUser(user: User): Boolean {
// Gets the data repository in write mode
        val db = writableDatabase
// Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(USER_FIRSTNAME, user.firstName)
        values.put(USER_LASTNAME, user.lastName)
        values.put(USER_EMAIL, user.email)
        values.put(USER_PASS, user.password)

// Insert the new row, returning the primary key value of the new row
        db.insert(TABLE_NAME, null, values)
        db.close()
        return true
    }
    @Throws(SQLiteConstraintException::class)
    fun insertExpense(expense: Expense): Boolean {
// Gets the data repository in write mode
        val db = writableDatabase
// Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(EXPENSE_TYPE, expense.type)
        values.put(EXPENSE_DATE, expense.date)
        values.put(EXPENSE_ACCOUNT, expense.account)
        values.put(EXPENSE_CATEGORY, expense.category)
        values.put(EXPENSE_AMOUNT, expense.amount)
        values.put(EXPENSE_NOTE, expense.note)

// Insert the new row, returning the primary key value of the new row
        db.insert(TABLE_NAME2, null, values)
        db.close()
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteUser(userid: String): Boolean {
// Gets the data repository in write mode
        val db = writableDatabase
// Define 'where' part of query.
        val selection = USER_ID + " LIKE ?"
// Specify arguments in placeholder order.
        val selectionArgs = arrayOf(userid)
// Issue SQL statement.
        db.delete(TABLE_NAME, selection, selectionArgs)
        return true
    }
    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    fun checkUser(email: String,password:String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(USER_ID)
        val db = this.readableDatabase

        // selection criteria
// selection criteria
        val selection = "$USER_EMAIL = ? AND $USER_PASS = ?"
        // selection arguments
        val selectionArgs = arrayOf(email, password)

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'abc@d.com';
         */
        val cursor = db.query(
            TABLE_NAME, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null
        )  //The sort order

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }
        return false
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    fun checkifUserExists(email: String): Boolean {
        // array of columns to fetch
        val columns = arrayOf(USER_ID)
        val db = this.readableDatabase
        // selection criteria
        val selection = "$USER_EMAIL = ?"
        // selection argument
        val selectionArgs = arrayOf(email)
        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        val cursor = db.query(TABLE_NAME, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null)  //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        if (cursorCount > 0) {
            return true
        }
        return false
    }

    fun getUserIdByEmail(email: String): Int {

        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME, null, "$USER_EMAIL = ?", arrayOf(email),
            null, null, null
        )
        if (cursor.getCount() < 1) {
            return 0;
        } else {
            cursor.moveToFirst()
            val userID: Int = cursor.getString(cursor.getColumnIndexOrThrow(USER_ID)).toInt()
            return userID;
        }
    }

    fun getAllUser(): ArrayList <User>{

        // array of columns to fetch
        val columns = arrayOf(USER_FIRSTNAME, USER_LASTNAME, USER_EMAIL, USER_PASS)

        // sorting orders
        val sortOrder = "$USER_LASTNAME ASC"
        val userList = ArrayList<User>()

        val db = this.readableDatabase

        // query the user table
        val cursor = db.query(
            TABLE_NAME, //Table to query
            columns,            //columns to return
            null,     //columns for the WHERE clause
            null,  //The values for the WHERE clause
            null,      //group the rows
            null,       //filter by row groups
            sortOrder
        )         //The sort order
        if (cursor.moveToFirst()) {
            do {
                val user = User(
                    firstName = cursor.getString(cursor.getColumnIndexOrThrow(USER_FIRSTNAME)),
                    lastName = cursor.getString(cursor.getColumnIndexOrThrow(USER_LASTNAME)),
                    email = cursor.getString(cursor.getColumnIndexOrThrow(USER_EMAIL)),
                    password = cursor.getString(cursor.getColumnIndexOrThrow(USER_PASS))
                )

                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }
    fun getAllExpense(): ArrayList <Expense>{

        // array of columns to fetch
        val columns = arrayOf(EXPENSE_TYPE, EXPENSE_DATE, EXPENSE_ACCOUNT, EXPENSE_CATEGORY,
            EXPENSE_AMOUNT, EXPENSE_NOTE)

        // sorting orders
        val sortOrder = "$EXPENSE_DATE ASC"
        val expenseList = ArrayList<Expense>()

        val db = this.readableDatabase

        // query the user table
        val cursor = db.query(
            TABLE_NAME2, //Table to query
            columns,            //columns to return
            null,     //columns for the WHERE clause
            null,  //The values for the WHERE clause
            null,      //group the rows
            null,       //filter by row groups
            sortOrder
        )         //The sort order
        if (cursor.moveToFirst()) {
            do {
                val expense = Expense(
                    type = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_TYPE)),
                    date = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_DATE)),
                    account = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_ACCOUNT)),
                    category = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_CATEGORY)),
                    amount = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_AMOUNT)),
                    note = cursor.getString(cursor.getColumnIndexOrThrow(EXPENSE_NOTE))

                )

                expenseList.add(expense)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return expenseList
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "MMApp.db"
        val TABLE_NAME = "USER";
        val USER_ID = "USER_ID";
        val USER_FIRSTNAME = "FIRSTNAME";
        val USER_LASTNAME = "LASTNAME";
        val USER_EMAIL = "EMAIL";
        val USER_PASS = "PASS";
        val TABLE_NAME2 = "EXPENSE";
        val EXPENSE_ID = "EXPENSE_ID";
        val EXPENSE_TYPE = "TYPE";
        val EXPENSE_DATE = "DATE";
        val EXPENSE_ACCOUNT = "ACCOUNT";
        val EXPENSE_CATEGORY = "CATEGORY";
        val EXPENSE_AMOUNT = "AMOUNT";
        val EXPENSE_NOTE = "NOTE";

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    USER_FIRSTNAME + " TEXT NOT NULL,"+
                    USER_LASTNAME + " TEXT NOT NULL," +
                    USER_EMAIL + " TEXT NOT NULL," +
                    USER_PASS + " TEXT NOT NULL)"

        private val SQL_CREATE_ENTRIES2 =
            "CREATE TABLE " + TABLE_NAME2 + "(" +
                    EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EXPENSE_TYPE + " TEXT NOT NULL,"+
                    EXPENSE_DATE + " TEXT NOT NULL," +
                    EXPENSE_ACCOUNT + " TEXT NOT NULL," +
                    EXPENSE_CATEGORY + " TEXT NOT NULL," +
                    EXPENSE_AMOUNT + " INTEGER NOT NULL," +
                    EXPENSE_NOTE + " TEXT NOT NULL)"



        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME
        private val SQL_DELETE_ENTRIES2 = "DROP TABLE IF EXISTS " + TABLE_NAME2
    }
}