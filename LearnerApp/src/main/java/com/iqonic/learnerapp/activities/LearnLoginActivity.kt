package com.iqonic.learnerapp.activities

import android.os.Bundle
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.utils.launchActivity
import com.iqonic.learnerapp.utils.onClick
import kotlinx.android.synthetic.main.learn_activity_login.*

class LearnLoginActivity : LearnerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_login)
        setStatusBar(this,R.color.learn_gradient_grey_1)
        ivBack.onClick {
            finish()

        }
        btnEnter.onClick {
            launchActivity<LearnerDashboardActivity>()
            finish()

        }
        tvJoin.onClick {
            launchActivity<LearnRegisterActivity>()
        }
    }
}
