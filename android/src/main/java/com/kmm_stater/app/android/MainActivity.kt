package com.kmm_stater.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kmm_stater.app.android.navigation.MainNavGraph
import com.kmm_stater.app.android.theme.KMMSTheme
import com.kmm_stater.app.common.core.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin {
            androidContext(applicationContext)
        }
        setContent {
            val navController = rememberNavController()

            KMMSTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainNavGraph(navController)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}