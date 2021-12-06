package javaStageTwo.errorsAndExceptions.universityObjects;

import javaStageTwo.errorsAndExceptions.universityExceptions.GradeOutOfRangeException;
import javaStageTwo.errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.EnumSet;
import java.util.Objects;

public class Student {
    private static long studentsCount = 0;

    private String name;
    private String surname;
    private long studentIDNumber;
    private EnumSet<StudentSubject> studentSubjects;
    private Grades grades;

    public Student(String name, String surname, EnumSet<StudentSubject> studentSubjects) {
        this.name = name;
        this.surname = surname;
        this.studentSubjects = studentSubjects;
        grades = new Grades(this.studentSubjects);
        studentIDNumber = studentsCount;
        studentsCount++;
    }

    public long getStudentIDNumber() {
        return studentIDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public EnumSet<StudentSubject> getAcademicSubjects()
            throws StudentWithoutAcademicSubjectsException {
        if (studentSubjects.isEmpty()) {
            throw new StudentWithoutAcademicSubjectsException("У студента " +
                    getName() + " " + getSurname() + " с Фамилией "
                    + getStudentIDNumber() + " отсутствуют академические предметы!");
        }
        return studentSubjects;
    }

    public boolean isStudySubject(StudentSubject studentSubject) {
        return studentSubjects.contains(studentSubject);
    }

    public void setAcademicSubject(StudentSubject subject) {
        studentSubjects.add(subject);
        grades.addSubject(subject);
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrade(StudentSubject subject, int grade)
            throws GradeOutOfRangeException, StudentWithoutAcademicSubjectsException {
        if (!getAcademicSubjects().contains(subject)) {
            setAcademicSubject(subject);
        }
        grades.setGrade(subject, grade);
    }

    @Override
    public String toString() {
        return "Student " + studentIDNumber + ' ' + name + ' ' +
                surname + ' ' + grades + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentIDNumber == student.studentIDNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentIDNumber);
    }
}
