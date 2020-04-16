package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.rvItemAnimation
import com.iqonic.learnerapp.utils.setVerticalLayout
import kotlinx.android.synthetic.main.learn_fragment_course_reviews.*

class LearnReviewsFragment :Fragment(){
    private var mLecturesAdapter = LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_review
        , onBind = { view: View, people: LearnPeople, i: Int ->
            /* view.ivUser.setImageResource(people.img)
             view.tvUserName.text = people.name
             view.tvSubject.visibility = View.GONE
             if (people.isOnline) {
                 view.viewStatus.visibility = View.VISIBLE
             } else {
                 view.viewStatus?.visibility = View.GONE
             }*/
        })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment_course_reviews,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvReviews.setVerticalLayout()
        rvReviews.rvItemAnimation()
        rvReviews.adapter = mLecturesAdapter
        mLecturesAdapter.addItems(getLectures())
    }

    private fun getLectures(): List<LearnPeople> {
        var list = ArrayList<LearnPeople>()

        var people = LearnPeople()
        people.img = R.drawable.learn_profile_7
        people.name = "James"
        people.subject = "Economy"
        people.isOnline = true

        list.add(people)

        var people2 = LearnPeople()
        people2.img = R.drawable.learn_profile_8
        people2.name = "Anna"
        people2.subject = "Design"
        list.add(people2)

        var people3 = LearnPeople()
        people3.img = R.drawable.learn_profile_9
        people3.name = "Louisa"
        people3.subject = "Photography"
        people3.isOnline = true

        list.add(people3)

        var people4 = LearnPeople()
        people4.img = R.drawable.learn_profile_6
        people4.name = "Walter"
        people4.subject = "Artist"
        list.add(people4)

        var people5 = LearnPeople()
        people5.img = R.drawable.learn_profile_3
        people5.subject = "Mathematician"
        people5.isOnline = true

        list.add(people5)

        var people6 = LearnPeople()
        people6.img = R.drawable.learn_profile_5
        people6.subject = "Sports"
        people6.isOnline = true

        list.add(people6)

        return list
    }
}