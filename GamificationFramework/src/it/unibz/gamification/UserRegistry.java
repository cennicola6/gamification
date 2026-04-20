package it.unibz.gamification;

public class UserRegistry {
    private static ThreadLocal<User> tl = new ThreadLocal<User>();

    public static void setCurrentUser(User user) {
        tl.set(user);
    }

    public static User getCurrentUser() {
        return tl.get();
    }

}
