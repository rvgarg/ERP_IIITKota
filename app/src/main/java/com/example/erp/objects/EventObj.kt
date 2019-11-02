package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "events")
class EventObj(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("event_id")
    val id: Int,
    @ColumnInfo(name = "name")
    @SerializedName("event_name")
    val name: String,
    @ColumnInfo(name = "date")
    @SerializedName("event_date")
    val date: Long,
    @ColumnInfo(name = "contact_name")
    @SerializedName("event_contact_name")
    val ContactNmae: String,
    @ColumnInfo(name = "contact_number")
    @SerializedName("event_contact_number")
    val ContactNumber: Long,
    @ForeignKey(entity = TeacherObj::class,
        parentColumns = ["id"],
        childColumns = ["teacherId"])
    @ColumnInfo(name = "teacherId")
    val tId: Int
)