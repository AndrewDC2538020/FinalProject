package util;

public class Util {

    /**
     * converts each word in a string to title case.
     * @param str the String input
     * @return the String to title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty())
            return str;

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String i : words) {
            if (i.length() > 0) {
                result.append(Character.toUpperCase(i.charAt(0)))
                        .append(i.substring(1).toLowerCase());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}

