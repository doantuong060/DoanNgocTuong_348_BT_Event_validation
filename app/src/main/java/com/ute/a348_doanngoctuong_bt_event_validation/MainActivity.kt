package com.ute.a348_doanngoctuong_bt_event_validation

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ute.a348_doanngoctuong_bt_event_validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDangKy.setOnClickListener {
            if (kiemTraDuLieu()) {
                hienThiThongBaoThanhCong()
            }
        }
    }

    private fun kiemTraDuLieu(): Boolean {
        var hopLe = true

        val hoTen = binding.edtHoTen.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val soDienThoai = binding.edtSoDienThoai.text.toString().trim()
        val mssv = binding.edtMssv.text.toString().trim()
        val lop = binding.edtLop.text.toString().trim()

        if (hoTen.length < 2) {
            binding.edtHoTen.error = "Họ và tên phải có ít nhất 2 ký tự"
            hopLe = false
        } else {
            binding.edtHoTen.error = null
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "Vui lòng nhập email đúng định dạng"
            hopLe = false
        } else {
            binding.edtEmail.error = null
        }

        if (!Regex("^0[0-9]{9}$").matches(soDienThoai)) {
            binding.edtSoDienThoai.error =
                "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"
            hopLe = false
        } else {
            binding.edtSoDienThoai.error = null
        }

        if (mssv.isEmpty()) {
            binding.edtMssv.error = "Vui lòng nhập mã số sinh viên"
            hopLe = false
        } else {
            binding.edtMssv.error = null
        }

        if (lop.isEmpty()) {
            binding.edtLop.error = "Vui lòng nhập tên lớp"
            hopLe = false
        } else {
            binding.edtLop.error = null
        }

        if (!hopLe) {
            binding.tvThongBao.setTextColor(Color.rgb(211, 47, 47))
            binding.tvThongBao.text =
                "Vui lòng kiểm tra lại các thông tin chưa hợp lệ."
        }

        return hopLe
    }

    private fun hienThiThongBaoThanhCong() {
        binding.tvThongBao.setTextColor(Color.rgb(46, 125, 50))
        binding.tvThongBao.text = "Thông tin hợp lệ."

        Snackbar.make(
            binding.root,
            "Đăng ký thành công!",
            Snackbar.LENGTH_LONG
        ).setAction("Xem chi tiết") {
            val sinhVien = SinhVien(
                hoTen = binding.edtHoTen.text.toString().trim(),
                email = binding.edtEmail.text.toString().trim(),
                soDienThoai = binding.edtSoDienThoai.text.toString().trim(),
                mssv = binding.edtMssv.text.toString().trim(),
                lop = binding.edtLop.text.toString().trim()
            )

            val intent = android.content.Intent(
                this,
                DetailActivity::class.java
            )

            intent.putExtra(DetailActivity.EXTRA_SINH_VIEN, sinhVien)
            startActivity(intent)
        }.show()
    }
}
