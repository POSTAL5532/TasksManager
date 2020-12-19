package com.tasksmanager.service.utils;

/**
 * Check arguments utils.
 *
 * @author SIE
 */
public class ArgumentUtils {

    /**
     * Check expression is true.
     *
     * @param expression expression for checking
     * @param message    exception message
     * @throws IllegalArgumentException exception
     */
    public static void checkTrue(boolean expression, String message) throws IllegalArgumentException {
        if (!expression) {
            throw fail(message);
        }
    }

    /**
     * Check expression is false.
     *
     * @param expression expression for checking
     * @param message    exception message
     * @throws IllegalArgumentException exception
     */
    public static void checkFalse(boolean expression, String message) throws IllegalArgumentException {
        if (expression) {
            throw fail(message);
        }
    }

    /**
     * Check object is not null.
     *
     * @param argument object for checking
     * @param message  exception message
     * @throws IllegalArgumentException exception
     */
    public static void checkNotNull(Object argument, String message) throws IllegalArgumentException {
        checkTrue(argument != null, message);
    }

    /**
     * Check object is null.
     *
     * @param argument object for checking
     * @param message  exception message
     * @throws IllegalArgumentException exception
     */
    public static void checkNull(Object argument, String message) throws IllegalArgumentException {
        checkTrue(argument == null, message);
    }

    /**
     * Create new {@link IllegalArgumentException} exception and return it.
     *
     * @param message exception message
     * @return new exception
     */
    public static IllegalArgumentException fail(String message) {
        return new IllegalArgumentException(message);
    }
}
