package javaStageTwo.errorsAndExceptions.actions;

import javaStageTwo.errorsAndExceptions.universityObjects.StudentSubject;
import javaStageTwo.errorsAndExceptions.universityObjects.Group;
import javaStageTwo.errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;

public class GroupAction extends Calculator {
    public static Double getAverageGradeBySubject(Group group, StudentSubject subject)
            throws GroupWithoutStudentsException {
        return calculateAverageGrade(group.getStudents(), subject);
    }
}
