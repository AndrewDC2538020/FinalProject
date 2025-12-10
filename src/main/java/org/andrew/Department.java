package org.andrew;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

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

