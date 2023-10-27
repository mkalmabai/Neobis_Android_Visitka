package com.example.neobis_android_visitka


import android.content.Intent
import android.net.wifi.ScanResult.InformationElement
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.neobis_android_visitka.databinding.ActivityDetailBinding
import com.example.neobis_android_visitka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity";
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }
        private fun setClickListeners() {
            binding.doctor1.setOnClickListener {
                handleClick(
                    getString(R.string.azamat),
                    getString(R.string.azamat_profession),
                    getString(R.string.azamat_Number),
                    getString(R.string.azamat_mail),
                    R.drawable.telegramicon, ) }

        }

        private fun handleClick(surname: String,
                                profession: String,
                                phoneNumber: String,
                                mail: String,
                                icon: Int,
                                ) {
            val intent = Intent(this, Detail_activity::class.java).apply {
                putExtra("name", surname)
                putExtra("profession", profession)
                putExtra("phoneNumber", phoneNumber)
                putExtra("mail", mail)
                putExtra("icon", icon)

            }
            startActivity(intent)
        }
    }
