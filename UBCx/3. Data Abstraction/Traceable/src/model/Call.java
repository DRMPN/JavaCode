package model;

public class Call implements Traceable {

    private final Cellphone associatedCellphone;

    public Call(Cellphone cellphone) {
        this.associatedCellphone = cellphone;
        associatedCellphone.getRecentCalls().add(this);
    }

    //Getters:

    @Override
    public String getLocation() {
        return "The call was made from "+associatedCellphone.getPhoneNumber()+". "+associatedCellphone.getLocation();
    }

    @Override
    public Object getTrace() {
        return associatedCellphone;
    }

    @Override
    public void track() {
        System.out.println("Tracking caller: "+associatedCellphone.getPhoneNumber());
    }
}
