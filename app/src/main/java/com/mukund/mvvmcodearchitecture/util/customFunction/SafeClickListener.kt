package com.mukund.mvvmcodearchitecture.util.customFunction

import android.os.SystemClock
import android.view.View

class SafeClickListener(
    private val defaultInterval: Int = 2000,
    private val onSafeClick: (View) -> Unit
) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        if(SystemClock.elapsedRealtime()-lastTimeClicked<defaultInterval)
        {
            return
        }
        lastTimeClicked=SystemClock.elapsedRealtime()
        onSafeClick(v)
    }


}