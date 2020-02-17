package com.zfr.ctfzoneclient.service.view

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import android.widget.Toast

// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_CREATE_USER = "com.zfr.ctfzoneclient.action.CREATE_USER"
private const val ACTION_GET_USER = "com.zfr.ctfzoneclient.action.GET_USER"
private const val ACTION_EDIT_USER = "com.zfr.ctfzoneclient.action.EDIT_USER"
private const val ACTION_DELETE_USER = "com.zfr.ctfzoneclient.action.DELETE_USER"

const val EXTRA_USER_NAME = "com.zfr.ctfzoneclient.extra.USER_NAME"
//const val EXTRA_PARAM2 = "com.zfr.ctfzoneclient.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * helper methods.
 */
class UserService : IntentService("UserService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_CREATE_USER -> {
                val user_name = intent.getStringExtra(EXTRA_USER_NAME)
                // val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionCreateUser(user_name)
            }
            ACTION_GET_USER -> {
                val user_name = intent.getStringExtra(EXTRA_USER_NAME)
                handleActionGetUser(user_name)
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionCreateUser(user_name: String?) {
        Log.d("Test", "handleActionCreateUser Called")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionGetUser(user_name: String?) {
        Log.d("Test", "handleActionGetUser Called")
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionCreateUser(context: Context, user_name: String) {
            val intent = Intent(context, UserService::class.java).apply {
                action = ACTION_CREATE_USER
                putExtra(EXTRA_USER_NAME, user_name)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionGetUser(context: Context, user_name: String?) {
            val intent = Intent(context, UserService::class.java).apply {
                action = ACTION_GET_USER
                putExtra(EXTRA_USER_NAME, user_name)
            }
            context.startService(intent)
        }
    }
}
