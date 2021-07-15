package javaStageTwo.errorsAndExceptions.actions;

import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static Double calculateAverageGrade(List<Student> students, StudentSubject subject) {
        List<Integer> subjectGrades = students.stream().filter(student -> student.isStudySubject(subject)).
                map(student -> StudentAction.getGradesBySubject(student, subject)).
                flatMap(Collection::stream).collect(Collectors.toList());

        Integer sumOfGrades = subjectGrades.stream().reduce(Integer::sum).orElse(0);
        return !subjectGrades.isEmpty() ? (sumOfGrades / (double) subjectGrades.size()) : sumOfGrades;
    }
}
