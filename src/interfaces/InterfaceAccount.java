package interfaces;

public interface InterfaceAccount<T> {
    int login(String nameAccount, String password);

    void checkAcount(String nameAccount);

    void findByNameAccount(String accountName);

}
