package fr.unantes.sce.calendar;

import fr.unantes.sce.people.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private List travels;
    private Person owner;

    public Calendar(Person owner) {
        this.setOwner(owner);
        setTravels(new ArrayList());
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean addTravel(Travel travel) throws IllegalStateException {
        if (this.getTravels().size()<=9) {
            return getTravels().add(travel);
        }else throw new IllegalStateException(" there are already 10 travels in the Calendar , consider deleting or replacing one");

    }

    public boolean removeTravel(Travel travel) {
        return getTravels().remove(travel);
    }

    public List getTravels() {
        return travels;
    }

    public void setTravels(List travels) {
        this.travels = travels;
    }
}
