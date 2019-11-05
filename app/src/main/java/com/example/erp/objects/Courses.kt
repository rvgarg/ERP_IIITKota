package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
class Courses(
    @ColumnInfo(name = "courseId")
    val cId: String,
    @ForeignKey(
        entity = Professor::class,
        parentColumns = ["id"],
        childColumns = ["id"]
    )
    @ColumnInfo(name = "id")
    val tId: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "batch")
    val batch: String,
    @ColumnInfo(name = "branch")
    val branch: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Cid")
    var id: Int = 0
}