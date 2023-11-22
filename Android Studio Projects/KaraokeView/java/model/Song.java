package example.com.vn.model;

public class Song {
    private String id;
    private String name;
    private String singer;
    private boolean like;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Song(String id, String name, String singer, boolean like) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.like = like;
    }

    public Song() {
    }
}
