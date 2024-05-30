package org.example.hexlet;

public class NamedRoutes {

    // Маршрут пользователей
    public static String usersPath() {
        return "/users";
    }
    // Маршрут для заведения нового пользователя
    public static String buildUserPath() {
        return "/users/build";
    }
    public static String usersPath(Long id) {
        return usersPath(String.valueOf(id));
    }

    public static String usersPath(String id) {
        return "/users/" + id;
    }
    public static String usersSecPath(String id) {
        return "/users_security/" + id;
    }



    // Маршрут для курсов
    public static String coursesPath() {
        return "/courses";
    }
    // Маршрут для заведения нового курса
    public static String buildCoursesPath() {
        return "/courses/build";
    }
    // Маршрут для конкретного курса
    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }
}

