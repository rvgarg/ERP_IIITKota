package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Announcements")
class AnnouncementObj(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "heading")
    val author: String,
    @ColumnInfo(name = "recipient")
    val recipient: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "content")
    val content: String,
    @ForeignKey(
        entity = Professor::class,
        parentColumns = ["id"],
        childColumns = ["teacherId"]
    )
    @ColumnInfo(name = "teacherId")
    val tId: Int
)