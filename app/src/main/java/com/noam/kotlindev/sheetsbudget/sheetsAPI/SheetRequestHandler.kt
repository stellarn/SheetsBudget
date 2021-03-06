package com.noam.kotlindev.sheetsbudget.sheetsAPI

import android.os.Handler
import android.os.HandlerThread
import android.util.Log

class SheetRequestHandler {

    private val requestsHandlerThread: HandlerThread = HandlerThread("SheetRequestHandler")
    private val requestsHandler: Handler
    init {

        requestsHandlerThread.start()
        requestsHandler = Handler(requestsHandlerThread.looper)
    }

    fun postRequest(sheetRequest: SheetRequestRunnerBuilder.SheetRequestRunner){
        Log.d(TAG, "Posting sheetRequest to handler.")
        requestsHandler.post(sheetRequest)
    }
    fun postRequest(apiRequest: Runnable){
        Log.d(TAG, "Posting sheetRequest to handler.")
        requestsHandler.post(apiRequest)
    }
    companion object {
        private  const val TAG= "SheetRequestHandler"
    }
}