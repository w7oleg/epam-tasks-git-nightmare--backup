package javaStageTwo.errorsAndExceptions.universityExceptions;

public class StudentWithoutAcademicSubjectsException extends Exception {
    public StudentWithoutAcademicSubjectsException() {
    }

    public StudentWithoutAcademicSubjectsException(String message) {
        super(message);
    }

    public StudentWithoutAcademicSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentWithoutAcademicSubjectsException(Throwable cause) {
        super(cause);
    }
}
