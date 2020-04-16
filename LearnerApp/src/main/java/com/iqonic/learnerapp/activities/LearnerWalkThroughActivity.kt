package com.iqonic.learnerapp.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.utils.infinitecycleviewpager.OnInfiniteCyclePageTransformListener
import com.iqonic.learnerapp.utils.launchActivity
import com.iqonic.learnerapp.utils.loadImageFromResources
import com.iqonic.learnerapp.utils.makeTransaprant
import com.iqonic.learnerapp.utils.onClick
import kotlinx.android.synthetic.main.learner_activity_walk_through.btnGetStarted
import kotlinx.android.synthetic.main.learner_activity_walk_through.tvLogin
import kotlinx.android.synthetic.main.learner_activity_walk_through_new.*
import kotlinx.android.synthetic.main.learner_item_walk.view.*

class LearnerWalkThroughActivity : LearnerBaseActivity() {
    var mHeading = arrayOf("Welcome", "Select Course", "Learn Topics")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learner_activity_walk_through_new)
        makeTransaprant()
        val adapter = WalkAdapter()
        vpWalkthough.adapter=adapter
        //vpBoarding.adapter = adapter
        btnGetStarted.onClick {
            launchActivity<LearnerDashboardActivity>()
            finish()

        }
        tvLogin.onClick {
            launchActivity<LearnLoginActivity>()
            finish()
        }
        vpWalkthough.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
            {
            }

            override fun onPageSelected(position: Int) {
                  tvHeading.text=mHeading[vpWalkthough.realItem]
            }


        })
    }

    internal inner class WalkAdapter : PagerAdapter() {
        private val mImg = arrayOf(R.drawable.learn_walk_1, R.drawable.learn_walk_2, R.drawable.learn_walk_3)

        override fun isViewFromObject(v: View, `object`: Any): Boolean {
            return v === `object` as View
        }

        override fun getCount(): Int {
            return mImg.size
        }

        override fun instantiateItem(parent: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.learner_item_walk, parent, false)
            view.imgWalk2.loadImageFromResources(applicationContext,mImg[position])
            parent.addView(view)
            return view
        }

        override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
            parent.removeView(`object` as View)
        }
    }

}
