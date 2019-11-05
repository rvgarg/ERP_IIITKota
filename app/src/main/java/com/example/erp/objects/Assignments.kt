package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "assignments")
class Assignments(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "issueDate")
    val issueDate: Long,
    @ColumnInfo(name = "submissionDate")
    val submissionDate: Long,
    @ForeignKey(
        entity = Professor::class,
        childColumns = ["teacherId"],
        parentColumns = ["id"]
    )
    @ColumnInfo(name = "teacherId")
    val teacherId: Int,
    @ColumnInfo(name = "class")
    val batch: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "link")
    val link: String
)