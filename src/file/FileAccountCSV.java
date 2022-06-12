package file;

import model.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccountCSV {
    public static void writeToFile(List<Account> accounts) throws IOException {
        File accountFile = new File("account.csv");
//        accountFile.createNewFile();
        PrintWriter printWriter = new PrintWriter(accountFile);
        printWriter.println("nameAcount,password,numberPhone,email,fullName,age,role");
        for (int i = 0; i < accounts.size(); i++) {
            printWriter.print(accounts.get(i));
        }
        printWriter.close();
    }

    public static List<Account> readFormFile() throws FileNotFoundException {
        File accountFile = new File("account.csv");
        List<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(accountFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                String[] arr = line.split(",");
                accounts.add(new Account(arr[0], arr[1], arr[2], arr[3], arr[4],
                        Integer.valueOf(arr[5]), arr[6]));
            }
        }
        return accounts;
    }
}
