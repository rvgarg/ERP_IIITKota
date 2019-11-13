package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher")
class Professor(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "branch")
    val branchId: String,
    @ColumnInfo(name = "mobile_number")
    val mobileNumber: Long,
    @ColumnInfo(name = "email")
    val emailId: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "JoiningDate")
    val joiningDate: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}