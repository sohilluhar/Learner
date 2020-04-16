package com.iqonic.learnerapp.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.fragments.*
import kotlinx.android.synthetic.main.learn_activity_course_detail.*


class LearnCourseDetailActivity : LearnerBaseActivity() {
    var mHomeFragment = LearnCourseDetailFragment()
    var mSearchFragment = LearnCourseContentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_course_detail)
        setStatusBar(this,R.color.learn_layout_background)
        var adapter=ViewPagerAdapter(supportFragmentManager)
        vpCourseDetail.adapter=adapter
    }

    fun closeContent() {
        vpCourseDetail.currentItem=0
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        //three fragments
        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return mHomeFragment
                1 -> return mSearchFragment

            }
            return null //does not happen
        }
    }
}
