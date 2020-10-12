package model;

public class Person {

    private final String name;
    private Fingerprint fingerprint;
    private Cellphone cellphone;

    public Person(String name) {
        this.name = name;
    }

    //Getters:
    public String getName() {
        return name;
    }
    public Fingerprint getFingerprint() {
        return fingerprint;
    }

    //Setters:
    public void takeFingerprint(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
    }
    public void takeCellPhone(Cellphone cellphone) {this.cellphone = cellphone;}
}
