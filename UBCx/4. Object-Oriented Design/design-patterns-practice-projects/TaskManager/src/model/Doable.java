package model;

public abstract class Doable {

    protected boolean complete;

    public abstract String getDescription();

    public void complete() {
        if (!complete) {
            complete = true;
        }
    }

    public boolean getStatus() { return complete; }

    public abstract void display(String indentSpace);

}
