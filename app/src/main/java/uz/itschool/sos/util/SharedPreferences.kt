package uz.itschool.sos.util

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.itschool.sos.model.User

class SharedPreferences private constructor(val context: Context){
    private val shared = context.getSharedPreferences("data", Context.MODE_PRIVATE)
    private val edit = shared.edit()
    val gson = Gson()

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var instance: SharedPreferences? = null
        fun getInstance(context: Context): SharedPreferences {
            if (instance == null){
                instance = SharedPreferences(context)
            }
            return instance!!
        }
    }

    fun setUser(user: User?){
        edit.putString("User", gson.toJson(user)).apply()
    }
    fun getUser(): User?{
        val data = shared.getString("User", "")
        if (data == "") return null
        val typeToken = object : TypeToken<User>() {}.type
        return gson.fromJson(data, typeToken)
    }

    fun logOut(){
        edit.putString("User", "")
    }
}