package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.setHorizontalLayout
import kotlinx.android.synthetic.main.learn_fragment_lessons.*

class LearnLessonsFragment :Fragment(){
    private var mPeopleAdapter =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_lesson
            , onBind = { view: View, people: LearnPeople, i: Int ->

            })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment_lessons,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLessons.setHorizontalLayout()
        rvLessons.adapter=mPeopleAdapter
        mPeopleAdapter.addItems(getLessons())
    }

    private fun getLessons(): List<LearnPeople> {
        var list = ArrayList<LearnPeople>()

        var people=LearnPeople()
        people.img=R.drawable.learn_profile_7
        people.name = "Alice Smith"
        list.add(people)

        var people2=LearnPeople()
        people2.img=R.drawable.learn_profile_8
        people2.name = "Hennah Tran"
        list.add(people2)

        var people3=LearnPeople()
        people3.img=R.drawable.learn_profile_9
        people3.name = "Louisa MacGee"
        list.add(people3)

        var people4=LearnPeople()
        people4.img=R.drawable.learn_profile_6
        people4.name = "Walter James"
        list.add(people4)

        var people5=LearnPeople()
        people5.img=R.drawable.learn_profile_3
        list.add(people5)

        var people6=LearnPeople()
        people6.img=R.drawable.learn_profile_5
        list.add(people6)

        return list
    }
}