package com.sennohananto.intent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sennohananto.intent.MainActivity
import com.sennohananto.intent.R
import com.sennohananto.intent.StudentSerializable
import com.sennohananto.intent.databinding.ActivitySerializableBinding

class SerializableActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySerializableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySerializableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myStudent: StudentSerializable = intent.getSerializableExtra(MainActivity.OBJECT_SERIALIZABLE) as StudentSerializable

        binding.tvName.text = myStudent.name
        binding.tvNim.text = myStudent.nim
        binding.tvAge.text = myStudent.age.toString()
    }
}