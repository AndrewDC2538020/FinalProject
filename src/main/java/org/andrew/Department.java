package org.andrew;

public class Department {
    private String departmentId;
    private String departmentName;
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

}
