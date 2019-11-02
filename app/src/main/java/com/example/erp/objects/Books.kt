package com.example.erp.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
class Books(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "publications")
    val publications: String,
    @ColumnInfo(name = "writer")
    val writer: String,
    @ColumnInfo(name = "totalQty")
    var totalQty: Int
)