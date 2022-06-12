package manage;

import interfaces.InterfaceGenara;
import interfaces.InterfaceSong;
import model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongManage implements InterfaceGenara<Song>, InterfaceSong<Song> {
    ArrayList<Song> songList = new ArrayList<>();

//    public StaffManage() throws FileNotFoundException {
//        staffList = FileStaffCSV.readFormFile();
//
//    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setStaffList(ArrayList<Song> songList) {
        this.songList = songList;
    }


    @Override
    public void add(Song song) {
        songList.add(song);
    }

    @Override
    public void edit(String name, Song song) {
        songList.set(findByName(name), song);
    }

    @Override
    public void delete(String name) {
        songList.remove(findByName(name));

    }

    @Override
    public int findByName(String name) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getNameSong().contains(name)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void printAll() {
        for (Song s : songList
        ) {
            System.out.println(s);
        }

    }


    @Override
    public void printByGenre(String genre) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getGenre().equals(genre)) {
                System.out.println(songList.get(i));
            }
        }
    }

    @Override
    public void printByName(String name) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getNameSong().contains(name)) {
                System.out.println(songList.get(i));
            }
        }
    }
}



