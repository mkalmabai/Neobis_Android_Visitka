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
                    R.drawable.ph2,
                    getString(R.string.azamat_website),
                    getString(R.string.azamat_telegram),) }
            binding.doctor2.setOnClickListener {
                handleClick(
                    getString(R.string.zamir),
                    getString(R.string.zamir_profession),
                    getString(R.string.zamir_Number),
                    getString(R.string.zamir_mail),
                    R.drawable.ph3,
                    getString(R.string.zamir_website),
                    getString(R.string.zamir_telegram),) }
            binding.doctor3.setOnClickListener {
                handleClick(
                    getString(R.string.munisa),
                    getString(R.string.munisa_profession),
                    getString(R.string.munisa_Number),
                    getString(R.string.munisa_mail),
                    R.drawable.ph1,
                    getString(R.string.munisa_website),
                    getString(R.string.munisa_telegram),) }
        }

        private fun handleClick(surname: String,
                                profession: String,
                                phoneNumber: String,
                                mail: String,
                                icon: Int,
                                website:String,
                                username_telegram:String,
                                ) {
            val intent = Intent(this, Detail_activity::class.java).apply {
                putExtra("name", surname)
                putExtra("profession", profession)
                putExtra("phoneNumber", phoneNumber)
                putExtra("mail", mail)
                putExtra("icon", icon)
                putExtra("website", website)
                putExtra("username_telegram", username_telegram)

            }
            startActivity(intent)
        }
    }
