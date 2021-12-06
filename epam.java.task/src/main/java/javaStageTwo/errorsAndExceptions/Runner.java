package javaStageTwo.errorsAndExceptions;

import javaStageTwo.errorsAndExceptions.actions.StudentAction;
import javaStageTwo.errorsAndExceptions.actions.UniversityAction;
import javaStageTwo.errorsAndExceptions.data.CodeInitializer;
import javaStageTwo.errorsAndExceptions.data.Initializer;
import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Faculty;
import javaStageTwo.errorsAndExceptions.universityObjects.Student;
import javaStageTwo.errorsAndExceptions.universityObjects.University;
import javaStageTwo.errorsAndExceptions.universityExceptions.*;

import java.util.EnumSet;
import java.util.Scanner;

public class Runner {
    private final static StudentSubject ACADEMIC_SUBJECT_FOR_TEST = StudentSubject.PHILOSOPHY;
    private final static int STUDENT_NUMBER_FOR_TEST = 6;

    private static void getAverageGradesOfStudent(University university) throws StudentWithoutAcademicSubjectsException, FacultyWithoutGroupsException,
            UniversityWithoutFacultiesException, GroupWithoutStudentsException {
        Student student = UniversityAction.getStudentsOfUniversity(university).get(STUDENT_NUMBER_FOR_TEST+1);
        System.out.println("Средние оценки студента " + student.getName() + " " + student.getSurname() + "(ID " + student.getStudentIDNumber() + ")");
        System.out.println(StudentAction.getAverageGrades(student));
    }

    private static void getAverageGradesOfFaculties(University university) throws UniversityWithoutFacultiesException,
            FacultyWithoutGroupsException, GroupWithoutStudentsException, NoFacultyWithNameException {
        System.out.println("Средние оценки факультетов по предмету " + ACADEMIC_SUBJECT_FOR_TEST);
        System.out.println("Biological=" +
                UniversityAction.getAverageGradeOfFaculty(university, "Biological", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("Linguistic=" +
                UniversityAction.getAverageGradeOfFaculty(university, "Linguistic", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("Mathematical=" +
                UniversityAction.getAverageGradeOfFaculty(university, "Mathematical", ACADEMIC_SUBJECT_FOR_TEST));
    }

    private static void getAverageGradesOfGroups(University university) throws UniversityWithoutFacultiesException,
            FacultyWithoutGroupsException, GroupWithoutStudentsException {
        System.out.println("Средние оценки групп по предмету " + ACADEMIC_SUBJECT_FOR_TEST);
        System.out.println("ES1=" +
                UniversityAction.getAverageGradeOfGroup(university, "ES1", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("TG4=" +
                UniversityAction.getAverageGradeOfGroup(university, "TG4", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("ET2=" +
                UniversityAction.getAverageGradeOfGroup(university, "ET2", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("M21=" +
                UniversityAction.getAverageGradeOfGroup(university, "M21", ACADEMIC_SUBJECT_FOR_TEST));
        System.out.println("PO23=" +
                UniversityAction.getAverageGradeOfGroup(university, "PO23", ACADEMIC_SUBJECT_FOR_TEST));
    }

    private static void getAverageGradeOfUniversity(University university) throws UniversityWithoutFacultiesException,
            FacultyWithoutGroupsException, GroupWithoutStudentsException {
        System.out.println("Средняя оценка университета по предмету " + ACADEMIC_SUBJECT_FOR_TEST);
        System.out.println(UniversityAction.getAverageGradeOfUniversity(university, ACADEMIC_SUBJECT_FOR_TEST));
    }

    private static void getExceptions(University university) throws FacultyWithoutGroupsException, UniversityWithoutFacultiesException,
            GroupWithoutStudentsException, GradeOutOfRangeException, StudentWithoutAcademicSubjectsException, NoFacultyWithNameException {
        System.out.println("Введите номер сценария с исключением, который необходимо исполнить (1-5)");
        Scanner scanner = new Scanner(System.in);
        int programNumber = scanner.nextInt();
        switch (programNumber) {
            case 1:
                int incorrectGrade = 19;
                System.out.println("Попытка выставить оценку ниже 0 или выше 10");
                Student studentWithGradeOutOfRange = UniversityAction.getStudentsOfUniversity(university).get(STUDENT_NUMBER_FOR_TEST);
                studentWithGradeOutOfRange.setGrade(StudentSubject.PHILOSOPHY, incorrectGrade);
                System.out.println(studentWithGradeOutOfRange);
                break;
            case 2:
                System.out.println("Отсутсвие предметов у студента (должен быть хотя бы один)");
                Student studentWithoutSubjects = new Student("Lev", "Lvov", EnumSet.noneOf(StudentSubject.class));
                university.getFaculties().get(1).getGroup("TG4").setStudent(studentWithoutSubjects);
                System.out.println(StudentAction.getAverageGrades(studentWithoutSubjects));
                break;
            case 3:
                System.out.println("Отсутствие студентов в группе");
                String groupWithoutStudents = "B002";
                university.getFaculties().get(0).setGroup(groupWithoutStudents);
                System.out.println(UniversityAction.getAverageGradeOfGroup(university, groupWithoutStudents, StudentSubject.ENGLISH));
                break;
            case 4:
                System.out.println("Отсутствие групп на факультете");
                String facultyWithoutGroups = "Military";
                university.setFaculty(new Faculty(facultyWithoutGroups));
                System.out.println(UniversityAction.getAverageGradeOfFaculty(university, facultyWithoutGroups, StudentSubject.ENGLISH));
                break;
            case 5:
                System.out.println("Отсутствие факультетов в университете");
                University universityWithoutFaculties = new University();
                System.out.println(UniversityAction.getStudentsOfUniversity(universityWithoutFaculties));
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }

    public static void main(String[] args) {
        Initializer initializer = new CodeInitializer();
        try {
            University university = initializer.initializeUniversity();

            System.out.println("Список университета:");
            System.out.println(university);

            getAverageGradesOfStudent(university);
            getAverageGradesOfFaculties(university);
            getAverageGradesOfGroups(university);
            getAverageGradeOfUniversity(university);

            getExceptions(university);
        } catch (GradeOutOfRangeException | StudentWithoutAcademicSubjectsException | GroupWithoutStudentsException |
                UniversityWithoutFacultiesException | FacultyWithoutGroupsException | NoFacultyWithNameException e) {
            e.printStackTrace();
        }
    }
}
