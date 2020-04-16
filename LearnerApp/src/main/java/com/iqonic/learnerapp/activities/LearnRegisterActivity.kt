package com.iqonic.learnerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.utils.onClick
import kotlinx.android.synthetic.main.learn_activity_register.*

class LearnRegisterActivity : LearnerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_register)
        setStatusBar(this,R.color.learn_gradient_grey_1)

        ivBack.onClick {
            finish()

        }
        btnJoin.onClick {
            finish()
        }
    }
}
