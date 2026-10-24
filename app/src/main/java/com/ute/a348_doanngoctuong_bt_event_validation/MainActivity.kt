package com.ute.a348_doanngoctuong_bt_event_validation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.a348_doanngoctuong_bt_event_validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDangKy.setOnClickListener {
            binding.tvThongBao.text =
                "Chức năng kiểm tra thông tin sẽ được bổ sung ở bước tiếp theo."
        }
    }
}
