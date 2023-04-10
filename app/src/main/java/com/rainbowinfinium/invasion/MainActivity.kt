package com.rainbowinfinium.invasion

import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.rainbowinfinium.invasion.ui.theme.InvasionTheme
import com.rainbowinfinium.invasion.viewmodel.OneVOneViewModel


class MainActivity : ComponentActivity() {

    private val battleViewModel by viewModels<OneVOneViewModel>()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvasionTheme {
                // A surface container using the 'background' color from the theme
                setFullscreen(window)
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    //                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
//                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

//                window.decorView.apply {
//                    // Hide both the navigation bar and the status bar.
//                    // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
//                    // a general rule, you should design your app to hide the status bar whenever you
//                    // hide the navigation bar.
//                    systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
//                }

                    UserField(battleViewModel)
                }
            }
        }
    }
}
@Composable
fun UserField(viewModel: OneVOneViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f)
            .background(Color.Cyan)
            .padding(6.dp)
            ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(rotationZ = 180f)
            ){
                Image( painter = painterResource (R.drawable.ic_arrow_left),
                    contentDescription = stringResource(id = R.string.minus_life),
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 6.dp)
                    //.clip(CircleShape)
                )
                Text(text = viewModel.baseLife.toString(),
                    modifier = Modifier
                        .align(Alignment.Center)
                    , fontSize = 100.sp
                    , color = Color.White)
                Image( painter = painterResource (R.drawable.ic_arrow_right),
                    contentDescription = stringResource(id = R.string.plus_life),
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 6.dp)
                    //.clip(CircleShape)
                )
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .background(Color.Gray)
            .padding(6.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                ){
                Image( painter = painterResource (R.drawable.ic_arrow_left),
                    contentDescription = stringResource(id = R.string.minus_life),
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 6.dp)
                    //.clip(CircleShape)
                )
                Text(text = viewModel.baseLife.toString(),
                    modifier = Modifier
                        .align(Alignment.Center)
                        , fontSize = 100.sp
                , color = Color.White)
                Image( painter = painterResource (R.drawable.ic_arrow_right),
                    contentDescription = stringResource(id = R.string.plus_life),
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 6.dp)
                    //.clip(CircleShape)
                )
            }
        }
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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InvasionTheme {
        UserField(viewModel = OneVOneViewModel())
    }
}