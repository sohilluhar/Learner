package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.activities.LearnInstructorDetailActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.fragments.LearnHomeFragment.Companion.getCategories
import com.iqonic.learnerapp.models.LearnCategory
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_activity_search.*
import kotlinx.android.synthetic.main.learn_item_filter_category.view.*
import kotlinx.android.synthetic.main.learn_item_main_category.view.*
import kotlinx.android.synthetic.main.learn_item_main_category.view.ivCategory
import kotlinx.android.synthetic.main.learn_item_main_category.view.tvCategoryName
import kotlinx.android.synthetic.main.learn_item_search.view.*

class LearnSearchFragment : Fragment() {
    private var mInstructorsAdapter =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_search
            , onBind = { view: View, people: LearnPeople, i: Int ->
                view.ivUser.loadImageFromResources(activity!!,people.img)
                view.tvUserName.text = people.name
                view.tvSubject.text = people.subject
                if (people.isOnline) {
                    view.viewStatus.visibility = View.VISIBLE
                } else {
                    view.viewStatus.visibility = View.GONE
                }
            })
    private var mCategoryAdapter =
        LearnerRecyclerViewAdapter<LearnCategory>(R.layout.learn_item_filter_category
            , onBind = { view: View, featured: LearnCategory, i: Int ->
                view.ivCategory.loadImageFromResources(activity!!,featured.img)
                view.tvCategoryName.text = featured.name
                view.ivCategory.apply {
                    if (i == selected) {
                        learAapplyStrokedBackground(activity!!.color(R.color.learn_white))
                    }else{
                        learAapplyStrokedBackground(activity!!.color(R.color.learn_white_trans))
                    }
                }
            })

    private var mRecommondedAdapter =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_recommonded
            , onBind = { view: View, people: LearnPeople, i: Int ->
                view.ivUser.loadImageFromResources(activity!!,people.img)
            })
    private var selected: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learn_activity_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPeoples.setHorizontalLayout()
        rvPeoples.rvItemAnimation()
        rvCategoryFilter.setHorizontalLayout()
        rvCategoryFilter.adapter = mCategoryAdapter
        rvPeoples.adapter = mInstructorsAdapter
        rvRecommended.setHorizontalLayout()
        rvRecommended.adapter = mRecommondedAdapter
        mRecommondedAdapter.clearItems()
        mInstructorsAdapter.clearItems()
        mRecommondedAdapter.addItems(getRecoom())
        mInstructorsAdapter.addItems(getPeoples())
        mCategoryAdapter.clearItems()
        mInstructorsAdapter.onItemClick = { _: Int, _: View, _: LearnPeople ->
            activity!!.launchActivity<LearnInstructorDetailActivity>()
        }
        mCategoryAdapter.onItemClick = { i: Int, _: View, learnCategory: LearnCategory ->
            onCategoryClick(i, learnCategory)
        }
        tvFilter.onClick {
            mCategoryAdapter.clearItems()
            mCategoryAdapter.addItems(getCategories())
            setConstraintGravity(1)
        }
        tvCloseFilter.onClick {
            setConstraintGravity(0)
        }
    }

    private fun onCategoryClick(i: Int, learnCategory: LearnCategory) {
        selected = i
        mCategoryAdapter.notifyDataSetChanged()
    }

    private fun setConstraintGravity(i: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintTop)
        if (i == 0) {
            constraintSet.connect(
                R.id.llFilterLayout,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0
            )
        } else {
            constraintSet.clear(
                R.id.llFilterLayout,
                ConstraintSet.BOTTOM
            )
        }
        TransitionManager.beginDelayedTransition(constraintTop)
        constraintSet.applyTo(constraintTop)
    }

    private fun getRecoom(): List<LearnPeople> {
        var list = ArrayList<LearnPeople>()

        var people = LearnPeople()
        people.img = R.drawable.learn_walk_1
        list.add(people)

        var people2 = LearnPeople()
        people2.img = R.drawable.learn_cack
        list.add(people2)

        var people3 = LearnPeople()
        people3.img = R.drawable.learn_green_image
        list.add(people3)

        var people4 = LearnPeople()
        people4.img = R.drawable.learn_climb_circle
        list.add(people4)

        var people5 = LearnPeople()
        people5.img = R.drawable.learn_walk_3
        list.add(people5)

        var people6 = LearnPeople()
        people6.img = R.drawable.learn_profile_5
        list.add(people6)

        return list
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
        people5.name = "Emma Watson"
        people5.subject = "Mathematician"
        people5.isOnline = true

        list.add(people5)

        var people6 = LearnPeople()
        people6.img = R.drawable.learn_profile_5
        people6.name = "Julie Gonas"
        people6.subject = "Sports"
        people6.isOnline = true

        list.add(people6)

        return list
    }

}