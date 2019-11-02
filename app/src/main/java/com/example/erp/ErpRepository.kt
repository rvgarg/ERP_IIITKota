package com.example.erp

import android.app.Application
import com.example.erp.objects.*

class ErpRepository(application: Application) {
    private var erpDao: ErpDao

    init {
        val db = ErpDatabase.getDatabase(application)
        erpDao = db!!.erpDao()
    }

    fun announcementInsert(announcementObj: AnnouncementObj) =
        erpDao.announcementInsert(announcementObj = announcementObj)

    fun assignmentInsert(assignments: Assignments) = erpDao.assignmentInsert(assignments)

    fun attendanceInsert(attendance: Attendance) = erpDao.attendanceInsert(attendance)

    fun booksInsert(books: Books) = erpDao.booksInsert(books)

    fun booksIssuedInsert(booksIsued: BooksIsued) = erpDao.booksIssuedInsert(booksIsued)

    fun coursesInsert(courses: Courses) = erpDao.coursesInsert(courses)

    fun eventInsert(eventObj: EventObj) = erpDao.eventInsert(eventObj)

    fun studentInsert(student: Student) = erpDao.studentInsert(student)

    fun teacherInsert(teacherObj: TeacherObj) = erpDao.teacherInsert(teacherObj)

    fun loginStudent(loginId: String, password: String) =
        erpDao.loginStudent(loginId, password)

    fun loginTeacher(loginId: String, password: String) =
        erpDao.loginTeacher(loginId, password)

    fun getAssignments(year: Int, batch: String) =
        erpDao.getAssignments(year, batch)

    fun getAnnouncements() = erpDao.getAnnouncements()

    fun getAttendance(studentId: String, courseId: String) =
        Pair(
            erpDao.getAttendance(studentId, courseId),
            erpDao.getTotalAttenadance(studentId, courseId)
        )


    fun getEvents() = erpDao.getEvents()

    fun getStudents() = erpDao.getStudents()

    fun getStudents(year: Int) = erpDao.getStudents(year)

    fun getStudents(year: Int, batch: String) = erpDao.getStudents(year, batch)

    fun getStudents(branch: String) = erpDao.getStudents(branch)

    fun getStudents(branch: String, year: Int) = erpDao.getStudents(branch, year)

    fun getStudent(id: String) = erpDao.getStudent(id)

    fun getCourses(year: Int, branch: String) = erpDao.getCourses(year, branch)

    fun getCourses(year: Int) = erpDao.getCourses(year)

    fun getCourses(year: Int, batch: String, branch: String) =
        erpDao.getCourses(year, batch, branch)

    fun getCourses(courseId: String) = erpDao.getCourses(courseId)

    fun getCourses(courseIds: List<String>) = erpDao.getCourses(courseIds)

    fun getBooks() = erpDao.getBooks()

    fun getBooks(publication: String) = erpDao.getBooks(publication)

    fun getBook(name: String) = erpDao.getBook(name)

    fun getIssuedBooks() = erpDao.getIssuedBooks()

    fun getIssuedBooks(studentId: String) = erpDao.getIssuedBooks(studentId)
}