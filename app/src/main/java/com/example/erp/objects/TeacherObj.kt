package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "teacher")
class TeacherObj(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("t_id")
    val id: Int,
    @ColumnInfo(name = "name")
    @SerializedName("t_name")
    val name: String,
    @ColumnInfo(name = "branch")
    @SerializedName("t_brn")
    val branchId: Int,
    @ColumnInfo(name = "mobile_number")
    @SerializedName("user_mobile")
    val mobileNumber: Long,
    @ColumnInfo(name = "email")
    @SerializedName("user_email")
    val emailId: String,
    @ColumnInfo(name = "username")
    @SerializedName("login_username")
    val username: String,
    @ColumnInfo(name = "password")
    @SerializedName("login_password")
    val password: String
)