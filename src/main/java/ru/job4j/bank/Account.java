package ru.job4j.bank;

import java.util.Objects;

/**
 * Klass predstavljaet model' bankovskogo scheta pol'zovatelja
 *
 * @author DEVSEAG
 * @version 1.0
 */
public class Account {
    /**
     * Klass soderzhit private polja: rekvizit, balans scheta
     */
    private String requisite;
    private double balance;

    /**
     * Konstruktor klassa
     * @param requisite rekvizit akkaunta
     * @param balance   balans scheta
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Metod dlja poluchenija stroki rekvizita
     * @return rekvizit pol'zovatelja
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Metod dlja ustanovki znachenija stroke rekvizit
     * @param requisite novoe znachenie
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Metod dlja poluchenija chisla balansa
     * @return balans pol'zovatelja
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Metod dlja ustanovki znachenija balansa
     * @param balance novoe znachenie
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}