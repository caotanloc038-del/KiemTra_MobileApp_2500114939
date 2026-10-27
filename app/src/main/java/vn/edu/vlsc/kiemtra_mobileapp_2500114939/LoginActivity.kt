package vn.edu.vlsc.kiemtra_mobileapp_2500114939

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view bằng findViewById
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // Kiểm tra lỗi
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Vui lòng không để trống Email hoặc Mật khẩu!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "Email không đúng định dạng!"
            } else if (password.length <= 6) {
                tvStatus.text = "Mật khẩu phải lớn hơn 6 ký tự!"
            } else {
                tvStatus.text = "Đăng nhập hợp lệ"
                // Chuyển sang Câu 2 (sẽ làm ở nhánh cau-2)
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("EMAIL_USER", email)
                startActivity(intent)
            }
        }
    }
}