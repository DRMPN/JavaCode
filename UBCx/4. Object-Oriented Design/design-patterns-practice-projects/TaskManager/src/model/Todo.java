package model;

import java.util.LinkedList;
import java.util.List;

public class Todo extends Doable {

    private String description;
    private List<Doable> subs;


    public Todo(String description) {
        complete = false;
        this.description = description;
        subs = new LinkedList<>();
    }

    // getters
    public List<Doable> getSubTasks() { return subs; }
    @Override
    public String getDescription() {
        return description;
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + this.getDescription());
        for (Doable d : subs) {
            d.display(indentSpace+indentSpace);
        }
    }

    /**
     *
     * @param d the item we want to add to our subtodos
     * @return true if we are able to add the item with no duplicates, else false
     */
    public boolean addDoable(Doable d) {
        if (!subs.contains(d)) {
            subs.add(d);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param d the item we want to remove from our subtodos
     * @return true if we are able to remove the item from our subtodos, else false
     */
    public boolean removeDoable(Doable d) {
        if (subs.contains(d)) {
            subs.remove(d);
            return true;
        } else {
            return false;
        }
    }

}