package ru.job4j.bank;

//import ru.job4j.bank.Account;
//import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
//        if (users.get(user) == null) {
//            users.put(user, new ArrayList<Account>());
//        }
        users.computeIfAbsent(user, k -> new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        List<Account> list = new ArrayList<>();
        User user = findByPassport(passport);
        for (Account account1 : getAccounts(user)) {
            if (!account1.equals(account)) {
                list.add(account);
                users.put(user, list);
            }
        }
//        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
//            if (entry.getKey().getPassport().equals(passport)) {
//                for (Account account1 : entry.getValue()) {
//                    if (!account1.equals(account)) {
//                        List<Account> list = new ArrayList<>();
//                        list.add(account);
//                        users.put(entry.getKey(), list);
//                    }
//                }
//            }
//        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = new ArrayList<>();
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account1 : getAccounts(user)) {
                if (account1.getRequisite().equals(requisite)) {
                    return account1;
                }
            }
        }
//        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
//            if (entry.getKey().equals(findByPassport(passport))) {
//                for (Account account1 : entry.getValue()) {
//                    if (account1.getRequisite().equals(requisite)) {
//                        return account1;
//                    }
//                }
//            }
//        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}