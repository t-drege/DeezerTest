package com.example.deezer_test.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.deezer_test.R
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * The class description here.
 *
 * @author Thomas Drège
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var mViewModeFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        requestedOrientation = if (resources.getBoolean(R.bool.isTablet)) {
            ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        } else {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }
}