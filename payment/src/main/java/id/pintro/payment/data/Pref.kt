package id.pintro.payment.data

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/**
 * Created by simx on 29,April,2019
 */
class Pref(var context: Context) {
    private var pref: SharedPreferences? = null
    private val KEY_BASE_URL = "key_url"
    private val KEY_TOKEN = "key_token"
    private val KEY_APP_ID = "key_app_id"
    private val KEY_CLINET_ID = "key_client_id"
    private val KEY_DONATIONS = "key_donations"

    init {
        pref = PreferenceManager.getDefaultSharedPreferences(context)
    }

    var base_url : String
        get() =  pref!!.getString(KEY_BASE_URL,"")!!
        set(value) = pref!!.edit().putString(KEY_BASE_URL, value).apply()

    var token: String
        get() =  pref!!.getString(KEY_TOKEN,"")!!
        set(value) = pref!!.edit().putString(KEY_TOKEN, value).apply()

    var appId: Int
        get() =  pref!!.getInt(KEY_APP_ID,0)
        set(value) = pref!!.edit().putInt(KEY_APP_ID, value).apply()

    var clientId: Int
        get() =  pref!!.getInt(KEY_CLINET_ID,0)
        set(value) = pref!!.edit().putInt(KEY_CLINET_ID, value).apply()


    var isDonations: Boolean
        get() =  pref!!.getBoolean(KEY_DONATIONS,false)
        set(value) = pref!!.edit().putBoolean(KEY_DONATIONS, value).apply()


    fun clear(){
        pref!!.edit().clear()
    }
}