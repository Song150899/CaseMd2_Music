package model;

public class Song {
    private int id;
    private String nameSong;
    private String singer;
    private String creator;
    private String genre;

    public Song() {
    }

    public Song(int id, String nameSong, String singer, String creator, String genre) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.creator = creator;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return
                id +
                        nameSong + "," +
                        singer + "," +
                        creator + "," +
                        genre + ","
                ;
    }
}
