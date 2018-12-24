package io.github.ttarcher.martian

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class ProcessActivity : AppCompatActivity() {
    private var convertString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val readOnly = intent.getBooleanExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false)
        if (readOnly) {
            btnReplace.visibility = View.INVISIBLE
            btnCopy.visibility = View.VISIBLE
        } else {
            btnReplace.visibility = View.VISIBLE
            btnCopy.visibility = View.INVISIBLE
        }
        convertString = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT).mconvert()
        textContent.text = convertString

        constraintLayout.setOnClickListener {
            finish()
        }

        btnCopy.setOnClickListener {
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val data = cm.primaryClip
            data?.addItem(ClipData.Item(textContent.text))
            cm.primaryClip = data
            finish()
        }

        btnReplace.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(Intent.EXTRA_PROCESS_TEXT, convertString)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
