package com.iqonic.learnerapp.activities

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_activity_my_friends.*
import kotlinx.android.synthetic.main.learn_item_accepted.view.*
import kotlinx.android.synthetic.main.learn_item_pending.view.*
import java.util.*
import kotlin.collections.ArrayList

class LearnMyFriendsActivity : LearnerBaseActivity() {
    private var mAccpetedFriends =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_accepted
            , onBind = { view: View, people: LearnPeople, i: Int ->
                view.ivUser.loadImageFromResources(this,people.img)
                view.tvUserName.text=people.name
                view.tvEmail.text=people.email
                view.viewStatus.apply {
                    if (people.isOnline) {
                        ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(learnAppColor(R.color.learn_green))
                    }else{
                        ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(learnAppColor(R.color.learn_textColorThird))
                    }
                }


            })
    private var mPendingAdapter =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_pending
            , onBind = { view: View, people: LearnPeople, i: Int ->
                view.viewStatusPending.apply {
                    if (people.isOnline) {
                        ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(learnAppColor(R.color.learn_green))
                    }else{
                        ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(learnAppColor(R.color.learn_textColorThird))
                    }
                }

                view.ivUserPending.loadImageFromResources(this,people.img)
                view.tvUserNamePending.text=people.name
                view.tvMutual.text=Random().nextInt(20).toString()+" mutual Friends"
            })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_my_friends)
        setStatusBar(this,R.color.learn_layout_background)
        rvFriends.apply {
            setVerticalLayout()
            rvItemAnimation()
        }

        mAccpetedFriends.addItems(getAccepted())
        mPendingAdapter.addItems(getPending())
        tvAll.onClick {
            setConstraintGravity(id,this)
            rvFriends.adapter=mAccpetedFriends
            rvFriends.rvItemAnimation()

        }
        tvPending.onClick {
            setConstraintGravity(id,this)
            rvFriends.adapter=mPendingAdapter
            rvFriends.rvItemAnimation()
        }
        ivBack.onClick {
            finish()
        }
        rvFriends.adapter=mAccpetedFriends
        rvFriends.rvItemAnimation()
        mAccpetedFriends.onItemClick={ i: Int, view: View, people: LearnPeople ->
           launchActivity<LearnFriendDetailActivity>()
        }
        mPendingAdapter.onItemClick={ i: Int, view: View, people: LearnPeople ->
            launchActivity<LearnFriendDetailActivity>()
        }

    }
    private fun setConstraintGravity(i: Int,view: View) {
        tvAll.setTextColor(ContextCompat.getColor(this, R.color.learn_textColorSecondary))
        tvPending.setTextColor(ContextCompat.getColor(this, R.color.learn_textColorSecondary))

        val constraintSet = ConstraintSet()
        constraintSet.clone(tabMyFriends)
        view.findViewById<TextView>(i).setTextColor(ContextCompat.getColor(this, R.color.learn_colorPrimary))
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

        var people=LearnPeople()
        people.img=R.drawable.learn_profile_3
        people.name = "Alice Smith"
        people.isOnline=true
        list.add(people)

        var people2=LearnPeople()
        people2.img=R.drawable.learn_profile_4
        people2.name = "Hennah Tran"

        list.add(people2)

        var people3=LearnPeople()
        people3.img=R.drawable.learn_profile_6
        people3.name = "Louisa MacGee"
        list.add(people3)

        var people4=LearnPeople()
        people4.img=R.drawable.learn_profile_7
        people4.name = "Walter James"
        people4.isOnline=true
        list.add(people4)

        var people5=LearnPeople()
        people5.img=R.drawable.learn_ic_profile_2
        people5.name = "Nia Scott"
        list.add(people5)

        return list
    }

    private fun getAccepted(): List<LearnPeople> {
        var list = ArrayList<LearnPeople>()

        var people=LearnPeople()
        people.img=R.drawable.learn_profile_9
        people.name = "Alice Smith"
        people.email = "alicesmith@gmail.com"

        people.isOnline=true
        list.add(people)

        var people2=LearnPeople()
        people2.img=R.drawable.learn_profile_8
        people2.name = "Hennah Tran"
        people2.email = "hennahtran@gmail.com"

        list.add(people2)

        var people3=LearnPeople()
        people3.img=R.drawable.learn_ic_profile_2
        people3.name = "Louisa MacGee"
        people3.email ="louisamacGee@gmail.com"

        list.add(people3)

        var people4=LearnPeople()
        people4.img=R.drawable.learn_profile_3
        people4.name = "Walter James"
        people4.email ="walter@gmail.com"

        people4.isOnline=true
        list.add(people4)

        var people5=LearnPeople()
        people5.img=R.drawable.learn_profile_5
        people5.name = "Nia Scott"
        people5.email = "niaScott@gmail.com"

        list.add(people5)

        return list
    }

}
