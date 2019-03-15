package com.gpetuhov.android.samplemlkitlanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detectButton.setOnClickListener { detectLanguage() }
    }

    private fun detectLanguage() {
        val text = inputText.text.toString()

        val languageIdentifier = FirebaseNaturalLanguage.getInstance().languageIdentification

        languageIdentifier.identifyLanguage(text)
            .addOnSuccessListener { languageCode ->
                if (languageCode != "und") {
                    resultTextView.text = languageCode
                } else {
                    resultTextView.text = "Undetected"
                }
            }
            .addOnFailureListener { exception ->
                resultTextView.text = "Error detecting language"
            }
    }
}
