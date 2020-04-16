package com.iqonic.learnerapp.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.fragments.*
import com.iqonic.learnerapp.utils.addFragment
import com.iqonic.learnerapp.utils.showFragment
import kotlinx.android.synthetic.main.learn_activity_dashboard.*
import androidx.viewpager.widget.ViewPager
import com.iqonic.learnerapp.utils.replaceFragment


class LearnerDashboardActivity : LearnerBaseActivity() {
    var mHomeFragment = LearnHomeFragment()
    var mSearchFragment = LearnSearchFragment()

    var mMyCourceFragment = LearnMyCourseFragment()
    var mChatFragment = LearnChatFragment()
    var mProfileFragment = LearnProfileFragment()
    var ids = arrayOf(R.id.navigation_home, R.id.navigation_search, R.id.navigation_statistical, R.id.navigation_chat, R.id.navigation_more)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_dashboard)
        setStatusBar(this,R.color.learn_layout_background)
        bottomNavigation.setOnNavigationItemSelectedListener {
            ids.forEachIndexed { index, i ->
                if (i == it.itemId) {
                    loadFragment(index)
                }
            }

            return@setOnNavigationItemSelectedListener true
        }
        loadFragment(0)
    }

    private fun loadFragment(aFragment: Int) {
        replaceFragment(getItem(aFragment)!!, R.id.container)
    }
     fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return mHomeFragment
            1 -> return mSearchFragment
            2 -> return mMyCourceFragment
            3 -> return mChatFragment
            4 -> return mProfileFragment
        }
        return null
    }

/*
    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        //three fragments
        override fun getCount(): Int {
            return 5
        }

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return mHomeFragment
                1 -> return mSearchFragment
                2 -> return mMyCourceFragment
                3 -> return mChatFragment
                4 -> return mProfileFragment

            }
            return null //does not happen
        }
    }
*/
}
