package model;

import java.util.*;

public class Coin {

    private boolean status;

    public Coin() {
        status = generate_side();
    }

    // GETTER
    private boolean isStatus() {
        return status;
    }

    // SETTER
    private void setStatus(boolean status) {
        this.status = status;
    }

    //EFFECTS generates random side of a coin
    private boolean generate_side() {
        Random random_status = new Random();
        return random_status.nextBoolean();
    }

    //MODIFIES this
    //EFFECTS  tossing a coin
    public void flip() {
          this.setStatus(generate_side());
    }

    //EFFECTS Prints current status of the coin
    public String checkStatus() {
        if (isStatus()) {
            return ("Head");}
        else {
            return "Tail";}
    }

}