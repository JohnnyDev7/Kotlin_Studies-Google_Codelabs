package com.devsdimension.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Para reformatar o código, selecione o código utilizando Ctrl+A
 * e, no menu do Android Studio, clique em Code>Reformat Code (Ctrl+Alt+L).
 */

/**
 * This activity allows the user to roll a dice and view result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled!!!", Toast.LENGTH_SHORT).show()
            //val toast = Toast.makeText(this, "Dice Rolled!!!", Toast.LENGTH_SHORT)
            //toast.show()

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

            rollDice()
        }
        /**
         * Boas Práticas - Código Condensado
         * Código com apenas uma instrução pode ser escrito em uma única linha.
         */
        //rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}