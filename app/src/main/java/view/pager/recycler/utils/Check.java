package view.pager.recycler.utils;

/**
 * Created by harneev on 20/09/16.
 */

public class Check {

    public static boolean isEmpty(String string) {
        try {

            if (string == null || string.trim().length() == 0 || string.length() == 0 || string.isEmpty()
                    || string.equalsIgnoreCase("null")) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static boolean isEmpty(Integer value) {
        try {

            if (value == null || value == -1 || value == 0) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
