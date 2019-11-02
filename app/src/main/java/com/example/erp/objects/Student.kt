package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
class Student(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val studentId: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "mobile")
    var mobile: Long,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "year")
    var year: Int,
    @ColumnInfo(name = "age")
    var age: Int,
    @ColumnInfo(name = "password")
    var pass: String,
    @ColumnInfo(name = "branch")
    val branch: String,
    @ColumnInfo(name = "batch")
    val batch: String
)