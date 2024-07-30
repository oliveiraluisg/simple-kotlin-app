package com.meta.qcarabom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.analytics.ktx.logEvent

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    public override fun onResume() {
        super.onResume()
        recordScreenView()
    }

    private fun recordScreenView() {
        // evento de screen_view
        val screenName = "/meta-app/tela-1"

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics = Firebase.analytics

        val button: Button = findViewById(R.id.button_next)
        button.setOnClickListener {
            // evento de clique de botao
            val clickBundle = Bundle().apply {
                putString("custom_section", "qcarabom-1")
                putString("custom_type", "botao")
                putString("custom_title", "proxima-tela")
            }
            firebaseAnalytics.logEvent("clique", clickBundle)

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
