<h2>How to add Google Banner Ads to your Kotlin App</h2>
<b>The following is a step by step guide for us to integrate Google Banner Ads to application.</b>

1. Go to – https://www.google.com/adsense
2. Select AdMob option from menu
3. Sign in to – https://www.google.com/admob
4. Click on Add App button and Enter application name, select android platform and click on ADD button.
5. Setup Banner Ads 
6. Saved app ID and app Unit ID

Open <strong>project-level build.gradle</strong> and add <strong>maven</strong> directive and click on <strong>sync now </strong>
<pre>maven {
    url "https://maven.google.com"
}</pre>

Open <strong>app-level build.gradle</strong> and add latest <strong>google ads</strong> dependency for added Mobile Ads SDK and select <strong>Sync</strong> button
<pre>compile 'com.google.android.gms:play-services-ads:11.6.0'</pre>

Adding Mobile Ads SDK by calling <strong>MobileAds.initialize()</strong> with saved <strong>AdMob App ID</strong>
<pre>MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");
</pre>

<strong>banner sizes</strong>
<table>
<tbody>
<tr>
<th>Size in dp (WxH)</th>
<th>Description</th>
<th>Availability</th>
<th>AdSize constant</th>
</tr>
<tr>
<td>320x50</td>
<td>Standard Banner</td>
<td>Phones and Tablets</td>
<td><code>BANNER</code></td>
</tr>
<tr>
<td>320x100</td>
<td>Large Banner</td>
<td>Phones and Tablets</td>
<td><code>LARGE_BANNER</code></td>
</tr>
<tr>
<td>300x250</td>
<td>IAB Medium Rectangle</td>
<td>Phones and Tablets</td>
<td><code>MEDIUM_RECTANGLE</code></td>
</tr>
<tr>
<td>468x60</td>
<td>IAB Full-Size Banner</td>
<td>Tablets</td>
<td><code>FULL_BANNER</code></td>
</tr>
<tr>
<td>728x90</td>
<td>IAB Leaderboard</td>
<td>Tablets</td>
<td><code>LEADERBOARD</code></td>
</tr>
<tr>
<td><i>Screen width</i> x 32|50|90</td>
<td>Smart Banner</td>
<td>Phones and Tablets</td>
<td><code>SMART_BANNER</code></td>
</tr>
</tbody>
</table>

<h3 id="load_an_ad">Load an ad</h3>

<pre>AdView mAdView = findViewById(R.id.adView);
AdRequest adRequest = new AdRequest.Builder().build();
mAdView.loadAd(adRequest);
</pre>

Add above code in activity.

<a href="http://tutorialstack.in/google-banner-ads-kotlin-admob" target="_blank" rel="noopener"><strong>Implement Banner Ads Kotlin</strong></a>

<a href="https://tutorialstack.in/google-banner-interstitial-rewardedvideo-ads-kotlin" target="_blank" rel="noopener"><strong>Interstitial and RewardedVideo Ads Kotlin</strong></a>



