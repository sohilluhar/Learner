package com.iqonic.learnerapp.activities

import android.os.Bundle
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.utils.makeTransaprant

class LearnContentDetailActivity : LearnerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_course_content_detail)
         makeTransaprant()
    }
}
