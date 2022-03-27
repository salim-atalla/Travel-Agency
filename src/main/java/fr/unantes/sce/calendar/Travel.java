package fr.unantes.sce.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    private List<Correspondence> steps;
    private Calendar parent;

    public Travel(Calendar parent) {
        this.parent = parent;
        steps = new ArrayList<Correspondence>();
    }

    public Calendar getParent() {
        return parent;
    }

    public void setParent(Calendar parent) {
        if (parent != null) {
            parent.basicAddTravel(this);
            this.basicSetParent(parent);
        }
    }

    public void basicSetParent (Calendar parent) {
        this.parent = parent;
    }

    private void unSetParent () {
        if (this.parent != null) {
            this.parent.removeTravel(this);
            basicUnSetParent();
        }
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
        if (step != null) {
            step.setTravel(this);
            return this.basicAddCorrespondence(step);
        }
        return false;
    }

    public boolean basicAddCorrespondence(Correspondence step) {
        return steps.add(step);
    }

    public boolean removeCorrespondence(Correspondence step) {
        step.setTravel(null);
        return this.basicRemoveCorrespondence(step);
    }

    public boolean basicRemoveCorrespondence(Correspondence step) {
        return steps.remove(step);
    }

    public List<Correspondence> steps () {
        return this.steps;
    }
}
