package validate;

import model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateSong {
    Scanner scanner = new Scanner(System.in);

    public int getIndexId(int id, ArrayList<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int validateID(ArrayList<Song> songList) {
        while (true) {
            try {
                System.out.println("Nhập id:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, songList) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id rồi");
            }
        }
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("không để trống");
                continue;
            } else {
                return str;
            }
        }
    }
}
