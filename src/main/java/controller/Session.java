package controller;

import model.User;

/** Pengguna yang sedang login. Diisi oleh controller.AuthController saat login, dikosongkan saat keluar. */
public final class Session {
    private static User user;

    private Session() {
    }

    public static User user() {
        return user;
    }

    public static void masuk(User u) {
        user = u;
    }

    public static void keluar() {
        user = null;
    }

    public static boolean adaLogin() {
        return user != null;
    }
}
