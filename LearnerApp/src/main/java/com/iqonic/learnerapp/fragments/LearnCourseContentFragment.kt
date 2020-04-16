package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.activities.*
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnContent
import com.iqonic.learnerapp.utils.launchActivity
import com.iqonic.learnerapp.utils.onClick
import com.iqonic.learnerapp.utils.rvItemAnimation
import com.iqonic.learnerapp.utils.setVerticalLayout
import kotlinx.android.synthetic.main.learn_fragment_course_content.*
import kotlinx.android.synthetic.main.learn_item_content.view.*

class LearnCourseContentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learn_fragment_course_content, container, false)
    }

    private var mLecturesAdapter = LearnerRecyclerViewAdapter<LearnContent>(R.layout.learn_item_content
        , onBind = { view: View, people: LearnContent, i: Int ->
            view.tvIndex.text = (i + 1).toString()
            view.tvFeatureName.text = people.name
            view.tvsubtitle.text = people.subtitle
            view.tvType.text = people.type
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvContent.setVerticalLayout()
        rvContent.rvItemAnimation()
        rvContent.adapter = mLecturesAdapter
        mLecturesAdapter.addItems(getContents())
        ivClose.onClick {
            (activity as LearnCourseDetailActivity).closeContent()
        }
        mLecturesAdapter.onItemClick={ i: Int, view: View, content: LearnContent ->
           activity?.launchActivity<LearnContentDetailActivity>()
        }
    }

    private fun getContents(): List<LearnContent> {
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