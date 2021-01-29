package com.dewonderstruck.apps.stickrs
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.dewonderstruck.apps.stickrs.util.SharedObjects


class SplashActivity : AppCompatActivity() {
    @JvmField
    @BindView(R.id.txtVersionName)
    var txtVersionName: TextView? = null
    var sharedObjects: SharedObjects? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        sharedObjects = SharedObjects(this@SplashActivity)
        ButterKnife.bind(this)
        //setResult(Activity.RESULT_OK)
        txtVersionName!!.text = getString(R.string.version, SharedObjects.getVersion(this@SplashActivity))
        val content: ConstraintLayout = findViewById(R.id.contSplash)
        content.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        Handler().postDelayed({
            val intentLogin: Intent
            intentLogin = Intent(this@SplashActivity, MainActivity::class.java)
            intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentLogin)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 6000
    }
}