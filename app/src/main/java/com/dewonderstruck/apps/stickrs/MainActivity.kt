package com.dewonderstruck.apps.stickrs

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.dewonderstruck.apps.stickrs.util.SharedObjects
import com.github.javiersantos.appupdater.AppUpdaterUtils
import com.github.javiersantos.appupdater.enums.AppUpdaterError
import com.github.javiersantos.appupdater.objects.Update
import com.google.ads.consent.*
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {
    private var form: ConsentForm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        requestConsent(this)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val url = "https://signalstickers.com/contribute"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    fun requestConsent(activity: Activity) {
        val consentInformation = ConsentInformation.getInstance(activity)
        val publisherIds = arrayOf(activity.getString(R.string.admob_publisher_id))
        consentInformation.requestConsentInfoUpdate(
            publisherIds,
            object : ConsentInfoUpdateListener {
                override fun onConsentInfoUpdated(consentStatus: ConsentStatus) {
                    Log.d("test--", consentStatus.toString())
                    when (consentStatus) {
                        ConsentStatus.PERSONALIZED -> showPersonalizedAds()
                        ConsentStatus.NON_PERSONALIZED -> showNonPersonalizedAds()
                        ConsentStatus.UNKNOWN -> displayConsentForm(activity)
                    }
                }

                override fun onFailedToUpdateConsentInfo(errorDescription: String) {
                    //onFailedToUpdateConsentInfo()
                }
            })
    }

    private fun showPersonalizedAds() {
        ConsentInformation.getInstance(this).consentStatus = ConsentStatus.PERSONALIZED
    }

    private fun showNonPersonalizedAds() {
        ConsentInformation.getInstance(this).consentStatus = ConsentStatus.NON_PERSONALIZED
    }


    private fun displayConsentForm(activity: Activity) {
        var privacyUrl: URL? = null
        try {
            privacyUrl = URL(getString(R.string.privacy_policy))
        } catch (e: MalformedURLException) {
            Log.e("MainAct:", "Error processing privacy policy url", e)
        }
        form = ConsentForm.Builder(this, privacyUrl)
            .withListener(object : ConsentFormListener() {
                override fun onConsentFormLoaded() {
                    // Consent form loaded successfully.
                    form!!.show()
                }

                override fun onConsentFormOpened() {
                    // Consent form was displayed.
                }

                override fun onConsentFormClosed(
                    consentStatus: ConsentStatus,
                    userPrefersAdFree: Boolean
                ) {

                    if (consentStatus == ConsentStatus.PERSONALIZED) initializeAds(true) else initializeAds(
                        false
                    )
                }

                override fun onConsentFormError(errorDescription: String) {
                    // Consent form error. This usually happens if the user is not in the EU.
                    Log.e(
                        "MainAct:",
                        "Error loading consent form: $errorDescription"
                    )
                }
            })
            .withPersonalizedAdsOption()
            .withNonPersonalizedAdsOption()
            .build()
        form?.load()
    }

    private fun initializeAds(isPersonalized: Boolean) {
        // initialize AdMob and configre your ad

        // this is the part you need to add/modify on your code
        val adRequest: AdRequest
        adRequest = if (isPersonalized) {
            AdRequest.Builder().build()
        } else {
            val extras = Bundle()
            extras.putString("npa", "1")
            AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter::class.java, extras)
                .build()
        }

    }

    override fun onStart() {
        super.onStart()
        if (SharedObjects.isNetworkConnected(this@MainActivity)) {
            val appUpdaterUtils = AppUpdaterUtils(this)
                .withListener(object : AppUpdaterUtils.UpdateListener {
                    override fun onSuccess(update: Update, isUpdateAvailable: Boolean) {
                        if (isUpdateAvailable) {
                            launchUpdateDialog(update.latestVersion)
                        }
                    }

                    override fun onFailed(error: AppUpdaterError) {}
                })
            appUpdaterUtils.start()
        }
        val content: CoordinatorLayout = findViewById(R.id.container)
        content.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }


    private fun launchUpdateDialog(onlineVersion: String) {
        try {
            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this@MainActivity)
            materialAlertDialogBuilder.setMessage(
                "Update " + onlineVersion + " is available to download. Downloading the latest update you will get the latest features," +
                        "improvements and bug fixes of " + getString(R.string.app_name)
            )
            materialAlertDialogBuilder.setCancelable(false).setPositiveButton(resources.getString(R.string.update_now)) { dialog, which ->
                dialog.dismiss()
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
            materialAlertDialogBuilder.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_share -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}