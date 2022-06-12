package model;

public class Account {
    private String nameAccount;
    private String password;
    private String numberPhone;
    private String email;
    private String fullname;
    private int age;
    private String role;

    public Account() {
    }

    public Account(String nameAccount, String password, String numberPhone, String email, String fullname, int age, String role) {
        this.nameAccount = nameAccount;
        this.password = password;
        this.numberPhone = numberPhone;
        this.email = email;
        this.fullname = fullname;
        this.age = age;
        this.role = role;
    }


    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return nameAccount +
                "," + password +
                "," + numberPhone +
                "," + email +
                "," + fullname +
                "," + age +
                "," + role +
                '\n';
    }
}
