package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book_issue")
class BooksIsued(
    @ColumnInfo(name = "bookId")
    @ForeignKey(
        entity = Books::class,
        childColumns = ["bookId"],
        parentColumns = ["id"]
    )
    val bookId: Int,
    @ForeignKey(
        entity = Student::class,
        childColumns = ["studentId"],
        parentColumns = ["id"]
    )
    @ColumnInfo(name = "studentId")
    val studentId: String,
    @ColumnInfo(name = "issueDate")
    val issueDate: Long,
    @ColumnInfo(name = "returnDate")
    var returnDate: Long?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}