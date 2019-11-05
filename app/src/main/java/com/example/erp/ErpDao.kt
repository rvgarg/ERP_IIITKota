package com.example.erp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.erp.objects.*

@Dao
interface ErpDao {
    @Insert
    fun announcementInsert(announcementObj: AnnouncementObj)

    @Insert
    fun assignmentInsert(assignments: Assignments)

    @Insert
    fun attendanceInsert(attendance: Attendance)

    @Insert
    fun booksInsert(books: Books)

    @Insert
    fun booksIssuedInsert(booksIsued: BooksIsued)

    @Insert
    fun coursesInsert(courses: Courses)

    @Insert
    fun eventInsert(eventObj: EventObj)

    @Insert
    fun studentInsert(student: Student)

    @Insert
    fun teacherInsert(professor: Professor)

    @Query("SELECT * FROM student WHERE id = :loginId AND password = :password")
    fun loginStudent(loginId: String, password: String): Student

    @Query("SELECT * FROM teacher WHERE id = :loginId AND password = :password")
    fun loginTeacher(loginId: String, password: String): Professor

    @Query("SELECT * FROM assignments WHERE year = :year AND class = :batch")
    fun getAssignments(year: Int, batch: String): ArrayList<Assignments>

    @Query("SELECT *FROM announcements")
    fun getAnnouncements(): ArrayList<AnnouncementObj>

    @Query("SELECT COUNT(*) FROM attendance WHERE studentId = :studentId AND courseId = :courseId AND present = 1")
    fun getAttendance(studentId: String, courseId: String): Int

    @Query("SELECT COUNT(*) FROM attendance WHERE studentId = :studentId AND courseId = :courseId ")
    fun getTotalAttenadance(studentId: String, courseId: String): Int

    @Query("SELECT * FROM events WHERE date>:time")
    fun getEvents(
        time: Long = System.currentTimeMillis()
    ): ArrayList<EventObj>

    @Query("SELECT * FROM student")
    fun getStudents(): ArrayList<Student>

    @Query("SELECT * FROM student WHERE year = :year")
    fun getStudents(year: Int): ArrayList<Student>

    @Query("SELECT * FROM student WHERE year  = :year AND batch LIKE '%:batch%'")
    fun getStudents(year: Int, batch: String): ArrayList<Student>

    @Query("SELECT * FROM student WHERE branch LIKE '%:branch'")
    fun getStudents(branch: String): ArrayList<Student>

    @Query("SELECT * FROM student WHERE branch = '%:branch' AND year = :year")
    fun getStudents(branch: String, year: Int): ArrayList<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id: String): Student

    @Query("SELECT * FROM courses WHERE year = :year AND branch = :branch")
    fun getCourses(year: Int, branch: String): ArrayList<Courses>

    @Query("SELECT DISTINCT(courseId) FROM courses WHERE year = :year")
    fun getCourses(year: Int): ArrayList<String>

    @Query("SELECT * FROM courses WHERE year = :year AND batch = :batch AND branch = :branch")
    fun getCourses(year: Int, batch: String, branch: String): ArrayList<Courses>

    @Query("SELECT * FROM courses WHERE courseId = :courseId")
    fun getCourses(courseId: String): ArrayList<Courses>

    @Query("SELECT * FROM courses WHERE courseId IN (:courseIds)")
    fun getCourses(courseIds: ArrayList<String>): ArrayList<Courses>

    @Query("SELECT * FROM books")
    fun getBooks(): ArrayList<Books>

    @Query("SELECT * FROM books WHERE publications = :publication")
    fun getBooks(publication: String): ArrayList<Books>

    @Query("SELECT * FROM books WHERE name = :name")
    fun getBook(name: String): Books

    @Query("SELECT * FROM book_issue")
    fun getIssuedBooks(): ArrayList<BooksIsued>

    @Query("SELECT * FROM book_issue WHERE studentId = :studentId")
    fun getIssuedBooks(studentId: String): ArrayList<BooksIsued>

    @Query("SELECT * FROM teacher")
    fun getTeachers(): ArrayList<Professor>
}