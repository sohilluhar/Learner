package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnCategory
import com.iqonic.learnerapp.models.LearnFeatured
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_fragment_home.*
import kotlinx.android.synthetic.main.learn_item_featured.view.*
import kotlinx.android.synthetic.main.learn_item_main_category.view.*

class LearnHomeFragment : Fragment() {

    private var mFeaturedAdapter = LearnerRecyclerViewAdapter<LearnFeatured>(R.layout.learn_item_featured
        , onBind = { view: View, featured: LearnFeatured, i: Int ->
            view.imgWalk1.loadImageFromResources(activity!!,featured.img)
            view.tvFeatureName.text = featured.name
            view.tvPrice.text = featured.price
            view.tvStrikePrice.text = featured.strikePrice
            view.tvStrikePrice.applyStrike()
        })

    private var mCategoryAdapter =
        LearnerRecyclerViewAdapter<LearnCategory>(R.layout.learn_item_main_category
            , onBind = { view: View, featured: LearnCategory, i: Int ->
                view.ivCategory.loadImageFromResources(activity!!,featured.img)
                view.tvCategoryName.text = featured.name
            })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learn_fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFeatured.setHorizontalLayout()
        rvFeatured.adapter = mFeaturedAdapter
        rvCategories.apply {
            layoutManager = GridLayoutManager(activity, 3)
            setHasFixedSize(true)
            rvCategories.adapter = mCategoryAdapter
            addItemDecoration(LearnGridSpacingItemDecoration(3,30,false))
            rvCategories.rvItemAnimation()
        }
        mFeaturedAdapter.clearItems()
        mCategoryAdapter.clearItems()
        mFeaturedAdapter.addItems(getFeaturedItems())
        mCategoryAdapter.addItems(getCategories())

    }
    companion object{
        fun getCategories(): List<LearnCategory> {
            var list = ArrayList<LearnCategory>()
            var category = LearnCategory()
            category.img = R.drawable.learn_ic_bag
            category.name = "Business"

            var category2 = LearnCategory()
            category2.img = R.drawable.learn_ic_pencil_scale
            category2.name = "Design"

            var category3 = LearnCategory()
            category3.img = R.drawable.learn_ic_crome
            category3.name = "Economy"

            var category4 = LearnCategory()
            category4.img = R.drawable.learn_ic_telecope
            category4.name = "Research"

            var category5 = LearnCategory()
            category5.img = R.drawable.learn_ic_medal
            category5.name = "Polytics"

            var category6 = LearnCategory()
            category6.img = R.drawable.learn_ic_crown
            category6.name = "Awards"

            var category7 = LearnCategory()
            category7.img = R.drawable.learn_ic_flag
            category7.name = "Sports"

            var category8 = LearnCategory()
            category8.img = R.drawable.learn_ic_cup
            category8.name = "Medals"

            list.add(category)
            list.add(category2)
            list.add(category3)
            list.add(category4)
            list.add(category5)
            list.add(category6)
            list.add(category7)
            list.add(category8)
            return list

        }
    }


    private fun getFeaturedItems(): List<LearnFeatured> {
        var list = ArrayList<LearnFeatured>()
        var featured = LearnFeatured()
        featured.img = R.drawable.learn_walk_1
        featured.name = "Business Management"
        featured.price = "$19.99"

        var featured2 = LearnFeatured()
        featured2.img = R.drawable.learn_walk_2
        featured2.name = "Learn How To Play Guitar"
        featured2.price = "$16.99"
        featured2.strikePrice = "$20.99"

        var featured3 = LearnFeatured()
        featured3.img = R.drawable.learn_walk_3
        featured3.name = "Medicine & Biology Basics"
        featured3.price = "$10.99"

        var featured4 = LearnFeatured()
        featured4.img = R.drawable.learn_walk_1
        featured4.name = "Business Management"
        featured4.price = "$16.99"

        var featured5 = LearnFeatured()
        featured5.img = R.drawable.learn_walk_2
        featured5.name = "Learn How To Play Guitar"
        featured5.price = "$16.99"
        featured5.strikePrice = "$20.99"

        list.add(featured)
        list.add(featured2)
        list.add(featured3)
        list.add(featured4)
        list.add(featured5)

        return list
    }
}