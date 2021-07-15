package javaStageTwo.errorsAndExceptions.data;

import javaStageTwo.errorsAndExceptions.universityObjects.University;
import javaStageTwo.errorsAndExceptions.universityExceptions.*;

public abstract class Initializer {
    protected University university;

    public Initializer() {
        university = new University();
    }

    protected abstract void setFaculties();

    protected abstract void setGroups() throws UniversityWithoutFacultiesException;

    protected abstract void setStudents() throws UniversityWithoutFacultiesException, FacultyWithoutGroupsException;

    protected abstract void setGrades() throws GradeOutOfRangeException, StudentWithoutAcademicSubjectsException, GroupWithoutStudentsException, FacultyWithoutGroupsException, UniversityWithoutFacultiesException;

    public University initializeUniversity() throws GradeOutOfRangeException, StudentWithoutAcademicSubjectsException,
            GroupWithoutStudentsException, FacultyWithoutGroupsException, UniversityWithoutFacultiesException {
        setFaculties();
        setGroups();
        setStudents();
        setGrades();
        return university;
    }
}
