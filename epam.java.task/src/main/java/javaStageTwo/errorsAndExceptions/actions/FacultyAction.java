package javaStageTwo.errorsAndExceptions.actions;

import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Faculty;
import javaStageTwo.errorsAndExceptions.universityObjects.Group;
import javaStageTwo.errorsAndExceptions.universityObjects.Student;
import javaStageTwo.errorsAndExceptions.universityExceptions.FacultyWithoutGroupsException;
import javaStageTwo.errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;

import java.util.ArrayList;
import java.util.List;

public class FacultyAction extends Calculator {

    public static boolean hasGroup(Faculty faculty, String groupName) throws FacultyWithoutGroupsException {
        return faculty.getGroups().stream().anyMatch(group -> group.getGroupName().equals(groupName));
    }

    public static List<Student> getStudentsOfFaculty(Faculty faculty) throws FacultyWithoutGroupsException, GroupWithoutStudentsException {
        ArrayList<Student> students = new ArrayList<>();
        for (Group group : faculty.getGroups()) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    public static Double getAverageGradeBySubject(Faculty faculty, StudentSubject subject) throws GroupWithoutStudentsException,
            FacultyWithoutGroupsException {
        return calculateAverageGrade(getStudentsOfFaculty(faculty), subject);
    }
}
