package `in`.tutorialstack.googleadmobkotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var mAdView: AdView
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this;

        MobileAds.initialize(this, "ca-app-pub-7643266345625929~4795636158")

        // Banner
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Interstitial
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-7643266345625929/3567501731"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        //RewardedVideoAd
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.loadAd("ca-app-pub-7643266345625929/7404149866", AdRequest.Builder().build())
        mRewardedVideoAd.rewardedVideoAdListener = rewardedVideoAdListener
    }

    fun showInterstitialAd(view: View?) {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }
    }

    fun showRewardedAd(view: View) {
        if (mRewardedVideoAd != null && mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show()
        }
    }

    internal var rewardedVideoAdListener: RewardedVideoAdListener = object : RewardedVideoAdListener {
        override fun onRewardedVideoAdLoaded() {
            Toast.makeText(context, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoAdOpened() {
            Toast.makeText(context, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoStarted() {
            Toast.makeText(context, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoAdClosed() {
            Toast.makeText(context, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show()
        }

        override fun onRewarded(rewardItem: RewardItem) {
            val msg = "onRewarded! currency: " + rewardItem.type + "  amount: " + rewardItem.amount
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoAdLeftApplication() {
            Toast.makeText(context, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoAdFailedToLoad(i: Int) {
            Toast.makeText(context, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        showInterstitialAd(null)
        super.onDestroy()
    }
}
