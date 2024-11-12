package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_practical_test01_var03_secondary)

        val edit_text = findViewById<TextView>(R.id.textView2)
        val correct_button = findViewById<Button>(R.id.button)
        val incorrect_button = findViewById<Button>(R.id.button2)

        correct_button.setOnClickListener {
            setResult(10)
            finish()
        }

        incorrect_button.setOnClickListener {
            setResult(5)
            finish()
        }

        edit_text.setText(intent.getStringExtra("display"))
    }
}