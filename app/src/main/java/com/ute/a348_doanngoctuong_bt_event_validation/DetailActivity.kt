package com.ute.a348_doanngoctuong_bt_event_validation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.a348_doanngoctuong_bt_event_validation.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_SINH_VIEN = "EXTRA_SINH_VIEN"
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sinhVien =
            intent.getSerializableExtra(EXTRA_SINH_VIEN) as? SinhVien

        if (sinhVien == null) {
            finish()
            return
        }

        binding.tvChiTietHoTen.text = "Họ và tên: ${sinhVien.hoTen}"
        binding.tvChiTietEmail.text = "Email: ${sinhVien.email}"
        binding.tvChiTietSoDienThoai.text =
            "Số điện thoại: ${sinhVien.soDienThoai}"
        binding.tvChiTietMssv.text = "Mã số sinh viên: ${sinhVien.mssv}"
        binding.tvChiTietLop.text = "Lớp: ${sinhVien.lop}"

        binding.btnQuayLai.setOnClickListener {
            finish()
        }
    }
}
