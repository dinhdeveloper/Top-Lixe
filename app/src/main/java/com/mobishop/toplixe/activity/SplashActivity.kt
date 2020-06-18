package com.mobishop.toplixe.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.activity.SplashAdapter
import com.mobishop.toplixe.viewmodel.activity.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private var splashViewModel: SplashViewModel? = null
    private var splashAdapter: SplashAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        splashViewModel!!.getData().observe(this, Observer {
            splashAdapter = SplashAdapter(
                applicationContext,
                it
            )
            viewPager.adapter = splashAdapter
            splashAdapter?.notifyDataSetChanged()
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentLayout(position)
            }
        })
        buttonNext?.setOnClickListener(View.OnClickListener {
            if (viewPager.currentItem + 1 < splashAdapter!!.itemCount) {
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
                finish()
            }
        })

    }

    private fun setUpLayout() {
        val imageViews = arrayOfNulls<ImageView>(splashAdapter!!.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in 0..2) {
            imageViews[i] = ImageView(applicationContext)
            imageViews[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.onboarding_inactive
                )
            )
            imageViews[i]!!.layoutParams = layoutParams
            layoutLine.addView(imageViews[i])
        }
    }

    private fun setCurrentLayout(index: Int) {
        val childCount: Int = layoutLine.childCount
        for (i in 0 until childCount) {
            val imageView =
                layoutLine.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_inactive
                    )
                )
            }
        }
        if (index == splashAdapter!!.itemCount - 1) {
            buttonNext.text = "Start"
            buttonNext.transformationMethod = null
        } else {
            buttonNext.text = "Next"
            buttonNext.transformationMethod = null
        }
    }
}