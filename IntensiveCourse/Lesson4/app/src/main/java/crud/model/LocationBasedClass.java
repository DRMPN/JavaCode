package crud.model;

public class LocationBasedClass extends AbstractClass {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationBasedClass [location=" + location + "]";
    }

}
