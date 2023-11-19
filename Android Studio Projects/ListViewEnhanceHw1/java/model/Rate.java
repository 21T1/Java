package example.com.vn.model;

public class Rate {

    private int id;
    private String name;
    private String buyCash;
    private String saleCash;
    private String buyTrans;
    private String saleTrans;

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

    public String getBuyCash() {
        return buyCash;
    }

    public void setBuyCash(String buyCash) {
        this.buyCash = buyCash;
    }

    public String getSaleCash() {
        return saleCash;
    }

    public void setSaleCash(String saleCash) {
        this.saleCash = saleCash;
    }

    public String getBuyTrans() {
        return buyTrans;
    }

    public void setBuyTrans(String buyTrans) {
        this.buyTrans = buyTrans;
    }

    public String getSaleTrans() {
        return saleTrans;
    }

    public void setSaleTrans(String saleTrans) {
        this.saleTrans = saleTrans;
    }

    public Rate(int id, String name, String buyCash, String saleCash, String buyTrans, String saleTrans) {
        this.id = id;
        this.name = name;
        this.buyCash = buyCash;
        this.saleCash = saleCash;
        this.buyTrans = buyTrans;
        this.saleTrans = saleTrans;
    }

    public Rate() {
    }
}
