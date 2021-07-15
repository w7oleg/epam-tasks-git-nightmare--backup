package javaStageTwo.ioFundamentals.optionalTask.javaProgram;

import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaProgramModifier {
    public static final String OLD_MODIFIER = "public";
    public static final String NEW_MODIFIER = "private";

    public static String changeAccessModifierInJavaProgramText(String javaProgramText) {
        EnumSet<ClassMemberPattern> classMemberPatterns = EnumSet.allOf(ClassMemberPattern.class);

        for (ClassMemberPattern classMemberPattern : classMemberPatterns) {
            Pattern pattern = Pattern.compile(classMemberPattern.getValue());
            Matcher matcher = pattern.matcher(javaProgramText);
            javaProgramText = matcher.replaceAll(declaration -> declaration.group().replaceFirst(OLD_MODIFIER, NEW_MODIFIER));
        }

        return javaProgramText;
    }

    public static String turnOverLines(String javaProgramText) {
        StringBuilder changedJavaProgramText = new StringBuilder();

        for (String line : javaProgramText.lines().collect(Collectors.toList())) {
            changedJavaProgramText.append(new StringBuilder(line).reverse());
            changedJavaProgramText.append('\n');
        }
        return changedJavaProgramText.toString();
    }

}
