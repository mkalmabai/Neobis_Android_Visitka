package com.example.neobis_android_visitka
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.neobis_android_visitka.databinding.ActivityDetailBinding
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var phoneNumber: String = ""
    private var message = "Hello"
    private var mail: String = ""
    private var websiteUrl = ""
    private var username_telegram = ""
    private var name = ""
    private var geolocation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phoneNumber = intent.getStringExtra("phoneNumber") ?: ""
        mail = intent.getStringExtra("mail") ?: ""
        websiteUrl = intent.getStringExtra("website") ?: ""
        username_telegram = intent.getStringExtra("username_telegram") ?: ""
        name = intent.getStringExtra("name") ?: ""
        geolocation = getString(R.string.geolocation)

        binding.photoProfile.setImageResource(intent.getIntExtra("icon",0))
        binding.namedoctor.text = name
        binding.profession.text  = intent.getStringExtra("profession")

        setClickListeners()

    }
    private fun openPhone(){
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
    }
    private fun openWhatsapp(){
        val whatsappIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://wa.me/$phoneNumber/?text=${Uri.encode(message)}"))
        startActivity(whatsappIntent)
    }
    private fun openEmail(){
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:${mail}")
        startActivity(emailIntent)
    }
    private fun openWebSite(){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl)))
    }
    private fun openTelegram(){
        val telegramIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://t.me/$username_telegram?text=${Uri.encode(message)}"))
        startActivity(telegramIntent)
    }
    private fun saveContact(){
        val intent = Intent(Intent.ACTION_INSERT)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        intent.putExtra(ContactsContract.Intents.Insert.NAME,name )
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber)
        startActivity(intent)
    }
    private fun showUpLocation(){
        val locationIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("geo:${geolocation}?q=${geolocation}"))
        locationIntent.setPackage("com.google.android.apps.maps")
            startActivity(locationIntent)
    }
    private fun setClickListeners() {
            binding.phoneButton.setOnClickListener{openPhone()}
            binding.whatsappButton.setOnClickListener{openWhatsapp()}
            binding.emailButton.setOnClickListener{openEmail()}
            binding.websiteButton.setOnClickListener{openWebSite()}
            binding.telegramButton.setOnClickListener{openTelegram()}
            binding.saveContactButton.setOnClickListener {saveContact()}
            binding.mapButton.setOnClickListener{showUpLocation()}
    }
}