package uz.silence.foodappsql.DB

import uz.silence.foodappsql.CLASS.Food

interface DatabaseService {

    fun addContact(food: Food)

    fun getAllContacts():ArrayList<Food>

    fun getContactById(id:Int):Food

}