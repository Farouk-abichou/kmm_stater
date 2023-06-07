package com.lissene_kids.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lissene_kids.app.android.navigation.MainNavGraph
import com.lissene_kids.app.android.theme.LkTheme
import com.lissene_kids.app.common.core.di.initKoin
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

            LkTheme {
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