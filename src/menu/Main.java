package menu;

import file.FileAccountCSV;
import file.FileSong;
import manage.AccountManage;
import manage.SongManage;
import model.Account;
import model.Song;
import validate.ValidateSong;


import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {

        AccountManage accountManage = new AccountManage();
        SongManage songManage = new SongManage();
        Scanner scanner = new Scanner(System.in);
        ValidateSong validateSong = new ValidateSong();
        ArrayList<Song> songArrayList = new ArrayList<>();

        while (true) {
            System.out.println(ANSI_CYAN + "");
            System.out.println("                    ♪ ♪ ♪ Welcome to SAY MUSIC.mp3 ♪ ♪ ♪                        ");
            System.out.println("                    Nhập 1 để ĐĂNG NHẬP. Nhập 2 để ĐĂNG KÝ.                    ");
            System.out.println("                                                                               ");
            System.out.println("                                1. ĐĂNG NHẬP                                   ");
            System.out.println("                                2. ĐĂNG KÝ                                     ");
            System.out.println("" + ANSI_RESET);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Đăng nhập ");
                        System.out.println("Nhập vào tên tài khoản ");
                        String name = scanner.nextLine();
                        System.out.println("Nhập vào password ");
                        String pass = scanner.nextLine();
                        accountManage.login(name, pass);
                        if (accountManage.login(name, pass) == 1) {
                            if (AccountManage.currentAccount.getRole().equalsIgnoreCase("Admin")) {
                                try {
                                    while (true) {
                                        System.out.println(ANSI_CYAN + "");
                                        System.out.println("╔===================================================╗");
                                        System.out.println("║       ▂ ▃ ▅ ▆ █ QUẢN LÝ SAY MUSIC █ ▆ ▅ ▃ ▂       ║");
                                        System.out.println("╠===================================================╣");
                                        System.out.println("║>[1]. Thêm bài hát                                 ║");
                                        System.out.println("║>[2]. Tìm kiếm bài hát                             ║");
                                        System.out.println("║>[3]. Xóa bài hát                                  ║");
                                        System.out.println("║>[4]. Hiển thị danh sách bài hát                   ║");
                                        System.out.println("║>[6]. Sửa thông tin bài hát                        ║");
                                        System.out.println("║>[7]. Đổi mật khẩu                                 ║");
                                        System.out.println("║>[0]. Logout                                       ║");
                                        System.out.println("╚===================================================╝");
                                        System.out.println("[\uD83D\uDD11] Nhập lựa chọn:" + ANSI_RESET);

                                        try {
                                            int choice1 = Integer.parseInt(scanner.nextLine());
//                                        if (choice1 < 0 || choice1 > 7) {
//                                            System.out.println();
//                                            System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
//                                            System.out.println("--------------------");
//                                            System.out.println();
//                                        }
                                            switch (choice1) {
                                                case 1:

                                                    int id = validateSong.validateID(songArrayList);


                                                    String nameSong = validateSong.validateString(" tên bài hát");

                                                    String singer = validateSong.validateString(" tên ca sĩ");

                                                    String creator = validateSong.validateString(" tác giả");

                                                    String genre = validateSong.validateString(" thể loại nhạc");
                                                    songManage.add(new Song(id, nameSong, singer, creator, genre));
                                                    FileSong.writeToFile(songManage.getSongList());
                                                    break;
                                                case 2:
                                                    String nameFind = validateSong.validateString(" tên bài hát muốn tìm kiếm!");
                                                    songManage.printByName(nameFind);
                                                    break;
                                                case 3:
                                                    String nameDelete = validateSong.validateString(" tên bài hát muốn xóa");
                                                    songManage.delete(nameDelete);
                                                    break;
                                                case 4:
                                                    songManage.printAll();
                                                    break;

                                                case 6:

                                                    String nameEdit = validateSong.validateString(" tên bài hát muốn sửa:");

                                                    System.out.println("Nhập id: ");
                                                    int idEdit = Integer.parseInt(scanner.nextLine());

                                                    System.out.println("Nhập tên bài hát : ");
                                                    String nameSongEdit = scanner.nextLine();

                                                    System.out.println("Nhập tên tác giả : ");
                                                    String singerEdit = scanner.nextLine();

                                                    System.out.println("Nhập tên nhạc sĩ sáng tác");
                                                    String creatorEdit = scanner.nextLine();

                                                    System.out.println("Nhập thể loại bài hát");
                                                    String genreEdit = scanner.nextLine();
                                                    songManage.add(new Song(idEdit, nameSongEdit, singerEdit, creatorEdit, genreEdit));
//                                            int numberOfWorkDayEdit = scanner.nextInt();
//                                            songManage.edit(nameEdit, new Song(idEdit, nameStaffEdit, ageStaffEdit,
//                                                    identityEdit, typeEdit, statusEdit, addressEdit, numberOfWorkDayEdit));
                                                    FileSong.writeToFile(songManage.getSongList());
                                                    break;
                                                case 7:
                                                    System.out.println("Đổi mật khẩu ");
                                                    scanner.nextLine();
                                                    String newPass = scanner.nextLine();
                                                    AccountManage.currentAccount.setPassword(newPass);
                                                    System.out.println("Đổi mật khẩu thành công ! ");
                                                    FileSong.writeToFile(songManage.getSongList());
                                                    break;
                                                case 0:
                                                    System.exit(0);
                                                default:
                                                    throw new NumberFormatException();
                                            }
                                        } catch (NumberFormatException e) {
                                            System.err.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");

                                        }

                                    }
                                } catch (NumberFormatException | InputMismatchException e) {
                                    System.out.println();
                                    System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                                    System.out.println("--------------------");
                                    System.out.println();
                                }
                            } else {
                                try {
                                    while (true) {
                                        System.out.println(ANSI_BLUE + "Đăng nhập thành công");
                                        System.out.println("╔===================================================╗");
                                        System.out.println("║        ▂ ▃ ▅ ▆ █ SAY MUSIC.mp3 █ ▆ ▅ ▃ ▂          ║");
                                        System.out.println("╠===================================================╣");
                                        System.out.println("║>[1]. Xem danh sách bài hát                        ║");
                                        System.out.println("║>[2]. Sửa thông tin                                ║");
                                        System.out.println("║>[3]. Đổi mật khẩu                                 ║");
                                        System.out.println("║>[0]. Thoát                                        ║");
                                        System.out.println("╚===================================================╝");
                                        System.out.println("[\uD83D\uDD11] Nhập lựa chọn:" + ANSI_RESET);
                                        int choice1 = scanner.nextInt();
                                        if (choice1 < 0 || choice1 > 3) {
                                            System.out.println();
                                            System.err.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                                            System.out.println("--------------------");
                                            System.out.println();
                                        }
                                        switch (choice1) {
                                            case 1: {
                                                songManage.printAll();

                                            }
                                            case 2: {
                                                System.out.println("Nhập  số điện thoại mới");
                                                scanner.nextLine();
                                                String numberPhone = scanner.nextLine();
                                                AccountManage.currentAccount.setNumberPhone(numberPhone);
                                                System.out.println("Nhập email mới");
                                                String newEmail = scanner.nextLine();
                                                AccountManage.currentAccount.setFullname(newEmail);
                                                System.out.println("Nhập  họ tên mới");
                                                String newName = scanner.nextLine();
                                                AccountManage.currentAccount.setFullname(newName);
                                                FileAccountCSV.writeToFile(accountManage.getAccountList());
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Đổi mật khẩu ");
                                                scanner.nextLine();
                                                String newPass = scanner.nextLine();
                                                AccountManage.currentAccount.setPassword(newPass);
                                                System.out.println("Đổi mật khẩu thành công ! ");
                                                FileSong.writeToFile(songManage.getSongList());
                                                break;
                                            }
                                            case 0: {
                                                System.exit(0);
                                            }
                                        }
                                    }
                                } catch (NumberFormatException | InputMismatchException e) {
                                    System.out.println();
                                    System.out.println("⛔ Nhập sai chức năng, mời nhập lại !!!");
                                    System.out.println("--------------------");
                                    System.out.println();
                                }
                            }
                        }

                        break;
                    case 2:
                        System.out.println(ANSI_BLUE + " ♪ ♪ ♪ ĐĂNG KÝ ♪ ♪ ♪ " + ANSI_RESET);
                        System.out.println("Nhập vào tên tài khoản ");
                        String nameAccount = scanner.nextLine();
                        System.out.println("Nhập vào password ");
                        String password = scanner.nextLine();
                        System.out.println("Nhập vào số điện thoại ");
                        String numberPhone = scanner.nextLine();
                        System.out.println("Nhập vào email ");
                        String email = scanner.nextLine();
                        System.out.println("Nhập vào họ tên ");
                        String fullname = scanner.nextLine();
                        System.out.println("Nhập vào tuổi ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nhập vào quyền truy cập ");
                        String role = scanner.nextLine();
                        Account account = new Account(nameAccount, password, numberPhone, email, fullname, age, role);
                        accountManage.add(account);
                        System.out.println("Đăng ký thành công");
                        FileAccountCSV.writeToFile(accountManage.getAccountList());
                        break;
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("⛔ Nhập sai chức năng! Mời nhập lại");
            }

        }

    }
}

