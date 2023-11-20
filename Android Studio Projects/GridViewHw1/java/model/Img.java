package example.com.vn.model;

import androidx.annotation.NonNull;

public class Img {
    private int id;
    private String name;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Img(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public Img() {
    }

    @NonNull
    @Override
    public String toString() {
        return "Tên: " + this.name + "; số lượng: " + this.num;
    }
}
