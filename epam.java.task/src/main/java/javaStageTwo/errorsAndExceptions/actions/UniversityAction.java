package javaStageTwo.errorsAndExceptions.actions;

import javaStageTwo.errorsAndExceptions.universityObjects.*;
import javaStageTwo.errorsAndExceptions.universityExceptions.FacultyWithoutGroupsException;
import javaStageTwo.errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;
import javaStageTwo.errorsAndExceptions.universityExceptions.NoFacultyWithNameException;
import javaStageTwo.errorsAndExceptions.universityExceptions.UniversityWithoutFacultiesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityAction extends Calculator {
    public static Double getAverageGradeOfFaculty(University university, String facultyName, StudentSubject subject)
            throws FacultyWithoutGroupsException, GroupWithoutStudentsException, UniversityWithoutFacultiesException, NoFacultyWithNameException {
        Faculty facultyByName;
        Optional<Faculty> optionalFaculty = university.getFaculties().stream().
                filter(faculty -> faculty.getFacultyName().equals(facultyName)).findFirst();
        if (optionalFaculty.isPresent()) {
            facultyByName = optionalFaculty.get();
        } else {
            throw new NoFacultyWithNameException("В университете отсутствует факультет с именем " + facultyName);
        }
        return FacultyAction.getAverageGradeBySubject(facultyByName, subject);
    }

    private static Group searchGroupByName(University university, String groupName) throws UniversityWithoutFacultiesException, FacultyWithoutGroupsException {
        for (Faculty faculty : university.getFaculties()) {
            if (FacultyAction.hasGroup(faculty, groupName)) {
                return faculty.getGroup(groupName);
            }
        }
        return null;
    }

    public static Double getAverageGradeOfGroup(University university, String groupName, StudentSubject subject)
            throws GroupWithoutStudentsException,
            UniversityWithoutFacultiesException, FacultyWithoutGroupsException {
        Group group;
        Double averageGrade = 0.0;

        if ((group = searchGroupByName(university, groupName)) != null) {
            averageGrade = GroupAction.getAverageGradeBySubject(group, subject);
        }
        return averageGrade;
    }

    public static List<Student> getStudentsOfUniversity(University university) throws FacultyWithoutGroupsException,
            GroupWithoutStudentsException, UniversityWithoutFacultiesException {
        ArrayList<Student> students = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            students.addAll(FacultyAction.getStudentsOfFaculty(faculty));
        }
        return students;
    }

    public static Double getAverageGradeOfUniversity(University university, StudentSubject subject)
            throws GroupWithoutStudentsException, FacultyWithoutGroupsException, UniversityWithoutFacultiesException {
        return calculateAverageGrade(getStudentsOfUniversity(university), subject);
    }
}
