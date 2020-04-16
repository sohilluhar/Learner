package com.iqonic.learnerapp.activities

import android.os.Bundle
import android.view.View
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnBadge
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_activity_friend_detail.*
import kotlinx.android.synthetic.main.learn_item_badges.view.*
import kotlin.collections.ArrayList

class LearnFriendDetailActivity : LearnerBaseActivity() {
    private var mBadgesAdapter = LearnerRecyclerViewAdapter<LearnBadge>(R.layout.learn_item_badges
        , onBind = { view: View, badge: LearnBadge, i: Int ->
            if (badge.isLocked) {
                view.ivMedal.visibility = View.GONE
                view.tvAchievementName.text = getString(R.string.learn_lbl_locked_badge)
                view.tvAchievementComment.text = getString(R.string.learn_lbl_unlock_to_see_details)

            } else {
                view.ivMedal.visibility = View.VISIBLE
                view.ivMedal.learAapplyStrokedBackground(learnAppColor(badge.color))
                view.ivMedal.loadImageFromResources(this,badge.img)
                view.tvAchievementName.text = badge.name
                view.tvAchievementComment.text = badge.comment
            }

        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_friend_detail)
        setStatusBar(this, R.color.learn_layout_background)
        rvAchievements.apply {
            setVerticalLayout()
            rvItemAnimation()
        }
        ivBack.onClick {
            finish()
        }
        mBadgesAdapter.addItems(getBadges())
        rvAchievements.adapter = mBadgesAdapter
        rvAchievements.rvItemAnimation()

    }



    private fun getBadges(): List<LearnBadge> {
        var list = ArrayList<LearnBadge>()

        var badge = LearnBadge()
        badge.img = R.drawable.learn_ic_medal
        badge.name = "Quick Learner"
        badge.comment = "Completed 1 course"
        badge.color = R.color.learn_colorPrimary
        list.add(badge)

        var badge1 = LearnBadge()
        badge1.img = R.drawable.learn_ic_crown
        badge1.name = "Master Mind!"
        badge1.comment = "Got 1st place on leaderboard"
        badge1.color = R.color.learn_light_green
        list.add(badge1)

        var badge2 = LearnBadge()
        badge2.img = R.drawable.learn_ic_cup
        badge2.name = "Super Learner"
        badge2.comment = "Completed more than 5 courses"

        badge2.color = R.color.learn_light_pink

        list.add(badge2)

        var badge3 = LearnBadge()
        badge3.img = R.drawable.learn_ic_flag
        badge3.name = "The Achiever"
        badge3.comment = "Logged in everyday for a month"

        badge3.color = R.color.learn_light_red

        list.add(badge3)

        return list
    }

}
