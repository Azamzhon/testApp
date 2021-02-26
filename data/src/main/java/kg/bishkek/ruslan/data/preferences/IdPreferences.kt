package kg.bishkek.ruslan.data.preferences

import android.content.SharedPreferences

class IdPreferences(preferences: SharedPreferences) {
    var id by IntSPDelegate(preferences)
}