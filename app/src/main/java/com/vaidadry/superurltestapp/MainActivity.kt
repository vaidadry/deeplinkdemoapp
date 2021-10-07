package com.vaidadry.superurltestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import com.vaidadry.superurltestapp.databinding.ActivityMainBinding
import com.vaidadry.superurltestapp.utils.SLEEP_DURATION
import com.vaidadry.superurltestapp.utils.URL_B
import com.vaidadry.superurltestapp.utils.runDelayed

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.action == "android.intent.action.VIEW") {
            binding.apply {
                loadingView.visibility = View.VISIBLE
                textView.visibility = View.VISIBLE
            }
            runDelayed(SLEEP_DURATION) {
                binding.apply {
                    loadingView.visibility = View.GONE
                    textView.visibility = View.GONE
                }
                redirectToBrowser()
            }
        }
    }

    private fun redirectToBrowser() {
        val httpIntent = Intent(Intent.ACTION_VIEW)
        httpIntent.data = Uri.parse(URL_B)
        startActivity(httpIntent)
    }
}