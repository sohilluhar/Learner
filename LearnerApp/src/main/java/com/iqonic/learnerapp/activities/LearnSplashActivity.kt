package com.iqonic.learnerapp.activities

import android.os.Bundle
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.utils.launchActivity
import com.iqonic.learnerapp.utils.onClick
import com.iqonic.learnerapp.utils.runDelayed
import kotlinx.android.synthetic.main.learn_activity_splash.*
import android.content.Intent
import android.net.Uri

class LearnSplashActivity : LearnerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_splash)
        btnNext.onClick {
            launchActivity<LearnerWalkThroughActivity> {  }
        }
        tvClick.onClick {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.learner_link)))
            startActivity(browserIntent)
        }
    }
}
