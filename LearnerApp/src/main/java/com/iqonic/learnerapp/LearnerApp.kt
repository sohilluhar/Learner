package com.iqonic.learnerapp

import android.app.Application
import android.app.Dialog
import android.content.Context
import androidx.multidex.MultiDex
import com.iqonic.learnerapp.utils.LearnerAppSharedPrefUtils
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class LearnerApp : Application(){
    override fun onCreate() {
        super.onCreate()
        appInstance = this

        // Set Custom Font
        ViewPump.init(ViewPump.builder().addInterceptor(CalligraphyInterceptor(
                CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.learn_font_regular)).setFontAttrId(R.attr.fontPath).build())
        ).build())
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    companion object {
        private lateinit var appInstance: LearnerApp
        var sharedPrefUtils: LearnerAppSharedPrefUtils? = null
        var noInternetDialog : Dialog?= null

        fun getAppInstance(): LearnerApp {
            return appInstance
        }
    }

}
