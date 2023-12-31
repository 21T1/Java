package example.com.vn.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private boolean selected;

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.selected = false;
    }

    public Contact() {
    }
}
