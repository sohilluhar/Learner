package com.iqonic.learnerapp.fragments

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.activities.LearnChatActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnChat
import com.iqonic.learnerapp.models.LearnPeople
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_fragment_chats.*
import kotlinx.android.synthetic.main.learn_fragment_chats.tvAll
import kotlinx.android.synthetic.main.learn_item_chat.view.*
import kotlinx.android.synthetic.main.learn_item_people.view.*

class LearnChatFragment : Fragment() {
    private var mChatAdapter = LearnerRecyclerViewAdapter<LearnChat>(R.layout.learn_item_chat
        , onBind = { view: View, chat: LearnChat, i: Int ->
            view.ivUser.loadImageFromResources(activity!!,chat.people?.img!!)
            view.viewStatus.apply {
                if (chat.people?.isOnline!!) {
                    ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(activity!!.learnAppColor(R.color.learn_green))
                }else{
                    ((background as LayerDrawable).findDrawableByLayerId(R.id.itemStatus) as GradientDrawable).setColor(activity!!.learnAppColor(R.color.learn_textColorThird))
                }
            }
            view.tvUserName.text=chat.people?.name!!
            view.tvChatMessage.text=chat.chat!!

        })

    private var mPeopleAdapter =
        LearnerRecyclerViewAdapter<LearnPeople>(R.layout.learn_item_people
            , onBind = { view: View, people: LearnPeople, i: Int ->
                if (i==0){
                    view.ivPeople.visibility=View.GONE
                }else{
                    view.ivPeople.visibility=View.VISIBLE
                }
                view.ivPeople.loadImageFromResources(activity!!,people.img)
            })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvChats.setVerticalLayout()
        rvChats.rvItemAnimation()

        rvChats.adapter=mChatAdapter
        rvPeoples.setHorizontalLayout()
        rvPeoples.adapter=mPeopleAdapter
        mChatAdapter.clearItems()
        mPeopleAdapter.clearItems()
        mChatAdapter.addItems(getChats())
        mPeopleAdapter.addItems(getPeoples())
        tvAll.onClick {
            setConstraintGravity(id,view)
        }
        tvInstructors.onClick {
            setConstraintGravity(id,view)
        }
        tvFriends.onClick {
            setConstraintGravity(id,view)
        }
        tvBots.onClick {
            setConstraintGravity(id,view)
        }
        mPeopleAdapter.onItemClick={ i: Int, view: View, people: LearnPeople ->
            activity!!.launchActivity<LearnChatActivity>()
        }
        mChatAdapter.onItemClick={ i: Int, view: View, people: LearnChat ->
            activity!!.launchActivity<LearnChatActivity>()
        }

    }
    private fun setConstraintGravity(i: Int,view: View) {
        tvAll.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))
        tvInstructors.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))
        tvFriends.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))
        tvBots.setTextColor(ContextCompat.getColor(activity!!, R.color.learn_textColorSecondary))

        val constraintSet = ConstraintSet()
        constraintSet.clone(tabChats)
        view.findViewById<TextView>(i).setTextColor(ContextCompat.getColor(activity!!, R.color.learn_colorPrimary))
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
        TransitionManager.beginDelayedTransition(tabChats)
        constraintSet.applyTo(tabChats)
        rvChats.rvItemAnimation()
    }


    private fun getPeoples(): List<LearnPeople> {
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

    private fun getChats(): List<LearnChat> {
        var list = ArrayList<LearnChat>()

        var chat = LearnChat()
        var people=LearnPeople()
        people.img=R.drawable.learn_profile_3
        people.name = "Alice Smith"
        people.isOnline=true
        chat.chat="Hi Alice How are you?"
        chat.people=people
        list.add(chat)

        var chat2 = LearnChat()
        var people2=LearnPeople()
        people2.img=R.drawable.learn_profile_4
        people2.name = "Hennah Tran"

        chat2.chat="Hi can u explain me this topic?"
        chat2.people=people2
        list.add(chat2)

        var chat3 = LearnChat()
        var people3=LearnPeople()
        people3.img=R.drawable.learn_profile_6
        people3.name = "Louisa MacGee"
        chat3.chat=" this question is related to this topic"
        chat3.people=people3
        list.add(chat3)

        var chat4 = LearnChat()
        var people4=LearnPeople()
        people4.img=R.drawable.learn_profile_7
        people4.name = "Walter James"
        people4.isOnline=true

        chat4.chat=" this question is related to this topic"
        chat4.people=people4
        list.add(chat4)

        return list

    }
}