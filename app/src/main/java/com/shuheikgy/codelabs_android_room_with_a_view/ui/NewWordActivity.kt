package com.shuheikgy.codelabs_android_room_with_a_view.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.shuheikgy.codelabs_android_room_with_a_view.R


class NewWordActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    private var mEditWordView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        val button: Button = findViewById<Button>(R.id.button_save)
        mEditWordView = findViewById<EditText>(R.id.edit_word)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(mEditWordView!!.getText())) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val word = mEditWordView!!.getText().toString()
                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }
        })
    }
}
