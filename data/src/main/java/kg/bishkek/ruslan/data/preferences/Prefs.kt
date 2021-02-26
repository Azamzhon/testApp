package kg.bishkek.ruslan.data.preferences

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * this delegate for synchronization value your string-variable to SharedPreference
 *
 * @param1 prefs is SharedPreferences for write any data to SharedPreferences
 */
class StringSPDelegate(private val prefs: SharedPreferences) {

    /**
     * this method is triggered when the everyone called your variable
     *
     * @param thisRef must be the same or a supertype of the property owner (for extension properties, it should be the type being extended).
     * @param property must be of type KProperty<*> or its supertype
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return prefs.getString(property.name, "defValue").toString()
    }

    /**
     * this method is triggered when the value of the your variable changes
     *
     * @param thisRef must be the same or a supertype of the property owner (for extension properties, it should be the type being extended).
     * @param property must be of type KProperty<*> or its supertype
     * @param value must be of the same type as the property (or its supertype).
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        prefs.edit().putString(property.name, value).apply()
    }
}

class IntSPDelegate(private val prefs: SharedPreferences) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return prefs.getInt(property.name, 0)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        prefs.edit().putInt(property.name, value).apply()
    }
}

