package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "assignments")
class Assignments(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("ass_id")
    val id: Int,
    @ColumnInfo(name = "issueDate")
    @SerializedName("add_dt")
    val issueDate: Long,
    @ColumnInfo(name = "submissionDate")
    @SerializedName("sub_dt")
    val submissionDate: Long,
    @ForeignKey(
        entity = TeacherObj::class,
        childColumns = ["teacherId"],
        parentColumns = ["id"]
    )
    @ColumnInfo(name = "teacherId")
    @SerializedName("t_id")
    val teacherId: Int,
    @ColumnInfo(name = "class")
    @SerializedName("class")
    val batch: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "description")
    @SerializedName("ass_desc")
    val description: String,
    @ColumnInfo(name = "link")
    @SerializedName("ass_link")
    val link: String
)