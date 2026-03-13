package com.frontendpom.util;

public class CategoryUtils {

    public static String toTitleCase(String category) {
        if (category == null || category.isEmpty()) {
            return category;
        }
        return category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
    }
}
