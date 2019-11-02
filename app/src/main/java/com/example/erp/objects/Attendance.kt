package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")
class Attendance(
    @ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["studentId"]
    )
    @ColumnInfo(name = "studentId")
    val studentId: String,
    @ForeignKey(
        entity = Courses::class,
        parentColumns = ["courseId"],
        childColumns = ["courseId"]
    )
    @ColumnInfo(name = "courseId")
    val course: Int,
    @ColumnInfo(name = "present")
    val presence: Boolean,
    @ColumnInfo(name = "date")
    val date: Long
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}