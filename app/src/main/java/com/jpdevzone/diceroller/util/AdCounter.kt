package com.jpdevzone.diceroller.util

import android.content.Context

object AdCounter {
    fun getAdCounter(context: Context): Int {
        val prefs = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
        return prefs.getInt(Constants.AD_COUNTER, 0)
    }

    fun setAdCounter(context: Context, int: Int) {
        val prefs = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt(Constants.AD_COUNTER, int)
        editor.apply()
    }
}