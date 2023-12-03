package example.com.vn.model;

import java.io.Serializable;

public class SmsRead implements Serializable {
    private String phone;
    private String time;
    private String body;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public SmsRead(String phone, String time, String body) {
        this.phone = phone;
        this.time = time;
        this.body = body;
    }

    public SmsRead() {
    }
}
