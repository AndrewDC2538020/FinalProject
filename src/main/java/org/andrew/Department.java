package org.andrew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    /**
     * Checks if a department name is valid or not, a department name should only contain letters or space.
     * @param departmentName the department name input
     * @return if department name is valid (true) an if department name is not valid (false)
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty())
            return false;

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ')
                return false;
        }
        return true;
    }

    /**
     * creates the object with everything as null if the department name is invalid
     * @param departmentName the department name input
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;

            this.departmentId = "D" + String.format("%02d", nextId);
            nextId++;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
