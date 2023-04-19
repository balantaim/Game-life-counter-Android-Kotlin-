package com.rainbowinfinium.invasion

import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.rainbowinfinium.invasion.ui.theme.InvasionTheme
import com.rainbowinfinium.invasion.viewmodel.BattleViewModel
import com.rainbowinfinium.invasion.widget.playerCardTable
import com.rainbowinfinium.invasion.widget.playerCardTableRotation


class MainActivity : ComponentActivity() {

    private val battleViewModel by viewModels<BattleViewModel>()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvasionTheme {
                setFullscreen(window)
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    UserField(battleViewModel)
                    //aa
                }
            }
        }
    }
}
@Composable
fun UserField(viewModel: BattleViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f)
            .background(Color.Cyan)
            .padding(6.dp)
            ) {
            playerCardTableRotation(viewModel = viewModel, player = 1)
        }
        Row(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .background(Color.Gray)
            .padding(6.dp)
        ) {
            playerCardTable(viewModel = viewModel, player = 2)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InvasionTheme {
        UserField(viewModel = BattleViewModel())
    }
}
private fun setFullscreen(window: Window) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window,
        window.decorView.findViewById(android.R.id.content)).let { controller ->
        controller.hide(WindowInsetsCompat.Type.systemBars())
        // When the screen is swiped up at the bottom
        // of the application, the navigationBar shall
        // appear for some time
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}
