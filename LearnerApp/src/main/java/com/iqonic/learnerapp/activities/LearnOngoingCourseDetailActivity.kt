package com.iqonic.learnerapp.activities

import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.fragments.LearnAboutFragment
import com.iqonic.learnerapp.fragments.LearnLessonsFragment
import com.iqonic.learnerapp.fragments.LearnReviewsFragment
import com.iqonic.learnerapp.utils.learnAppColor
import com.iqonic.learnerapp.utils.onClick
import com.iqonic.learnerapp.utils.replaceFragment
import kotlinx.android.synthetic.main.learn_activity_ongoing_course_detail.*

class LearnOngoingCourseDetailActivity : LearnerBaseActivity() {
    private var lessonsFragment: LearnLessonsFragment = LearnLessonsFragment()
    private var learnReviewsFragment: LearnReviewsFragment = LearnReviewsFragment()
    private var learnAboutFragment: LearnAboutFragment = LearnAboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_ongoing_course_detail)
        setStatusBar(this,R.color.learn_light_sky_blue)
        tvLessons.onClick {
            setConstraintGravity(id)
            loadFragment(lessonsFragment)
            updateUI(true)
            setTextColor(learnAppColor(R.color.learn_white))
        }
        tvReviews.onClick {
            setConstraintGravity(id)
            loadFragment(learnReviewsFragment)
            updateUI(false)

            setTextColor(learnAppColor(R.color.learn_colorPrimary))

        }
        tvAbout.onClick {
            setConstraintGravity(id)
            loadFragment(learnAboutFragment)
            updateUI(false)

            setTextColor(learnAppColor(R.color.learn_colorPrimary))

        }
        ivBack.onClick {
            finish()
        }
        loadFragment(lessonsFragment)
        updateUI(true)

    }

    private fun updateUI(b: Boolean) {
        if (b){
            tvLessons.setTextColor(learnAppColor(R.color.learn_gradient_grey_1))
            tvReviews.setTextColor(learnAppColor(R.color.learn_gradient_grey_1))
            tvAbout.setTextColor(learnAppColor(R.color.learn_gradient_grey_1))
            ivBack.setColorFilter(learnAppColor(R.color.learn_white))
            ivMore.setColorFilter(learnAppColor(R.color.learn_white))
            tvMyCourse.setTextColor(learnAppColor(R.color.learn_white))
            tvUserName.setTextColor(learnAppColor(R.color.learn_white))
            llMain.setBackgroundColor(learnAppColor(R.color.learn_light_sky_blue))
            toolbar_layout.setBackgroundColor(learnAppColor(R.color.learn_light_sky_blue))
            toolbar.setBackgroundColor(learnAppColor(R.color.learn_light_sky_blue))
            tabCourse.setBackgroundColor(learnAppColor(R.color.learn_light_sky_blue))
            setStatusBar(this,R.color.learn_light_sky_blue)
            tab.setBackgroundColor(learnAppColor(R.color.learn_white))
        }else{
            tvLessons.setTextColor(learnAppColor(R.color.learn_textColorSecondary))
            tvReviews.setTextColor(learnAppColor(R.color.learn_textColorSecondary))
            tvAbout.setTextColor(learnAppColor(R.color.learn_textColorSecondary))
            ivBack.setColorFilter(learnAppColor(R.color.learn_colorPrimary))
            ivMore.setColorFilter(learnAppColor(R.color.learn_colorPrimary))
            tvMyCourse.setTextColor(learnAppColor(R.color.learn_textColorPrimary))
            tvUserName.setTextColor(learnAppColor(R.color.learn_textColorPrimary))
            llMain.setBackgroundColor(learnAppColor(R.color.learn_layout_background))
            toolbar.setBackgroundColor(learnAppColor(R.color.learn_layout_background))
            toolbar_layout.setBackgroundColor(learnAppColor(R.color.learn_layout_background))
            tabCourse.setBackgroundColor(learnAppColor(R.color.learn_layout_background))
            setStatusBar(this,R.color.learn_layout_background)
            tab.setBackgroundColor(learnAppColor(R.color.learn_colorPrimary))


        }
    }

    private fun loadFragment(aFragment: Fragment) {
        replaceFragment(aFragment, R.id.vpCourse)
    }

    private fun setConstraintGravity(i: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(tabCourse)
        constraintSet.connect(
            R.id.tab,
            ConstraintSet.START,
            i,
            ConstraintSet.START,
            0
        )
        constraintSet.connect(
            R.id.tab,
            ConstraintSet.END,
            i,
            ConstraintSet.END,
            0
        )

        constraintSet.connect(
            R.id.tab,
            ConstraintSet.TOP,
            i,
            ConstraintSet.BOTTOM,
            0
        )
        TransitionManager.beginDelayedTransition(tabCourse)
        constraintSet.applyTo(tabCourse)
    }
}
