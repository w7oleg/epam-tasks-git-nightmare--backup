package javaStageTwo.errorsAndExceptions.universityExceptions;

public class NoFacultyWithNameException extends Exception {
    public NoFacultyWithNameException() {
    }

    public NoFacultyWithNameException(String message) {
        super(message);
    }

    public NoFacultyWithNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFacultyWithNameException(Throwable cause) {
        super(cause);
    }
}
