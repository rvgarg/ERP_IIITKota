package com.example.erp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.erp.objects.*

class ErpViewModel(application: Application) : AndroidViewModel(application) {
    private val erpRepository = ErpRepository(application)
    fun announcementInsert(announcementObj: AnnouncementObj) =
        erpRepository.announcementInsert(announcementObj)

    fun assignmentInsert(assignments: Assignments) = erpRepository.assignmentInsert(assignments)

    fun attendanceInsert(attendance: Attendance) = erpRepository.attendanceInsert(attendance)

    fun booksInsert(books: Books) = erpRepository.booksInsert(books)

    fun booksIssuedInsert(booksIsued: BooksIsued) = erpRepository.booksIssuedInsert(booksIsued)

    fun coursesInsert(courses: Courses) = erpRepository.coursesInsert(courses)

    fun eventInsert(eventObj: EventObj) = erpRepository.eventInsert(eventObj)

    fun studentInsert(student: Student) = erpRepository.studentInsert(student)

    fun teacherInsert(teacherObj: TeacherObj) = erpRepository.teacherInsert(teacherObj)

    fun loginStudent(loginId: String, password: String) =
        erpRepository.loginStudent(loginId, password)

    fun loginTeacher(loginId: String, password: String) =
        erpRepository.loginTeacher(loginId, password)

    fun getAssignments(year: Int, batch: String) =
        erpRepository.getAssignments(year, batch)

    fun getAnnouncements() = erpRepository.getAnnouncements()

    fun getAttendance(studentId: String, courseId: String) =
        erpRepository.getAttendance(studentId, courseId)


    fun getEvents() = erpRepository.getEvents()

    fun getStudents() = erpRepository.getStudents()

    fun getStudents(year: Int) = erpRepository.getStudents(year)

    fun getStudents(year: Int, batch: String) = erpRepository.getStudents(year, batch)

    fun getStudents(branch: String) = erpRepository.getStudents(branch)

    fun getStudents(branch: String, year: Int) = erpRepository.getStudents(branch, year)

    fun getStudent(id: String) = erpRepository.getStudent(id)

    fun getCourses(year: Int, branch: String) = erpRepository.getCourses(year, branch)

    fun getCourses(year: Int) = erpRepository.getCourses(year)

    fun getCourses(year: Int, batch: String, branch: String) =
        erpRepository.getCourses(year, batch, branch)

    fun getCourses(courseId: String) = erpRepository.getCourses(courseId)

    fun getCourses(courseIds: List<String>) = erpRepository.getCourses(courseIds)

    fun getBooks() = erpRepository.getBooks()

    fun getBooks(publication: String) = erpRepository.getBooks(publication)

    fun getBook(name: String) = erpRepository.getBook(name)

    fun getIssuedBooks() = erpRepository.getIssuedBooks()

    fun getIssuedBooks(studentId: String) = erpRepository.getIssuedBooks(studentId)
}