package com.meta.qcarabom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // starta o Firebase
        mFirebaseAnalytics = Firebase.analytics

        // evento de screen_view
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, "/meta-app/tela-1")
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)

        val button: Button = findViewById(R.id.button_next)
        button.setOnClickListener {
            // evento de clique de botao
            val clickBundle = Bundle().apply {
                putString("custom_section", "qcarabom-1")
                putString("custom_type", "botao")
                putString("custom_title", "proxima-tela")
            }
            mFirebaseAnalytics.logEvent("clique", clickBundle)

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
