package Module;

public class Combo {

    public int ComboSetNumber;
    public String ComboComposition;
    public double ComboPrice;

    // Getters
    public int getComboSetNumber() {
        return ComboSetNumber;
    }
    public double getComboPrice() {
        return ComboPrice;
    }
    public String getComboComposition() {
        return ComboComposition;
    }

    public static Combo createCombo(int SetNumber, String Composition, double Price) {
        Combo init = new Combo();
        init.ComboSetNumber = SetNumber;
        init.ComboComposition = Composition;
        init.ComboPrice = Price;
        return init;
    }

}
