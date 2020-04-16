package com.iqonic.learnerapp.activities

import android.os.Bundle
import android.view.View
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnFeatured
import com.iqonic.learnerapp.utils.loadImageFromResources
import com.iqonic.learnerapp.utils.onClick
import com.iqonic.learnerapp.utils.rvItemAnimation
import com.iqonic.learnerapp.utils.setVerticalLayout
import kotlinx.android.synthetic.main.learn_activity_favourite_courses.*
import kotlinx.android.synthetic.main.learn_item_favourite_course.view.*
import java.util.*
import kotlin.collections.ArrayList

class LearnFavouriteCoursesActivity : LearnerBaseActivity() {
    private var mLecturesAdapter =
        LearnerRecyclerViewAdapter<LearnFeatured>(R.layout.learn_item_favourite_course
            , onBind = { view: View, people: LearnFeatured, i: Int ->
                /* view.ivUser.loadImageFromResources(people.img)
                 view.tvUserName.text = people.name
                 view.tvSubject.visibility = View.GONE
                 if (people.isOnline) {
                     view.viewStatus.visibility = View.VISIBLE
                 } else {
                     view.viewStatus?.visibility = View.GONE
                 }*/
                view.ivProfile.loadImageFromResources(this,people.img)
                view.tvUserName.text=people.name
                view.tvStartNewChat.text=people.type
                view.tvPrice.text=people.price
                view.tvStudentCount.text=Random().nextInt(200).toString()
                view.tvLecturesCount.text=Random().nextInt(200).toString()
            })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_favourite_courses)
        setStatusBar(this,R.color.learn_layout_background)
        rvFavourites.apply {
            setVerticalLayout()
            adapter = mLecturesAdapter
            rvItemAnimation()
        }
        mLecturesAdapter.addItems(getFavourites())
        ivBack.onClick {
            finish()
        }
    }

    private fun getFavourites(): List<LearnFeatured> {
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
