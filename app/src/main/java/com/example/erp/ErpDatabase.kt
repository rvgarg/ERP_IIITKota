package com.example.erp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.erp.objects.*

@Database(
    entities = [AnnouncementObj::class, Assignments::class, Attendance::class, Books::class, BooksIsued::class, Courses::class, EventObj::class, Student::class, Professor::class],
    version = 1
)
abstract class ErpDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: ErpDatabase? = null

        fun getDatabase(context: Context): ErpDatabase? {
            if (INSTANCE == null) {
                synchronized(ErpDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder<ErpDatabase>(
                            context.applicationContext,
                            ErpDatabase::class.java,
                            "erp"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
    abstract fun erpDao(): ErpDao
}