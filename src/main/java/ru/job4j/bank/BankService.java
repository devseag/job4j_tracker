package ru.job4j.bank;

import java.util.*;

/**
 * Klass predstavljaet soboj jelementarnuju model' bankovskoj sistemy
 *
 * @author DEVSEAG
 * @version 1.0
 */
public class BankService {
    /**
     * Klass soderzhit private final pole: HashMap karta iz pol'zovatelej i akkauntov
     * U kazhdogo pol'zovatelja mozhet byt' neskol'ko akkauntov v sisteme
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Metod dobavlenija novogo klienta v bazu users
     * Dobavlenie proishodit esli dannogo pol'zovatelja net v sisteme
     *
     * @param user pol'zovatel' tipa User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Metod udaljaet pol'zovatelja iz bazy users
     *
     * @param passport pol'zovatel' kotorogo udaljat
     */
    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    /**
     * Metod dobavljaet pol'zovatelju akkaunt
     * Esli pol'zovatel' ne najden ili pol'zovatel'
     * uzhe imeet dannyj akkunt, to dobavlenija ne proishodit
     *
     * @param passport ispol'zuetsja dlja poiska pol'zovatelja iz bazy users
     * @param account  novyj schet tipa Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!getAccounts(user).contains(account)) {
                getAccounts(user).add(account);
            }
        }
    }

    /**
     * Metod nahodit vozvrashhaet pol'zovatelja po pasportu
     * Esli pol'zovatel' ne najden to vozvrashhaetsja null
     *
     * @param passport pasport klienta
     * @return pol'zovatelja tipa User
     */
//    public User findByPassport(String passport) {
//        for (User user : users.keySet()) {
//            if (passport.equals(user.getPassport())) {
//                return user;
//            }
//        }
//        return null;
//    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

//    public User findByPassport(String passport) {
//        User rsl = null;
//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                rsl = user;
//                break;
//            }
//        }
//        return rsl;
//    }

//    public Optional<User> findByPassport(String passport) {
//        Optional<User> rsl = Optional.empty();
//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                rsl = Optional.of(user);
//                break;
//            }
//        }
//        return rsl;
//    }

    /**
     * Metod nahodit i vozvrashhaet schet klienta
     * Snachala nahodim pol'zovatelja po pasportu, esli klient est' v baze users
     * to sravnivaet rekvizity schetov klienta s argumentom rekvizita
     * Esli akkaunt s dannym rekvizitom ne najden, to vozvrashhaet null
     *
     * @param passport  pasport klienta
     * @param requisite rekvizit scheta
     * @return akkaunt tipa Account
     */
//    public Account findByRequisite(String passport, String requisite) {
//        User user = findByPassport(passport);
//        if (user != null) {
//            for (Account account1 : getAccounts(user)) {
//                if (requisite.equals(account1.getRequisite())) {
//                    return account1;
//                }
//            }
//        }
//        return null;
//    }
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> requisite.equals(a.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Metod proizvodit perevod deneg mezhdu akkauntami
     * Perevod prohodit uspeshno esli oba akkaunta sushhestvujut v baze users
     * i summa perevoda men'she balansa scheta otpravitelja
     *
     * @param srcPassport   pasport otpravitelja
     * @param srcRequisite  rekvizity otpravitelja
     * @param destPassport  pasport poluchatelja
     * @param destRequisite rekvizity poluchatelja
     * @param amount        summa perevoda
     * @return true esli perevod vypolnen
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && amount <= srcAccount.getBalance()) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(amount + destAccount.getBalance());
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}