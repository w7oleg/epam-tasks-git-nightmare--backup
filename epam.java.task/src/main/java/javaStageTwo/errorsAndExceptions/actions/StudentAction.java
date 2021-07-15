package javaStageTwo.errorsAndExceptions.actions;

import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Student;
import javaStageTwo.errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class StudentAction extends Calculator {
    public static List<Integer> getGradesBySubject(Student student, StudentSubject studentSubject) {
        return student.getGrades().getSubjectGrades().get(studentSubject);
    }

    public static double getAverageGradeBySubject(Student student, StudentSubject subject) {
        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(student);
        return calculateAverageGrade(studentList, subject);
    }

    public static EnumMap<StudentSubject, Double> getAverageGrades(Student student) throws StudentWithoutAcademicSubjectsException {
        EnumMap<StudentSubject, Double> averageGrades = new EnumMap<>(StudentSubject.class);

        for (StudentSubject subject : student.getAcademicSubjects()) {
            averageGrades.put(subject, getAverageGradeBySubject(student, subject));
        }
        return averageGrades;
    }
}
