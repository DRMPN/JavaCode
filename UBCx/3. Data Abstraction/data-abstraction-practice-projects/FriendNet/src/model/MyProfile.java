package model;

import java.util.ArrayList;
import java.util.List;

public class MyProfile {

    private final String name;
    private final int age;
    private final String currentLocation;
    private final String workPlace;
    private final List<MyProfile> friendsList = new ArrayList<>();
    private final List<Event> upcomingEvents = new ArrayList<>();

    public MyProfile(String nm, int age, String locn, String work) {
        this.name = nm;
        this.age = age;
        this.currentLocation = locn;
        this.workPlace = work;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public String getWorkPlace() {
        return workPlace;
    }
    public List<MyProfile> getFriendsList() {
        return friendsList;
    }
    public List<Event> getEventList() {
        return upcomingEvents;
    }
    public int upcomingEventNum() {
        return upcomingEvents.size();
    }

    // REQUIRES: f is not already in friendsList
    // MODIFIES: this
    // EFFECTS: consumes a MyProfile object, a friend f, and adds it to the friendsList
    public void addFriend(MyProfile f) {
        this.friendsList.add(f);
    }

    // MODIFIES: this
    // EFFECTS: removes a friend with the given name from this. If removal is successful, return true, else
    //          return false
    public boolean unFriend(String nm) {
        for (MyProfile friend : friendsList) {
            if (friend.getName().equals(nm)) {
                friendsList.remove(friend);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: ev is not in upcomingEvents
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        this.upcomingEvents.add(ev);
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name. If removal is successful, return true, else return false
    public boolean removeEvent(String nm) {
        for (Event event : upcomingEvents) {
            if (event.getName().equals(nm)) {
                upcomingEvents.remove(event);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of events that are at the current location of this person
    public int eventNumNearMe() {
        int n = 0;
        for (Event event : this.upcomingEvents) {
            if (event.getLocation().equals(this.getCurrentLocation())) {
                n+=1;
            }
        }
        return n;
    }

    // EFFECTS: returns the number of events of the given type et
    public int specificEventType(EventType et) {
        int n = 0;
        for (Event event : this.upcomingEvents) {
            if (event.getEventType() == et) {
                n+=1;
            }
        }
        return n;
    }

    // EFFECTS: prints events of  type et to the console
    //          Hint: is there a method you have already written that you can use?
    public void printEventSchedule(EventType et) {
        for (Event event : upcomingEvents) {
            if (event.getEventType()==et) {
                System.out.println(event);
            }
        }
    }

    // EFFECTS: prints out the list of friends that this MyProfile has
    public void printFriendNames() {
        for (MyProfile friend : friendsList) {
            System.out.println(friend.getName());
        }
    }

    // EFFECTS: prints out the names of friends who live at the same location associated with this profile
    public void printFriendsNearMe() {
        for (MyProfile friend : friendsList) {
            if (friend.getCurrentLocation().equals(this.currentLocation)) {
                System.out.println(friend.getName());
            }
        }
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        if (this.friendsList.isEmpty()) {return false;};

        for (MyProfile friend : friendsList) {
            if (friend.getName().equals(name)) {
                return true;
            }
        }

        for (MyProfile friend : friendsList) {
            if (friend.canFindPerson(name)) {
                return true;
            }
        }

        return false;
    }


}
