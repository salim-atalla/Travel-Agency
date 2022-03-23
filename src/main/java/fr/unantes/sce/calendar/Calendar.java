package fr.unantes.sce.calendar;

import fr.unantes.sce.people.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private List<Travel> travels;
    private Person owner;

    public Calendar(Person owner) {
        this.setOwner(owner);
        this.travels = new ArrayList<>();
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean addTravel(Travel t) {
        if (travels.size() < 10) {
            t.setParent(this);
            return this.basicAddTravel(t);
        }
        return false;
    }

    public boolean basicAddTravel (Travel t) {
        return travels.add(t);
    }

    public boolean removeTravel(Travel t) {
        return this.travels.remove(t);
    }


    public List<Travel> getTravels() {
        return this.travels;
    }

    public void setTravels(List<Travel> travels) {
        for (Travel t : travels) {
            t.setParent(this);
        }
        this.travels = travels;
    }
}
