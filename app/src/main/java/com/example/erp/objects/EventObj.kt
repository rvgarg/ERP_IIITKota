package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "events")
class EventObj(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "URL")
    val URL: String?,
    @ForeignKey(
        entity = Professor::class,
        parentColumns = ["id"],
        childColumns = ["teacherId"]
    )
    @ColumnInfo(name = "teacherId")
    val tId: Int,
    @ColumnInfo(name = "ImageUrls")
    val iUrl: String?

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}