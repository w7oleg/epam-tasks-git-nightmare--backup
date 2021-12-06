package javaStageTwo.errorsAndExceptions.data;

import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Faculty;
import javaStageTwo.errorsAndExceptions.universityObjects.Group;
import javaStageTwo.errorsAndExceptions.universityObjects.Student;
import javaStageTwo.errorsAndExceptions.universityExceptions.*;

import java.util.EnumSet;

public class CodeInitializer extends Initializer {

    @Override
    protected void setFaculties() {
        university.setFaculty(new Faculty("Biological"));
        university.setFaculty(new Faculty("Linguistic"));
        university.setFaculty(new Faculty("Mathematical"));
    }

    @Override
    protected void setGroups() throws UniversityWithoutFacultiesException {
        university.getFaculties().get(0).setGroup("ES1");
        university.getFaculties().get(1).setGroup("TG4");
        university.getFaculties().get(1).setGroup("ET2");
        university.getFaculties().get(2).setGroup("M21");
        university.getFaculties().get(2).setGroup("PO23");
    }

    @Override
    protected void setStudents() throws UniversityWithoutFacultiesException, FacultyWithoutGroupsException {
        university.getFaculties().get(0).getGroup("ES1").setStudent(new Student("Vadim", "Gmail",
                EnumSet.of(StudentSubject.PHYSICS, StudentSubject.
                        HISTORY, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(0).getGroup("ES1").setStudent(new Student("Victor", "Tolloch",
                EnumSet.of(StudentSubject.PHYSICS, StudentSubject.
                        HISTORY, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(0).getGroup("ES1").setStudent(new Student("Oleg", "Vostr",
                EnumSet.of(StudentSubject.PHYSICS, StudentSubject.
                        HISTORY, StudentSubject.PHILOSOPHY)));

        university.getFaculties().get(1).getGroup("TG4").setStudent(new Student("Dmitry", "Smyago",
                EnumSet.of(StudentSubject.TOE, StudentSubject.ENGLISH, StudentSubject.GERMAN, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(1).getGroup("TG4").setStudent(new Student("Petr", "Rjabushko",
                EnumSet.of(StudentSubject.TOE, StudentSubject.ENGLISH, StudentSubject.GERMAN, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(1).getGroup("TG4").setStudent(new Student("Pavel", "Egorov",
                EnumSet.of(StudentSubject.TOE, StudentSubject.ENGLISH, StudentSubject.GERMAN, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(1).getGroup("ET2").setStudent(new Student("Oleg", "Olegov",
                EnumSet.of(StudentSubject.TOE, StudentSubject.ENGLISH, StudentSubject.GERMAN, StudentSubject.PHONETICS)));
        university.getFaculties().get(1).getGroup("ET2").setStudent(new Student("Petr", "Olegov",
                EnumSet.of(StudentSubject.TOE, StudentSubject.ENGLISH, StudentSubject.GERMAN, StudentSubject.PHONETICS)));

        university.getFaculties().get(2).getGroup("M21").setStudent(new Student("Maksim", "Savin",
                EnumSet.of(StudentSubject.GEOMETRY, StudentSubject.ENGLISH, StudentSubject.TRIGONOMETRY, StudentSubject.ALGEBRA, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(2).getGroup("M21").setStudent(new Student("Mark", "Timofeev",
                EnumSet.of(StudentSubject.GEOMETRY, StudentSubject.ENGLISH, StudentSubject.TRIGONOMETRY, StudentSubject.ALGEBRA, StudentSubject.PHILOSOPHY)));
        university.getFaculties().get(2).getGroup("PO23").setStudent(new Student("Jan", "Best",
                EnumSet.of(StudentSubject.GEOMETRY, StudentSubject.TRIGONOMETRY, StudentSubject.ALGEBRA, StudentSubject.PHILOSOPHY)));
    }

    @Override
    protected void setGrades() throws GradeOutOfRangeException, StudentWithoutAcademicSubjectsException,
            GroupWithoutStudentsException, FacultyWithoutGroupsException, UniversityWithoutFacultiesException {
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (StudentSubject studentSubject : student.getAcademicSubjects()) {
                        int gradesCount = (int) (Math.random() * 4);
                        for (int i = 0; i < gradesCount; i++) {
                            student.setGrade(studentSubject, (int) ((Math.random() * 10) + 1));
                        }
                    }
                }
            }
        }
    }
}
