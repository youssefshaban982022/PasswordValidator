package com.youssefshaaban.passwordvalidator

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val strengthIV: ImageView = findViewById(R.id.pass_strength_iv)
        val btn: MaterialButton = findViewById(R.id.check_btn)
        val container: TextInputLayout = findViewById(R.id.pass_container_til)
        val passET: EditText = findViewById(R.id.pass_et)

        btn.setOnClickListener {
            val password = passET.text.toString().trim()
            container.error = null
            if (password.isBlank()) {
                container.error = "Required!"
                strengthIV.setImageResource(android.R.color.transparent)
            } else if (password.length < 6) {
                strengthIV.setImageResource(android.R.color.transparent)
                Toast.makeText(this, "Short password!", Toast.LENGTH_SHORT).show()
            } else {
                val count = validatePassword(text = password)
                when (count) {
                    1 -> {
                        strengthIV.setImageResource(R.drawable.weak_password)
                        container.boxStrokeColor = android.graphics.Color.RED
                        container.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE)
                        }
                    2 -> {
                        strengthIV.setImageResource(R.drawable.medium_password)
                        container.boxStrokeColor = android.graphics.Color.parseColor("#FFA500") // برتقالي أو لون الصورة
                    }
                    3 -> {
                        strengthIV.setImageResource(R.drawable.strong_password)
                        container.boxStrokeColor = android.graphics.Color.GREEN
                    }
                }



            }
        }
    }
    fun validatePassword(text: String): Int {

        val hasLowercase = Regex("[a-z]").containsMatchIn(text)
        val hasUppercase = Regex("[A-Z]").containsMatchIn(text)
        val hasSpecial = Regex("[^a-zA-Z0-9]").containsMatchIn(text)

        // count how many character categories exist
        val typesCount = listOf(hasLowercase, hasUppercase, hasSpecial).count { it }

        return when (typesCount) {
            1 -> 1   // weak
            2 -> 2   // medium
            3 -> 3   // strong
            else -> 0 // digits only (optional handling)
        }
    }
}