package javaStageTwo.errorsAndExceptions.universityObjects;

public enum StudentSubject {
    GEOMETRY, TRIGONOMETRY, ALGEBRA, ENGLISH, GERMAN, TOE,
    PHONETICS, HISTORY,
    PHYSICS, PHILOSOPHY;

    @Override
    public String toString() {
        return this.name();
    }
}
