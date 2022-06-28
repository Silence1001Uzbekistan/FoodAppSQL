package uz.silence.foodappsql.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.silence.foodappsql.CLASS.Food
import uz.silence.foodappsql.CONSTANT.Constant

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.DB_VERSION), DatabaseService {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique,${Constant.NAME} text not null,${Constant.PRODUCT} text not null,${Constant.SYSTEM} text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(p0)
    }

    override fun addContact(food: Food) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, food.foodName)
        contentValues.put(Constant.PRODUCT, food.mustProduct)
        contentValues.put(Constant.SYSTEM, food.foodSystem)
        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun getAllContacts(): ArrayList<Food> {

        val list = ArrayList<Food>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {

                val food = Food(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
                list.add(food)

            } while (cursor.moveToNext())

        }

        return list

    }

    override fun getContactById(id: Int): Food {

        val database = this.readableDatabase
        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.NAME, Constant.PRODUCT, Constant.SYSTEM),
            "${Constant.ID} = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        cursor?.moveToFirst()

        return Food(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3))

    }
}