package javaStageTwo.errorsAndExceptions.universityExceptions;

public class GradeOutOfRangeException extends Exception {
    public GradeOutOfRangeException() {
    }

    public GradeOutOfRangeException(String message) {
        super(message);
    }

    public GradeOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeOutOfRangeException(Throwable cause) {
        super(cause);
    }
}
