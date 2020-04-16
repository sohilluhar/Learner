package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnContent
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.loadImageFromResources
import com.iqonic.learnerapp.utils.rvItemAnimation
import com.iqonic.learnerapp.utils.setHorizontalLayout
import kotlinx.android.synthetic.main.learn_fragment_course_about.*
import kotlinx.android.synthetic.main.learn_item_lectures.view.*
import kotlinx.android.synthetic.main.learn_item_search.view.*

class LearnAboutFragment :Fragment(){
    private var mPeopleAdapter = LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_search
        , onBind = { view: View, people: LearnPeople, i: Int ->
            view.ivUser.loadImageFromResources(activity!!,people.img)
            view.tvUserName.text = people.name
            view.tvSubject.visibility = View.GONE
            if (people.isOnline) {
                view.viewStatus.visibility = View.VISIBLE
            } else {
                view.viewStatus?.visibility = View.GONE
            }
        })
    private var mLecturesAdapter = LearnerRecyclerViewAdapter<LearnContent>(R.layout.learn_item_lectures
        , onBind = { view: View, people: LearnContent, i: Int ->
            view.tvIndex.text = (i + 1).toString()
            view.tvFeatureName.text = people.name
            view.tvsubtitle.text = people.subtitle
            view.tvType.text = people.type
        })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment_course_about,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvStudents.setHorizontalLayout()
        rvStudents.rvItemAnimation()
        rvStudents.adapter = mPeopleAdapter
        mPeopleAdapter.addItems(getPeoples())
        rvLectures.setHorizontalLayout()
        rvLectures.rvItemAnimation()
        rvLectures.adapter = mLecturesAdapter
        mLecturesAdapter.addItems(getLectures())
    }
    private fun getPeoples(): List<LearnPeople> {
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
    private fun getLectures(): List<LearnContent> {
            var list = ArrayList<LearnContent>()
            var content = LearnContent()
            content.name = "Introduction"
            content.subtitle = "About this course and overview"
            content.type = "video"
            list.add(content)

            var content2 = LearnContent()
            content2.name = "What is management?"
            content2.subtitle = "Basics and introduction"
            content2.type = "Article"

            list.add(content2)


            var content3 = LearnContent()
            content3.name = "How does your decision effect your project?"
            content3.subtitle = "Learn the most importand aspects of Basics and introduction"
            content3.type = "Presentation"
            list.add(content3)
            return list
        }

    }

