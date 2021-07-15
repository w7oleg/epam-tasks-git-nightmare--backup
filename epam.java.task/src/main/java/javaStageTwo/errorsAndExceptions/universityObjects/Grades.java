package javaStageTwo.errorsAndExceptions.universityObjects;

import javaStageTwo.errorsAndExceptions.universityExceptions.GradeOutOfRangeException;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public class Grades {
    private EnumMap<StudentSubject, List<Integer>> subjectGrades = new EnumMap<>(StudentSubject.class);

    public Grades(EnumSet<StudentSubject> studentSubjects) {
        for (StudentSubject studentSubject : studentSubjects) {
            subjectGrades.put(studentSubject, new ArrayList<>());
        }
    }

    public EnumMap<StudentSubject, List<Integer>> getSubjectGrades() {
        return subjectGrades;
    }

    public void addSubject(StudentSubject studentSubject) {
        if (!subjectGrades.containsKey(studentSubject)) {
            subjectGrades.put(studentSubject, new ArrayList<>());
        }
    }

    public void setGrade(StudentSubject studentSubject, int grade)
            throws GradeOutOfRangeException {
        if ((grade >= 0) && (grade <= 10)) {
            List<Integer> grades = subjectGrades.get(studentSubject);
            grades.add(grade);
            subjectGrades.put(studentSubject, grades);
        } else {
            throw new GradeOutOfRangeException("Оценка " + grade + " является недопустимой!");
        }
    }

    @Override
    public String toString() {
        return subjectGrades.toString();
    }

}
