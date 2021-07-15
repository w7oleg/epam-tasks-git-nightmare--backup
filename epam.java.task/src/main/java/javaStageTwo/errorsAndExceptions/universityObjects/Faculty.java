package javaStageTwo.errorsAndExceptions.universityObjects;

import javaStageTwo.errorsAndExceptions.universityExceptions.FacultyWithoutGroupsException;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
    private String facultyName;
    private Set<Group> groups;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        groups = new TreeSet<>();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Set<Group> getGroups() throws FacultyWithoutGroupsException {
        if (groups.isEmpty()) {
            throw new FacultyWithoutGroupsException("На факультете "
                    + getFacultyName() + " отсутствуют группы!");
        }
        return groups;
    }

    public void setGroup(String groupName) {
        groups.add(new Group(groupName));
    }

    public Group getGroup(String groupName) throws FacultyWithoutGroupsException {
        Optional<Group> optionalGroup = getGroups().stream().
                filter(group -> group.getGroupName().equals(groupName)).findFirst();

        return optionalGroup.orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyName.equals(faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName);
    }

    @Override
    public String toString() {
        StringBuilder facultyInString = new StringBuilder("Faculty = " + facultyName + '\n');
        for (Group group : groups) {
            facultyInString.append(group.toString());
        }
        return facultyInString.toString();
    }
}
