package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {

    private lateinit var displayResult: TextView
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var navigateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        firstNumber = findViewById<EditText>(R.id.editTextNumber1)
        secondNumber = findViewById<EditText>(R.id.editTextNumber2)
        navigateButton = findViewById<Button>(R.id.navigate_btn)

        displayResult = findViewById<TextView>(R.id.textView)

        val plusButton = findViewById<Button>(R.id.plus_btn)
        plusButton.setOnClickListener {
            val sum = firstNumber.text.toString().toInt() + secondNumber.text.toString().toInt()
            displayResult.text = firstNumber.text.toString() + " + "  + secondNumber.text.toString() + " = " + sum.toString()

        }
        val minusButton = findViewById<Button>(R.id.minus_btn)
        minusButton.setOnClickListener {
            val diff = firstNumber.text.toString().toInt() - secondNumber.text.toString().toInt()
            displayResult.text = firstNumber.text.toString() + " - "  + secondNumber.text.toString() + " = " + diff.toString()
        }

        val activity_result_launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 10) {
                Toast.makeText(this, "Correct result", Toast.LENGTH_LONG).show()
            } else if (result.resultCode == 5) {
                Toast.makeText(this, "Incorrect restul", Toast.LENGTH_LONG).show()
            }
        }

        navigateButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra("display", displayResult.text.toString())
            displayResult.setText("")

            activity_result_launcher.launch(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("display", displayResult.text.toString())
        outState.putString("1", firstNumber.text.toString())
        outState.putString("2", secondNumber.text.toString())
        Toast.makeText(this, "First number: " + firstNumber.text.toString() + " Second Number: " + secondNumber.text.toString()
                + " Result: " + displayResult.text.toString(),
            Toast.LENGTH_LONG
        ).show()

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("display")) {
            displayResult.setText(savedInstanceState.getString("display"))
        }
        if (savedInstanceState.containsKey("1")) {
            firstNumber.setText(savedInstanceState.getString("1"))
        }
        if (savedInstanceState.containsKey("2")) {
            secondNumber.setText(savedInstanceState.getString("2"))
        }
        Toast.makeText(this, "First number: " + firstNumber.text.toString() + " Second Number: " + secondNumber.text.toString()
                + " Result: " + displayResult.text.toString(),
            Toast.LENGTH_LONG
        ).show()

    }
}