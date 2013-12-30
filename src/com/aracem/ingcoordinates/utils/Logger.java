
package com.aracem.ingcoordinates.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

/**
 * Simplifies the process of log an app
 * 
 * @author Jose I. Honrado Idea and first version of Logger
 * @author Marcos Trujillo Added some changes to create a static showLogs var
 *         Edit the class to change the TAG. Now the TAG is
 *         {@link GlobalConstants.LOG.TAG} + " " + tag
 * @version 1.0
 * @version 1.3 Adds log levels to the logs
 */
public class Logger {
    private static final boolean SHOW_LOGS = true;
    private static final String TAG = "INGCoordinates";
    private static boolean showLogs = SHOW_LOGS;

    protected static boolean isShowLogs() {
        return Logger.showLogs;
    }

    protected static void enableLogs() {
        Logger.showLogs = true;
    }

    protected static void disableLogs() {
        Logger.showLogs = false;
    }

    protected static void showLogs(boolean showLogs) {
        Logger.showLogs = showLogs;
    }

    /**
     * Log text with INFO tag
     */
    protected static void i(String text) {
        i(text, "");
    }

    /**
     * Log text with WARNING tag
     */
    protected static void w(String text) {
        w(text, "");
    }

    /**
     * Log text with ERROR tag
     */
    protected static void e(String text) {
        e(text, "");
    }

    /**
     * Log text with VERBOSE tag
     */
    protected static void v(String text) {
        v(text, "");
    }

    /**
     * Log text with DEBUG tag
     */
    protected static void d(String text) {
        d(text, "");
    }

    /**
     * Log text with DEBUG tag
     */
    protected static void wtf(String text) {
        wtf(text, "");
    }

    // ##############################################################

    /**
     * Log text with INFO tag
     */
    protected static void i(String text, Object obj) {
        i(text, obj.getClass().getSimpleName());
    }

    /**
     * Log text with WARNING tag
     */
    protected static void w(String text, Object obj) {
        w(text, obj.getClass().getSimpleName());
    }

    /**
     * Log text with ERROR tag
     */
    protected static void e(String text, Object obj) {
        e(text, obj.getClass().getSimpleName());
    }

    /**
     * Log text with VERBOSE tag
     */
    protected static void v(String text, Object obj) {
        v(text, obj.getClass().getSimpleName());
    }

    /**
     * Log text with DEBUG tag
     */
    protected static void d(String text, Object obj) {
        d(text, obj.getClass().getSimpleName());
    }

    /**
     * Log text with WTF tag
     */
    protected static void wtf(String text, Object obj) {
        wtf(text, obj.getClass().getSimpleName());
    }

    // ##############################################################

    /**
     * Log text with INFO tag
     */
    protected static void i(String text, String tag) {
        if (showLogs) {
            Log.i(TAG + tag, text);
        }
    }

    /**
     * Log text with WARNING tag
     */
    protected static void w(String text, String tag) {
        if (showLogs) {
            Log.w(TAG + tag, text);
        }
    }

    /**
     * Log text with ERROR tag
     */
    protected static void e(String text, String tag) {
        if (showLogs) {
            Log.e(TAG + tag, text);
        }
    }

    /**
     * Log text with VERBOSE tag
     */
    protected static void v(String text, String tag) {
        if (showLogs) {
            Log.v(TAG + tag, text);
        }
    }

    /**
     * Log text with DEBUG tag
     */
    protected static void d(String text, String tag) {
        if (showLogs) {
            Log.d(TAG + tag, text);
        }
    }

    /**
     * Log text with DEBUG tag
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    protected static void wtf(String text, String tag) {
        if (showLogs && Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
            Log.d(TAG + tag, text);
        }
    }
}
