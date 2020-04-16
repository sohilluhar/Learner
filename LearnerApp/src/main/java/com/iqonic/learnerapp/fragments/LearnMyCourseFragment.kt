package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.activities.LearnCourseDetailActivity
import com.iqonic.learnerapp.activities.LearnOngoingCourseDetailActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnFeatured
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_fragment_my_cource.*
import kotlinx.android.synthetic.main.learn_item_course.view.*

class LearnMyCourseFragment : Fragment() {
    private var mFeaturedAdapter = LearnerRecyclerViewAdapter<LearnFeatured>(R.layout.learn_item_course
        , onBind = { view: View, featured: LearnFeatured, i: Int ->
            view.ivCourse.loadImageFromResources(activity!!,featured.img)
            view.tvFeatureName.text = featured.name
        })
    private var selected: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learn_fragment_my_cource, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAllCourses.apply {
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
            rvAllCourses.adapter = mFeaturedAdapter
            addItemDecoration(LearnGridSpacingItemDecoration(2, 5, false))
            rvAllCourses.rvItemAnimation()
        }
        mFeaturedAdapter.clearItems()
        mFeaturedAdapter.onItemClick = { i: Int, view: View, featured: LearnFeatured ->
            if (selected==tvOngoing.id){
                activity!!.launchActivity<LearnOngoingCourseDetailActivity>()
            }else{
                activity!!.launchActivity<LearnCourseDetailActivity>()
            }
        }
        mFeaturedAdapter.addItems(getCourses())

        tvAll.onClick {
            setConstraintGravity(id, view)
            selected = id

        }
        tvOngoing.onClick {
            setConstraintGravity(id, view)
            selected = id

        }
        tvCompleted.onClick {
            setConstraintGravity(id, view)
            selected = id

        }
        selected = tvAll.id

    }

    private fun setConstraintGravity(i: Int, view: View) {
        tvAll.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))
        tvOngoing.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))
        tvCompleted.setTextColor(
            ContextCompat.getColor(
                activity!!,
                R.color.learn_textColorSecondary
            )
        )
        val constraintSet = ConstraintSet()
        constraintSet.clone(tabCourses)
        view.findViewById<TextView>(i)
            .setTextColor(ContextCompat.getColor(activity!!, R.color.learn_colorPrimary))
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
        TransitionManager.beginDelayedTransition(tabCourses)
        constraintSet.applyTo(tabCourses)
        rvAllCourses.rvItemAnimation()
    }


    private fun getCourses(): List<LearnFeatured> {
        var list = ArrayList<LearnFeatured>()
        var featured = LearnFeatured()
        featured.img = R.drawable.learn_walk_1
        featured.name = "Business Management"
        featured.price = "$19.99"
        featured.type = "Management"

        var featured2 = LearnFeatured()
        featured2.img = R.drawable.learn_walk_2
        featured2.name = "IT & Cloud Computing"
        featured2.price = "$16.99"
        featured2.strikePrice = "$20.99"
        featured2.type = "Computer"

        var featured5 = LearnFeatured()
        featured5.img = R.drawable.learn_walk_2
        featured5.name = "Learn How To Play Guitar"
        featured5.price = "$16.99"
        featured5.strikePrice = "$20.99"
        featured5.type = "Music"


        var featured6 = LearnFeatured()
        featured6.img = R.drawable.learn_walk_1
        featured6.name = "Basics of baking cakes"
        featured6.price = "$16.99"
        featured6.type = "Cooking"


        var featured3 = LearnFeatured()
        featured3.img = R.drawable.learn_walk_3
        featured3.name = "Modern Medicines"
        featured3.price = "$10.99"
        featured3.type = "Medicines"

        var featured4 = LearnFeatured()
        featured4.img = R.drawable.learn_walk_1
        featured4.name = "Project Management"
        featured4.price = "$16.99"
        featured4.type = "Management"



        list.add(featured)
        list.add(featured2)
        list.add(featured5)
        list.add(featured6)
        list.add(featured3)
        list.add(featured4)

        return list
    }
}