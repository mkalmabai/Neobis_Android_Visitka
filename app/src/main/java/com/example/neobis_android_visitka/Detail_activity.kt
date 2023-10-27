package com.example.neobis_android_visitka

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.neobis_android_visitka.databinding.ActivityDetailBinding

class Detail_activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var phoneNumber: String = ""
    private var message = "Hello"
    private var mail: String = ""
    private var websiteUrl = ""
    private var username_telegram = ""
    private var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phoneNumber = intent.getStringExtra("phoneNumber") ?: ""
        mail = intent.getStringExtra("mail") ?: ""
        websiteUrl = intent.getStringExtra("website") ?: ""
        username_telegram = intent.getStringExtra("username_telegram") ?: ""
        name = intent.getStringExtra("name") ?: ""


        binding.photp2.setImageResource(intent.getIntExtra("icon",0))
        binding.namedoctor.text = name
        binding.profession.text  = intent.getStringExtra("profession")
        setClickListeners()

    }
    private fun tocal_btn(){
        val dialintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialintent)
    }
    private fun whatsapp_btn(){
        val uri = Uri.parse("https://wa.me/$phoneNumber/?text=${Uri.encode(message)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    private fun mail_btn(){
        val emailIntent = Intent(Intent.ACTION_SENDTO)

        emailIntent.data = Uri.parse("mailto:${mail}")
        startActivity(emailIntent)
    }
    private fun website_btn(){
        val intentweb = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
        startActivity(intentweb)
    }
    private fun telegram_btn(){
        val uritel = Uri.parse("http://tg://resolve?domain=$username_telegram/?text=${Uri.encode(message)}")
        val intenttel = Intent(Intent.ACTION_VIEW, uritel)
        startActivity(intenttel)
    }
    private fun contact_btn(){
        val intent = Intent(Intent.ACTION_INSERT)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        intent.putExtra(ContactsContract.Intents.Insert.NAME,name )
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber)
        startActivity(intent)
    }
    private fun setClickListeners() {
            binding.tocallVidget.setOnClickListener{tocal_btn()}
            binding.whatsappVidget.setOnClickListener{whatsapp_btn()}
            binding.mailVidget.setOnClickListener{mail_btn()}
            binding.websiteVidget.setOnClickListener{website_btn()}
            binding.telegramVidget.setOnClickListener{telegram_btn()}
            binding.contactVidget.setOnClickListener {contact_btn()}
    }
}