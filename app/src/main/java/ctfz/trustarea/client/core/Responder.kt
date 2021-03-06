package ctfz.trustarea.client.core

import android.content.Context
import android.content.Intent
import ctfz.trustarea.client.network.data.asErrorNetworkEntity
import ctfz.trustarea.client.repository.LogRepository
import ctfz.trustarea.client.service.data.errorIntent
import okhttp3.ResponseBody


class Responder {

    companion object {

        const val EXTRA_CALLBACK = IMS.RETURN_WITH_ACTION_NAME

        fun sendSuccess(logger: LogRepository, TAG: String, context: Context, response: Intent?, request: Intent) {

            val ims = IMS(context)

            logger.info(TAG, "Success: Send response to ${ims.extractReturnAction(request)}")
            ims.replyTo(request, response ?: Intent())

        }

        fun sendError(logger: LogRepository, TAG: String, context: Context, errorBody: ResponseBody?, request: Intent) {
            val ims = IMS(context)
            val error = errorBody?.asErrorNetworkEntity()
            logger.info(TAG, "Error: Return message: ${error?.message}; errors: ${error?.errors}")
            logger.info(TAG, "Error: Send response to ${ims.extractReturnAction(request)}")

            ims.replyTo(request, errorIntent(error?.message!!, error.errors))

        }

        fun sendException(logger: LogRepository, TAG: String, context: Context, message: String?, request: Intent) {
            val ims = IMS(context)
            logger.info(TAG, "Exception: Send response to ${ims.extractReturnAction(request)} with message ${message}")
            ims.replyTo(request, errorIntent("Request failure", listOf(message ?: "msg exception is null :( ")))
        }
    }
}
