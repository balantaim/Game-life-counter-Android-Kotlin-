package com.rainbowinfinium.invasion.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rainbowinfinium.invasion.R
import com.rainbowinfinium.invasion.viewmodel.BattleViewModel

@Composable
fun playerCardTable(viewModel: BattleViewModel, player: Int){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image( painter = painterResource (R.drawable.ic_arrow_left),
            contentDescription = stringResource(id = R.string.minus_life),
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.CenterStart)
                .padding(start = 6.dp)
                .clickable { viewModel.onLifeDecrease(player) }
            //.clip(CircleShape)
        )
        Text(text = viewModel.playerTwo,
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
                .clickable { viewModel.onLifeIncrease(player) }
            //.clip(CircleShape)
        )
    }
}
@Composable
fun playerCardTableRotation(viewModel: BattleViewModel, player: Int){
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
                .clickable { viewModel.onLifeDecrease(player) }
            //.clip(CircleShape)
        )
        Text(text = viewModel.playerOne,
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
                .clickable { viewModel.onLifeIncrease(player) }
            //.clip(CircleShape)
        )
    }
}