package manage;

import file.FileAccountCSV;
import interfaces.InterfaceAccount;
import interfaces.InterfaceGenara;
import model.Account;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AccountManage implements InterfaceGenara<Account>, InterfaceAccount<Account> {
    List<Account> accountList = new ArrayList<>();
    public static Account currentAccount = null;

//    public AccountManage() throws FileNotFoundException {
//        accountList = FileAccountCSV.readFormFile();
//    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public void add(Account account) {
        accountList.add(account);

    }

    @Override
    public void edit(String name, Account account) {
        accountList.set(findByName(name), account);

    }

    @Override
    public void delete(String name) {
        accountList.remove(findByName(name));
    }

    @Override
    public int findByName(String name) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getNameAccount().equalsIgnoreCase(name)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public void printAll() {
        for (Account a : accountList) {
            System.out.println(a);
        }

    }

    @Override
    public int login(String nameAccount, String password) {
        for (Account a : accountList) {
            if (a.getNameAccount().equals(nameAccount) && a.getPassword().equals(password)) {
                currentAccount = a;
                return 1;

            }
        }
        return 0;

    }

    @Override
    public void checkAcount(String nameAccount) {


    }

    @Override
    public void findByNameAccount(String accountName) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getNameAccount().equals(accountName)) {
                System.out.println(accountList.get(i));
            }
        }
    }
}
