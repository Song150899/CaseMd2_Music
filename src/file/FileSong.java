package file;

import model.Song;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSong {
    public static void writeToFile(List<Song> songs) throws IOException {
        File staffFile = new File("song.csv");
        staffFile.createNewFile();
        PrintWriter printWriter = new PrintWriter(staffFile);
        printWriter.println("id,nameSong,singer,creator,genre");
        for (int i = 0; i < songs.size(); i++) {
            printWriter.print(songs.get(i));
        }
        printWriter.close();
    }

    public static List<Song> readFormFile() throws FileNotFoundException {
        File staffFile = new File("song.csv");
        List<Song> songs = new ArrayList<>();
        Scanner scanner = new Scanner(staffFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                String[] arr = line.split(",");
                songs.add(new Song(Integer.parseInt(arr[0]), arr[1], (arr[2]), arr[3], arr[4]));
            }
        }
        return songs;
    }

}
