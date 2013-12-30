
package com.aracem.ingcoordinates.shared;

import com.aracem.ingcoordinates.utils.Sha1Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedManager {
    private static final String SHARED_NAME = "ingcoordinatescard";
    private static final String KEY_READY = "ready";
    private static final String KEY_PASS = "pass";

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

    /**
     * Saves a password into SharedPreferences
     * 
     * @param pass
     */
    public void savePassword(String pass) {
        if (pass != null && !"".equals(pass)) {
            pass = Sha1Utils.generateSHA1toString(pass);
            if (!"".equals(pass)) {
                mPreferences.edit().putString(KEY_PASS, pass);
            }
        }
    }

    /**
     * @return true when the password is equals than the saved password in
     *         shared preferences
     * @param password
     */
    public boolean checkPassword(String password) {
        if (password == null || "".equals(password) || !mPreferences.contains(KEY_PASS))
            return false;

        return mPreferences.getString(KEY_PASS, "")
                .equals(Sha1Utils.generateSHA1toString(password));
    }
}
