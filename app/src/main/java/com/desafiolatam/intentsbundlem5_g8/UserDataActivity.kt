package com.desafiolatam.intentsbundlem5_g8

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.desafiolatam.intentsbundlem5_g8.databinding.ActivityUserDataBinding
import com.desafiolatam.intentsbundlem5_g8.model.User

class UserDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras?.getBundle("BUNDLE_KEY")
        val user01 = bundle?.getParcelable<User>("USER_KEY")
        val user02 = bundle?.getParcelable<User>("LALA")

        if (user01 != null) {
            Log.i("INFO","Nombre " + user01.name)
            binding.textViewUser01.text = "Nombre: " + user01.name + " tiene " + user01.age + " años."
        }

        if (user02 != null) {
            Log.i("INFO", "Nombre " + user02.name)
            binding.textViewUser02.text = "Nombre: " + user02.name + " tiene " + user02.age + " años."
        }





    }
}