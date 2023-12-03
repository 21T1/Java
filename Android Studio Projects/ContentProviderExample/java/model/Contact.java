package example.com.vn.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact() {
    }

    @NonNull
    @Override
    public String toString() {
        return this.name + "\n" + this.phone;
    }
}
