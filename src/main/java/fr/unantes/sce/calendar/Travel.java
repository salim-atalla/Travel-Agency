package fr.unantes.sce.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    private List steps;
    private Calendar parent;

    public Travel(Calendar parent) {
        this.parent = parent;
        steps = new ArrayList();
    }

    public Calendar getParent() {
        return parent;
    }

    public void setParent(Calendar parent) {
        parent.basicAddTravel(this);
        this.basicSetParent(parent);
    }

    public void basicSetParent (Calendar parent) {
        this.parent = parent;
    }

    private void unSetParent () {
        this.parent.removeTravel(this);
        basicUnSetParent();
    }

    private void basicUnSetParent () {
        this.parent = null;
    }

    public Correspondence getFirstStep() {
        return (Correspondence) steps.get(0);
    }

    public Correspondence getLastStep() {
        return (Correspondence) steps.get(steps.size() - 1);
    }

    public boolean addCorrespondence(Correspondence step) {
        return steps.add(step);
    }

    public boolean removeCorrespondence(Correspondence step) {
        return steps.remove(step);
    }
}
