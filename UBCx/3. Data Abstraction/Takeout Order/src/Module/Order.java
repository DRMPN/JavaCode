package Module;

import static Main.Main.listOfAllCombos;

public class Order {
    private int TicketNumber;
    private String CustomerName;

    public boolean OrderStatus;
    private String SpecialInstructions;

    public int ComboNumber;
    public Combo SelectedCombo;
    private double Price;

    public void makeNewOrder(int TicketNumber,String CustomerName,String SpecialInstructions, int ComboNumber) {
        this.TicketNumber = TicketNumber;
        this.CustomerName = CustomerName;

        this.OrderStatus = false;
        this.SpecialInstructions = SpecialInstructions;

        this.ComboNumber = ComboNumber;
        this.SelectedCombo = getCombo();
        this.Price = SelectedCombo.getComboPrice();
    }

    //EFFECTS: gives client information about order
    public String getSpecialInstructions() {
        return SpecialInstructions;
    }

    //EFFECTS: gives appropriate combo
    public Combo getCombo() {
        if (this.ComboNumber == 1) {return listOfAllCombos.get(0);}
        else if (this.ComboNumber == 2) {return listOfAllCombos.get(1);}
        else {return listOfAllCombos.get(2);}
    }

    //EFFECTS: gives status of current order
    public String getOrderStatus() {
        if (OrderStatus) {return "Order is ready!";}
        else {return "Order is not ready!";}
    }

    public String fullOrderStatusInformation() {
        return this.CustomerName+" - "+this.TicketNumber+". "+this.getOrderStatus();
    }

}
