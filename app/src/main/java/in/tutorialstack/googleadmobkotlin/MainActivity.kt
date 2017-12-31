package `in`.tutorialstack.googleadmobkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-7643266345625929~4795636158")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
