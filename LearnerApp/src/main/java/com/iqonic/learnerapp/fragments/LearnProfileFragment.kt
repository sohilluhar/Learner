package com.iqonic.learnerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.activities.LearnAchivementsActivity
import com.iqonic.learnerapp.activities.LearnFavouriteCoursesActivity
import com.iqonic.learnerapp.activities.LearnMyFriendsActivity
import com.iqonic.learnerapp.utils.launchActivity
import com.iqonic.learnerapp.utils.onClick
import kotlinx.android.synthetic.main.learn_fragment_profile.view.*

class LearnProfileFragment :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.llFavourites.onClick {
            activity!!.launchActivity<LearnFavouriteCoursesActivity>()
        }
        view.llMyFriends.onClick {
            activity!!.launchActivity<LearnMyFriendsActivity>()
        }

        view.llAchievements.onClick {
            activity!!.launchActivity<LearnAchivementsActivity>()
        }

    }
}