package com.rainbowinfinium.invasion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BattleViewModel : ViewModel() {

    var baseLife: Int = 20
    //state
    var playerOne by mutableStateOf(baseLife.toString())
    var playerTwo by mutableStateOf(baseLife.toString())
    var playerThree by mutableStateOf(baseLife.toString())
    var playerFour by mutableStateOf(baseLife.toString())

    fun onLifeIncrease(player: Int) {
        when (player) {
            1 -> {
                val sum = playerOne.toInt() + 1
                playerOne = sum.toString()
            }
            2 -> {
                val sum = playerTwo.toInt() + 1
                playerTwo = sum.toString()
            }
            3 -> {
                val sum = playerThree.toInt() + 1
                playerThree = sum.toString()
            }
            else -> {
                val sum = playerFour.toInt() + 1
                playerFour = sum.toString()
            }
        }
    }
    fun onLifeDecrease(player: Int) {
        when (player) {
            1 -> {
                val sum = playerOne.toInt() - 1
                playerOne = sum.toString()
            }
            2 -> {
                val sum = playerTwo.toInt() - 1
                playerTwo = sum.toString()
            }
            3 -> {
                val sum = playerThree.toInt() - 1
                playerThree = sum.toString()
            }
            else -> {
                val sum = playerFour.toInt() - 1
                playerFour = sum.toString()
            }
        }
    }

}