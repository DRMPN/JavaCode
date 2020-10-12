package ui;

import model.Airplane;
import model.Bird;
import model.Cafe;
import model.PrivatePlane;

public class FlyerDemo {
    public static void main(String[] args) {
        Bird birdie = new Bird();
        Airplane planie = new Airplane();
        Cafe cafePlane = new Airplane();

        PrivatePlane pp = new PrivatePlane();
        pp.takeoff();
        pp.bringWarmTowels();

        planie.takeoff();
        cafePlane.serveDrinks();
        birdie.fly();

        FlyerDemo fd = new FlyerDemo();
        fd.lunchService(planie);
    }

    public void lunchService(Cafe c) {
        c.serveDrinks();
        c.serveDrinks();
    }

    public void firstPartOfFlight(Airplane a) {
        a.takeoff();
        a.serveDrinks();
    }

    public void luxuryTakeOff(PrivatePlane p) {
        p.takeoff();
        p.bringWarmTowels();
    }
}
