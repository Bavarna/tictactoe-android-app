package com.bavarna.tictactoeapp.viewmodel

import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bavarna.tictactoeapp.model.GameController
import com.bavarna.tictactoeapp.model.GameInput
import com.bavarna.tictactoeapp.model.Result

class TicTacToeViewModel: ViewModel() {
    private var controller: GameController
    var result: MutableLiveData<com.bavarna.tictactoeapp.model.Result> = MutableLiveData(Result.NONE)
    var gameInput: MutableLiveData<Array<Array<String>>>

    init {
        controller = GameController.getInstance(3)
        gameInput = MutableLiveData(controller.getGameInput().inputMatrix)
    }

    fun onButton00Clicked() {
        if(controller.gameInput.inputMatrix[0][0].equals("")) {
            result.postValue(controller.getGameResult(0, 0))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }


    fun onButton01Clicked() {
        if(controller.gameInput.inputMatrix[0][1].equals("")) {
            result.postValue(controller.getGameResult(0, 1))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton02Clicked() {
        if(controller.gameInput.inputMatrix[0][2].equals("")) {
            result.postValue(controller.getGameResult(0, 2))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton10Clicked() {
        if(controller.gameInput.inputMatrix[1][0].equals("")) {
            result.postValue(controller.getGameResult(1, 0))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton11Clicked() {
        if(controller.gameInput.inputMatrix[1][1].equals("")) {
            result.postValue(controller.getGameResult(1, 1))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton12Clicked() {
        if(controller.gameInput.inputMatrix[1][2].equals("")) {
            result.postValue(controller.getGameResult(1, 2))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton20Clicked() {
        if(controller.gameInput.inputMatrix[2][0].equals("")) {
            result.postValue(controller.getGameResult(2, 0))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton21Clicked() {
        if(controller.gameInput.inputMatrix[2][1].equals("")) {
            result.postValue(controller.getGameResult(2, 1))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun onButton22Clicked() {
        if(controller.gameInput.inputMatrix[2][2].equals("")) {
            result.postValue(controller.getGameResult(2, 2))
            gameInput.postValue(controller.gameInput.inputMatrix)
        }
    }

    fun getCurrentPlayer(): String {
        return controller.currentPlayer
    }

    fun reset() {
        controller.resetGame(3)
        gameInput.postValue(controller.gameInput.inputMatrix)
    }

}

