package model;


import model.media.AbstractMedia;
import model.media.*;

public class Main {

    private static iPod nano = new iPod("John");
    private static Movie m1 = new Movie("Dunkirk (2017)", "Christopher Nolan", "Drama",  107);
    private static Song s1 = new Song("Writing's on the Wall", "Sam Smith", "Ballad", 3.02);
    private static Photo p1 = new Photo("Moonrise", "Ansel Adams", "Landscape", "Yosemite");

    public static void main(String[] args) {

        nano.addMedia(m1);
        nano.addMedia(p1);
        nano.addMedia(s1);

        System.out.println(nano.getName() +"'s iPod contains: ");
        for (AbstractMedia m : nano) {
            System.out.println(m.getName() + " by: " + m.getCreator());
        }
    }

}