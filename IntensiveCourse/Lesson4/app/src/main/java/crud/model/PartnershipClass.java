package crud.model;

public class PartnershipClass extends AbstractClass {
    private String partner;

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "PartnershipClass [partner=" + partner + "]";
    }
    
}