package com.example.neobis_android_visitka

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.TextView
import com.example.neobis_android_visitka.databinding.ActivityDetailBinding
import com.example.neobis_android_visitka.databinding.ActivityMainBinding

class Detail_activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.photp2.setImageResource(intent.getIntExtra("icon",0))

        setClickListeners()

    }
    private fun setClickListeners() {
            binding.tocallVidget.setOnClickListener{
                val phoneNumber = intent.getStringExtra("phoneNumber")
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialIntent)
            }
            binding.whatsappVidget.setOnClickListener{
                val phoneNumber = intent.getStringExtra("phoneNumber")
                val message = "hi"
                val uri = Uri.parse("https://wa.me/$phoneNumber/?text=${Uri.encode(message)}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            binding.mailVidget.setOnClickListener{

                val emailIntent = Intent(Intent.ACTION_SENDTO)
                val mail = intent.getStringExtra("mail")
                emailIntent.data = Uri.parse("mailto:${mail}")
                startActivity(emailIntent)

            }
            binding.websiteVidget.setOnClickListener{
                val websiteUrl = "https://www.example.com"
                val intentweb = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
                startActivity(intentweb)
            }
            binding.telegramVidget.setOnClickListener{
                val username1 = "your_telegram_username"
                val message1 = "Hello, this is your message."
                val uritel = Uri.parse("http://tg://resolve?domain=$username1/?text=${Uri.encode(message1)}")
                val intenttel = Intent(Intent.ACTION_VIEW, uritel)
                startActivity(intenttel)
            }
            binding.contactVidget.setOnClickListener {
                val contactName = "John Doe"
                val contactPhoneNumber = "1234567890"

                val intent = Intent(Intent.ACTION_INSERT)
                intent.type = ContactsContract.Contacts.CONTENT_TYPE

                intent.putExtra(ContactsContract.Intents.Insert.NAME, contactName)
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, contactPhoneNumber)

                startActivity(intent)
            }
    }
}