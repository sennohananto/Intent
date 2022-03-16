package com.sennohananto.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sennohananto.intent.activitydestination.*
import com.sennohananto.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object{
        const val MESSAGE = "MESSAGE"
        const val AGE = "AGE"
        const val BUNDLE = "BUNGKUSAN"
        const val OBJECT_SERIALIZABLE = "SERIALIZABLE"
        const val OBJECT_PARCELABLE = "PARCELABLE"
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Implicit Intent
        binding.btnSend.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.etMessage.text.toString())
                type = "text/plain"
            }

            if(sendIntent.resolveActivity(packageManager) != null){
                startActivity(sendIntent)
            }
        }

        binding.btnSimpleIntent.setOnClickListener {
            val intentToSecondActivity = Intent(this, SecondDestinationActivity::class.java)
            startActivity(intentToSecondActivity)
        }

        binding.btnSimplePutExtra.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val simpleIntentExample = Intent(this, SimplePutExtraDestinationActivity::class.java).apply {
                putExtra(MESSAGE, message)
                putExtra(AGE, age)
            }

//            val simpleIntentExample = Intent(this, SimplePutExtraDestinationActivity::class.java)
//            simpleIntentExample.putExtra()
//            simpleIntentExample.putExtra()

            startActivity(simpleIntentExample)
        }

        binding.btnPutExtraBundle.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val bundleSaya = Bundle().apply {
                putString(MESSAGE, message)
                putInt(AGE, age)
            }
            val intentBundle = Intent(this, BundleActivity::class.java).apply {
                putExtra(BUNDLE,bundleSaya)
            }
            startActivity(intentBundle)
        }

        binding.btnPutExtraSerializable.setOnClickListener {
            if(binding.etMhsAge.text.isNotEmpty()){
                val studentAndroid = StudentSerializable(
                    binding.etMhsName.text.toString(),
                    binding.etMhsAge.text.toString().toInt(),
                    binding.etMhsNim.text.toString())

                val intentSerializable = Intent(this, SerializableActivity::class.java).apply {
                    putExtra(OBJECT_SERIALIZABLE, studentAndroid)
                }
                startActivity(intentSerializable)
            }else{
                Toast.makeText(this, "HARAP ISI UMUR", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPutExtraParcelable.setOnClickListener {
            if(binding.etAnmLegs.text.isNotEmpty()){
                val animal = AnimalParcelable(
                    binding.etAnmName.text.toString(),
                    binding.etAnmColor.text.toString(),
                    binding.etAnmLegs.text.toString().toInt(),
                    binding.etAnmEnv.text.toString()
                )

                val intentParcelable = Intent(this, ParcelableActivity::class.java).apply {
                    putExtra(OBJECT_PARCELABLE, animal)
                }

                startActivity(intentParcelable)
            }
        }
    }
}