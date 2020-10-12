package model;

public class Fingerprint implements Traceable{

    private final Person associatedPerson;
    private final String policeDepartment;

    public Fingerprint(Person person, String policeDepartment) {
        this.associatedPerson = person;
        this.policeDepartment = policeDepartment;

        person.takeFingerprint(this);
    }

    //Getters:
    public Person getAssociatedPerson() {
        return associatedPerson;
    }

    @Override
    public String getLocation()  {
        return "The fingerprint were taken in: "+policeDepartment;
    }

    @Override
    public Object getTrace() {
        return associatedPerson;
    }

    @Override
    public void track() {
        System.out.println("Tracking "+associatedPerson.getName()+" by fingerprint.");
    }
}
