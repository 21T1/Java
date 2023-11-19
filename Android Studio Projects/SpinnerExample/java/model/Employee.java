package example.com.vn.model;

import androidx.annotation.NonNull;

public class Employee {
    private String name;
    private int year;
    private String day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Employee(String name, int year, String day) {
        this.name = name;
        this.year = year;
        this.day = day;
    }

    public Employee() {
    }

    @NonNull
    @Override
    public String toString() {
        return "Họ và tên: " + this.name
                + "\nNăm sinh: " + this.year
                + "\nNgày làm việc: " + this.day;
    }
}

