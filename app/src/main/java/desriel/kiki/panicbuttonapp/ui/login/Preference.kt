package desriel.kiki.panicbuttonapp.ui.login

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.appcompat.app.AppCompatDelegate

class Preference(context: Context) {
    private val preference = context.getSharedPreferences(
        context.packageName,
        MODE_PRIVATE
    )
    private val editor = preference.edit()
    private val keyLogin = "login_data"
    private val keyViewType = "view_type"

    var viewType
        get() = preference.getInt(keyViewType, 1)
        set(value){
            editor.putInt(keyViewType,value)
            editor.commit()
        }
    var login
        get() = preference.getString(keyLogin, "")
        set(value) {
            editor.putString(keyLogin, value)
            editor.commit()
        }
    fun clearLogin() {
        editor.remove(keyLogin)
        editor.apply()
    }

}


