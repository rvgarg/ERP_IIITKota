package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Announcements")
class AnnouncementObj(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("ann_id")
    val id: Int,
    @ColumnInfo(name = "author")
    @SerializedName("ann_author")
    val author: String,
    @ColumnInfo(name = "recipient")
    @SerializedName("ann_recipient")
    val recipient: String,
    @ColumnInfo(name = "year")
    @SerializedName("ann_year")
    val year: Int,
    @ColumnInfo(name = "content")
    @SerializedName("ann_content")
    val content: String,
    @ForeignKey(
        entity = TeacherObj::class,
        parentColumns = ["id"],
        childColumns = ["teacherId"]
    )
    @ColumnInfo(name = "teacherId")
    val tId: Int
)