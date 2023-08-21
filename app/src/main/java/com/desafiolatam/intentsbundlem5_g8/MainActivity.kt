package com.desafiolatam.intentsbundlem5_g8

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.desafiolatam.intentsbundlem5_g8.databinding.ActivityMainBinding
import com.desafiolatam.intentsbundlem5_g8.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user1: User = User(1,"Armando Casas",42)
        val user2: User = User(2,"Elba Lazo",38)

        val bundle = Bundle().apply {
            putParcelable("USER_KEY",user1)
            putParcelable("LALA",user2)
        }

        /**
         * Actividad 1
         */
        binding.buttonIntentUser.setOnClickListener {
            startActivity(Intent(this,UserDataActivity::class.java).apply {
                putExtra("BUNDLE_KEY",bundle)
            })
        }


        /**
         * Actividad 2
         */
        val geo = Uri.parse("geo:-33.4978396,-70.6622213?z=17")
        val geo2 = Uri.parse("google.streetview:cbll=51.17885270841654,-1.8261525945670793")
        val mapIntent = Intent(Intent.ACTION_VIEW,geo)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(packageManager)?.let {

        }

        binding.buttonIntentMapa.setOnClickListener {
            startActivity(mapIntent)
        }

        /**
         * Actividad 3
         */


        /**
         * Actividad Extra
         */
        binding.buttonIntentCamara.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }


    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = binding.imageViewCaptura
            imageView.setImageBitmap(imageBitmap)
        }
    }
}