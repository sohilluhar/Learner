package com.iqonic.learnerapp.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnBadge
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_activity_achivements.*
import kotlinx.android.synthetic.main.learn_item_badges.view.*
import kotlinx.android.synthetic.main.learn_item_leaderboard.view.*
import java.util.*
import kotlin.collections.ArrayList

class LearnAchivementsActivity : LearnerBaseActivity() {
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
    private var mLeaderBoard = LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_leaderboard
        , onBind = { view: View, people: LearnPeople, i: Int ->
            view.ivUser.loadImageFromResources(this,people.img)
            view.tvUserName.text = people.name
            view.tvPoints.text = "${Random().nextInt(200000)} Points"
            view.tvLeaderBoardNumber.text = (i + 1).toString()
            if (i == 0) {
                view.rlContent.setBackgroundColor(learnAppColor(R.color.learn_color_light_yellow))
                view.tvLeaderBoardNumber.learAapplyStrokedBackground(learnAppColor(R.color.learn_color_musturd_yellow))
                view.tvLeaderBoardNumber.setTextColor(learnAppColor(R.color.learn_white))
            } else {
                if (i == 1 || i == 2) {
                    view.tvLeaderBoardNumber.learAapplyStrokedBackground(
                        learnAppColor(R.color.learn_transparent),
                        learnAppColor(R.color.learn_color_musturd_yellow)
                    )
                    view.tvLeaderBoardNumber.setTextColor(learnAppColor(R.color.learn_color_musturd_yellow))
                } else {
                    view.tvLeaderBoardNumber.learAapplyStrokedBackground(
                        learnAppColor(R.color.learn_transparent),
                        learnAppColor(R.color.learn_mettal_grey)
                    )
                    view.tvLeaderBoardNumber.setTextColor(learnAppColor(R.color.learn_textColorSecondary))
                }
                view.rlContent.setBackgroundColor(Color.TRANSPARENT)
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_achivements)
        setStatusBar(this, R.color.learn_layout_background)
        rvAchievements.apply {
            setVerticalLayout()
            rvItemAnimation()
        }

        tvBadges.onClick {
            setConstraintGravity(id, this)
            rvAchievements.adapter = mBadgesAdapter
            rvAchievements.rvItemAnimation()
        }
        tvLeaderBoard.onClick {
            setConstraintGravity(id, this)
            rvAchievements.adapter = mLeaderBoard
            rvAchievements.rvItemAnimation()
        }
        ivBack.onClick {
            finish()
        }
        mBadgesAdapter.addItems(getBadges())
        mLeaderBoard.addItems(getPending())
        rvAchievements.adapter = mBadgesAdapter
        rvAchievements.rvItemAnimation()
        mBadgesAdapter.onItemClick={ i: Int, view: View, people: LearnBadge ->
               if (people.isLocked){
                   launchActivity<LearnCongratulationActivity>()
               }
        }
    }

    private fun setConstraintGravity(i: Int, view: View) {
        tvBadges.setTextColor(ContextCompat.getColor(this, R.color.learn_textColorSecondary))
        tvLeaderBoard.setTextColor(ContextCompat.getColor(this, R.color.learn_textColorSecondary))

        val constraintSet = ConstraintSet()
        constraintSet.clone(tabMyFriends)
        view.findViewById<TextView>(i)
            .setTextColor(ContextCompat.getColor(this, R.color.learn_colorPrimary))
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
        TransitionManager.beginDelayedTransition(tabMyFriends)
        constraintSet.applyTo(tabMyFriends)
    }

    private fun getPending(): List<LearnPeople> {
        var list = ArrayList<LearnPeople>()

        var people = LearnPeople()
        people.img = R.drawable.learn_profile_3
        people.name = "Alice Smith"
        people.isOnline = true
        list.add(people)

        var people2 = LearnPeople()
        people2.img = R.drawable.learn_profile_4
        people2.name = "Hennah Tran"

        list.add(people2)

        var people3 = LearnPeople()
        people3.img = R.drawable.learn_profile_6
        people3.name = "Louisa MacGee"
        list.add(people3)

        var people4 = LearnPeople()
        people4.img = R.drawable.learn_profile_7
        people4.name = "Walter James"
        people4.isOnline = true
        list.add(people4)

        var people5 = LearnPeople()
        people5.img = R.drawable.learn_ic_profile_2
        people5.name = "Nia Scott"
        list.add(people5)

        var people6 = LearnPeople()
        people6.img = R.drawable.learn_ic_profile_2
        people6.name = "Hennah Tran"
        list.add(people6)
        return list
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

        var badge4 = LearnBadge()
        badge4.isLocked = true

        list.add(badge4)

        var badge5 = LearnBadge()
        badge5.isLocked = true
        list.add(badge5)

        var badge6 = LearnBadge()
        badge6.isLocked = true
        list.add(badge6)

        return list
    }

}
