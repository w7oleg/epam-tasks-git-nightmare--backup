package javaStageTwo.errorsAndExceptions.universityObjects;

import javaStageTwo.errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group implements Comparable<Group> {
    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() throws GroupWithoutStudentsException {
        if (students.isEmpty()) {
            throw new GroupWithoutStudentsException("В группе " + getGroupName() + " отсутствуют студенты");
        }
        return students;
    }

    public void setStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupName.equals(group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        StringBuilder groupInString = new StringBuilder("Group = " + groupName + '\n');
        for (Student student : students) {
            groupInString.append(student.toString());
        }
        return groupInString.toString();
    }

    @Override
    public int compareTo(Group o) {
        return groupName.compareTo(o.groupName);
    }
}
