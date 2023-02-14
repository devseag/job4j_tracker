package ru.job4j.bank;

import java.util.Objects;

/**
 * Klass predstavljaet soboj model' pol'zovatelja bankovskogo servisa
 *
 * @author DEVSEAG
 * @version 1.0
 */
public class User {
    /**
     * Klass soderzhit private polja: pasport, imja
     */
    private String passport;
    private String username;

    /**
     * Konstruktor klassa
     * @param passport pasport
     * @param username imja
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Metod dlja poluchenija stroki pasporta pol'zovatelja
     * @return pasport pol'zovatelja
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Metod dlja ustanovki znachenija stroke pasport
     * @param passport novoe znachenie
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Metod dlja poluchenija stroki imeni pol'zovatelja
     * @return imja pol'zovatelja
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metod dlja ustanovki znachenija stroke imja
     * @param username novoe znachenie
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}