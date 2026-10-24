
package com.ute.a348_doanngoctuong_bt_event_validation

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ute.a348_doanngoctuong_bt_event_validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDangKy.setOnClickListener {
            if (kiemTraDuLieu()) {
                Toast.makeText(
                    this,
                    "Đăng ký thành công!",
                    Toast.LENGTH_SHORT
                ).show()

                binding.tvThongBao.setTextColor(
                    android.graphics.Color.rgb(46, 125, 50)
                )
                binding.tvThongBao.text =
                    "Thông tin hợp lệ. Bạn đã đăng ký thành công!"
            }
        }
    }

    private fun kiemTraDuLieu(): Boolean {
        var hopLe = true

        val hoTen = binding.edtHoTen.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val soDienThoai =
            binding.edtSoDienThoai.text.toString().trim()
        val mssv = binding.edtMssv.text.toString().trim()
        val lop = binding.edtLop.text.toString().trim()

        // Kiểm tra họ tên
        if (hoTen.length < 2) {
            binding.edtHoTen.error =
                "Họ và tên phải có ít nhất 2 ký tự"
            hopLe = false
        } else {
            binding.edtHoTen.error = null
        }

        // Kiểm tra email
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error =
                "Vui lòng nhập email đúng định dạng"
            hopLe = false
        } else {
            binding.edtEmail.error = null
        }

        // Kiểm tra số điện thoại
        val mauSoDienThoai = Regex("^0[0-9]{9}$")

        if (!mauSoDienThoai.matches(soDienThoai)) {
            binding.edtSoDienThoai.error =
                "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"
            hopLe = false
        } else {
            binding.edtSoDienThoai.error = null
        }

        // Kiểm tra mã số sinh viên
        if (mssv.isEmpty()) {
            binding.edtMssv.error =
                "Vui lòng nhập mã số sinh viên"
            hopLe = false
        } else {
            binding.edtMssv.error = null
        }

        // Kiểm tra lớp
        if (lop.isEmpty()) {
            binding.edtLop.error =
                "Vui lòng nhập tên lớp"
            hopLe = false
        } else {
            binding.edtLop.error = null
        }

        if (!hopLe) {
            binding.tvThongBao.setTextColor(
                android.graphics.Color.rgb(211, 47, 47)
            )
            binding.tvThongBao.text =
                "Vui lòng kiểm tra lại các thông tin chưa hợp lệ."
        }

        return hopLe
    }
}
