/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * This class contains a series of utility methods for handling command line arguments.
 *
 * @author Jithendra Chikkanna
 */
public class CommandLineUtils {

    /**
     * This method convert a command line argument array into an associative map.
     *
     * @param args The argument array to convert.
     * @return An associative map that holds the arguments on the command line.
     */
    public static Map<String, String> argsArrayToMap(final String[] args) {
        // Convert the command line arguments into a map.
        Map<String, String> argMap = new HashMap<String, String>();
        if (args != null) {
            Arrays.asList(args).forEach((arg) -> {
                String token[] = arg.split("=");
                if (token.length >= 2) {
                    argMap.put(token[0], token[1]);
                }
            });
        }
        return argMap;
    }

    /**
     * This method checks validates that the expected args have been provided on the command line array.
     *
     * @param args The array of arguments from the command line.
     * @param expectedArgs The expected list of arguments.
     * @return TRUE if the expected arguments have been provided false otherwise.
     */
    public static boolean validateCommandLineArguments(final String[] args, final String[] expectedArgs) {
        boolean isValid = true;
        if (expectedArgs != null && expectedArgs.length > 0) {
            if (args != null && expectedArgs.length == args.length) {
                // Convert the Argument array into a map.
                Map<String, String> argsMap = argsArrayToMap(args);
                // Check the invalid elements
                Stream<String> stream = Arrays.asList(expectedArgs).stream();
                stream = stream.filter((p) -> (argsMap.get(p) == null || argsMap.get(p).isEmpty()));
                long count = stream.count();
                isValid = count == 0L;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    /**
     * This method is used to create the usage line that gets displayed when the application fails to run due to some
     * issues on the input parameters.
     *
     * @param jar The name of the executable Java file.
     * @param expectedArgs The list of parameters.
     * @return A usage string describing how the application should be launched.
     */
    public static String buildUsageLine(final String jar, final String[] expectedArgs) {
        StringBuilder stringBuilder = new StringBuilder();
        if (jar != null && !jar.isEmpty()) {
            stringBuilder.append("Usage: java -jar ");
            stringBuilder.append(jar);
            stringBuilder.append(" ");
            // Add the param list.
            if (expectedArgs != null) {
                Arrays.asList(expectedArgs).forEach(p -> stringBuilder.append(p + "=? "));
            }
        }
        return stringBuilder.toString();
    }

}
