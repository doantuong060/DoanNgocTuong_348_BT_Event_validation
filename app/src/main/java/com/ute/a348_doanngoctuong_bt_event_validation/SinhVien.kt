
package com.ute.a348_doanngoctuong_bt_event_validation

import java.io.Serializable

data class SinhVien(
    val hoTen: String,
    val email: String,
    val soDienThoai: String,
    val mssv: String,
    val lop: String
) : Serializable
