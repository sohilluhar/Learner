package com.iqonic.learnerapp.activities

import android.os.Bundle
import android.view.View
import com.iqonic.learnerapp.R
import com.iqonic.learnerapp.base.LearnerBaseActivity
import com.iqonic.learnerapp.base.LearnerRecyclerViewAdapter
import com.iqonic.learnerapp.models.LearnChat
import com.iqonic.learnerapp.utils.*
import kotlinx.android.synthetic.main.learn_activity_chat.*
import kotlinx.android.synthetic.main.learn_item_chat_histroy.view.*

class LearnChatActivity : LearnerBaseActivity() {
    private var mChatHistoryAdapter = LearnerRecyclerViewAdapter<LearnChat>(R.layout.learn_item_chat_histroy
        , onBind = { view: View, badge: LearnChat, i: Int ->
            if (badge.isSender) {
                view.tvSender.visibility = View.VISIBLE
                view.tvReceiver.visibility = View.INVISIBLE
                view.tvSender.text = badge.chat
                view.tvSender.setTextColor(learnAppColor(R.color.learn_white))
            } else {
                view.tvSender.visibility = View.INVISIBLE
                view.tvReceiver.visibility = View.VISIBLE
                view.tvReceiver.text = badge.chat
                view.tvReceiver.setTextColor(learnAppColor(R.color.learn_textColorPrimary))
            }

        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity_chat)
        setStatusBar(this,R.color.learn_layout_background)
        rvChats.apply {
            setVerticalLayout()
            adapter = mChatHistoryAdapter
            rvItemAnimation()
        }
       mChatHistoryAdapter.addItems(getChats())
        ivBack.onClick {
            finish()
        }
    }

    private fun getChats(): List<LearnChat> {
        var list = ArrayList<LearnChat>()

        var badge = LearnChat()
        badge.chat = "Hi Nimasha"
        list.add(badge)

        var badge1 = LearnChat()
        badge1.chat = "I am Revision Bot ,here to help you study your ongoing courses"

        list.add(badge1)

        var badge2 = LearnChat()
        badge2.chat="Select a course to begin\nBusiness Management\nCloud Computing\nModern Medicine"

        list.add(badge2)

        var badge3 = LearnChat()
        badge3.chat="Modern Medicine"
        badge3.isSender=true
        list.add(badge3)

        return list
    }
}
