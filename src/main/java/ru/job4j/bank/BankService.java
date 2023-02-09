package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
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
        User user = findByPassport(passport);
        if (getAccounts(user).size() > 0) {
            for (Account account1 : getAccounts(user)) {
                if (!account1.equals(account)) {
                    getAccounts(user).add(account);
                    break;
                }
            }
        } else if (getAccounts(user).size() == 0) {
            getAccounts(user).add(account);
        }
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
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account1 : getAccounts(user)) {
                if (account1.getRequisite().equals(requisite)) {
                    return account1;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (amount <= srcAccount.getBalance()) {
                destAccount.setBalance(amount + destAccount.getBalance());
                rsl = true;
            }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}