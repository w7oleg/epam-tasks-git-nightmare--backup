package javaStageTwo.ioFundamentals.optionalTask.javaProgram;


public enum ClassMemberPattern {
    PUBLIC_ATTRIBUTE("(public)[^{]+(;)"), PUBLIC_METHOD("(public\\s)(static\\s)?(abstract\\s)?(final\\s)?(synchronized\\s)?([^({;=})]+\\s)([^({;=})]+\\s?)[(](.*)[)]");

    private final String value;

    ClassMemberPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
