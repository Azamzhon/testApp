package kg.bishkek.ruslan.data.preferences

import android.content.SharedPreferences

/**
 * this class for change userToken in SharedPreferences
 *
 * @param preferences is remote controller of SharedPreferences for StringSPDelegate
 */
class UserTokenPreferences(private val preferences: SharedPreferences) {

    /**
     * this variable is private access key for of REST api
     */
    var userToken by StringSPDelegate(preferences)
}