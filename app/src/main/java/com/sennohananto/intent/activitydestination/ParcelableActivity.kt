package com.sennohananto.intent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sennohananto.intent.AnimalParcelable
import com.sennohananto.intent.MainActivity
import com.sennohananto.intent.R
import com.sennohananto.intent.databinding.ActivityParcelableBinding

class ParcelableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParcelableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAnimal = intent.getParcelableExtra<AnimalParcelable>(MainActivity.OBJECT_PARCELABLE)

        binding.tvName.text = myAnimal?.name
        binding.tvColor.text = myAnimal?.color
        binding.tvLegs.text = myAnimal?.legs.toString()
        binding.tvEnv.text = myAnimal?.environment
    }
}