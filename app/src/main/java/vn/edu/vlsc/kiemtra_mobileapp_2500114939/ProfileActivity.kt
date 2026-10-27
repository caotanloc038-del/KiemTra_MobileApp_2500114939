package vn.edu.vlsc.kiemtra_mobileapp_2500114939

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById (đề ghi findViewModel là lỗi typo)
        val tvEmailDisplay = findViewById<TextView>(R.id.tvEmailDisplay)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận dữ liệu từ Intent
        val email = intent.getStringExtra("EMAIL_USER")
        tvEmailDisplay.text = "Email: $email"

        // Xử lý nút Đăng xuất
        btnLogout.setOnClickListener {
            finish() // Đóng Activity hiện tại, quay về Login
        }
    }
}