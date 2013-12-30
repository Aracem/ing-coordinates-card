
package com.aracem.ingcoordinates.shared;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedManager {
    private static final String SHARED_NAME = "ingcoordinatescard";
    private static final String KEY_READY = "ready";

    private final SharedPreferences mPreferences;

    public SharedManager(Context context) {
        mPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
    }

    /**
     * @return true when the passCode and the coordinates are configured
     */
    public boolean arePreferencesConfigured() {
        return mPreferences.getBoolean(KEY_READY, false);
    }

}
