package kg.bishkek.ruslan.data.preferences

import android.content.Context
import android.content.SharedPreferences
import kg.bishkek.ruslan.data.utils.SHARED_PREFERENCES_NAME

/**
 * this class help you for provide SharedPreferences
 *
 * @param context is Context for init SharedPreferences
 */
class SharedPreferencesProvider(private val context: Context) {

    /**
     * this method provide SharedPreferences
     *
     * @return SharedPreferences for write any data to SharedPreferences
     */
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

}