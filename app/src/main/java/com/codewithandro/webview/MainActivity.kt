package com.codewithandro.webview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val webViewVar = findViewById<WebView>(R.id.webViewBtn)
        webViewSetup(webViewVar)//calling webViewSetup function simple function

        val linkBtn = findViewById<Button>(R.id.linkWebsite)
        linkFunction(linkBtn) //href link function simple function

    }


    //webviewSetup function
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(a: WebView) {
//a - varname
        a.webViewClient = WebViewClient()

        a.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://iasnama.blogspot.com/")

        }
    }

    //link function create
    private fun linkFunction(a: Button) {
        a.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://iasnama.blogspot.com/")
            startActivity(intent)
        }
    }
}