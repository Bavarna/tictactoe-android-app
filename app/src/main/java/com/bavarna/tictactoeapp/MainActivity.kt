package com.bavarna.tictactoeapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bavarna.tictactoeapp.databinding.ActivityMainBinding
import com.bavarna.tictactoeapp.model.GameInput
import com.bavarna.tictactoeapp.model.Result
import com.bavarna.tictactoeapp.viewmodel.TicTacToeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TicTacToeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner= this
        viewModel = ViewModelProvider(this).get(TicTacToeViewModel::class.java)
        binding.viewmodel = viewModel
        setContentView(binding.root)
        startObserver()
    }

    fun startObserver() {
        viewModel.result.observe(this, object : Observer<Result> {
            override fun onChanged(t: Result) {
                when(t) {
                    Result.WIN -> {
                        val builder: AlertDialog.Builder? = this?.let {
                            AlertDialog.Builder(this@MainActivity)
                        }

// 2. Chain together various setter methods to set the dialog characteristics
                        builder?.setMessage(viewModel.getCurrentPlayer() + " Won!")
                            ?.setTitle("Game Over")

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                        val dialog: AlertDialog? = builder?.create()
                        dialog?.show()


                    }
                    Result.DRAW -> {
                        val builder: AlertDialog.Builder? = this?.let {
                            AlertDialog.Builder(this@MainActivity)
                        }

// 2. Chain together various setter methods to set the dialog characteristics
                        builder?.setMessage("Draw")
                            ?.setTitle("Game Over")

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                        val dialog: AlertDialog? = builder?.create()
                        dialog?.show()
                    }

                }
                Log.i("result", t.name)
            }
        })

        viewModel.gameInput.observe(this, object : Observer<Array<Array<String>>> {
            override fun onChanged(t: Array<Array<String>>?) {
                Log.i("input", "changed")
            }
        })


    }
}