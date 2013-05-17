package org.jrebirth.demo.masteringtables.beans;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GameSettings {

    private final BooleanProperty containsAddition = new SimpleBooleanProperty();
    private final BooleanProperty containsSubtraction = new SimpleBooleanProperty();
    private final BooleanProperty containsMultiplication = new SimpleBooleanProperty();
    private final BooleanProperty containsDivision = new SimpleBooleanProperty();

    private final IntegerProperty questionNumber = new SimpleIntegerProperty();

    /**
     * @return Returns the containsAddition.
     */
    public BooleanProperty containsAdditionProperty() {
        return containsAddition;
    }

    /**
     * @return Returns the containsAddition.
     */
    public boolean getContainsAddition() {
        return containsAddition.get();
    }

    /**
     * @param containsAddition The containsAddition to set.
     */
    public void setContainsAddition(boolean containsAddition) {
        this.containsAddition.set(containsAddition);
    }

    /**
     * @return Returns the containsSubtraction.
     */
    public BooleanProperty containsSubtractionProperty() {
        return containsSubtraction;
    }

    /**
     * @return Returns the containsSubtraction.
     */
    public boolean getContainsSubtraction() {
        return containsSubtraction.get();
    }

    /**
     * @param containsSubtraction The containsSubtraction to set.
     */
    public void setContainsSubtraction(boolean containsSubtraction) {
        this.containsSubtraction.set(containsSubtraction);
    }

    /**
     * @return Returns the containsMultiplication.
     */
    public BooleanProperty containsMultiplicationProperty() {
        return containsMultiplication;
    }

    /**
     * @return Returns the containsMultiplication.
     */
    public boolean getContainsMultiplication() {
        return containsMultiplication.get();
    }

    /**
     * @param containsMultiplication The containsMultiplication to set.
     */
    void setContainsMultiplication(boolean containsMultiplication) {
        this.containsMultiplication.set(containsMultiplication);
    }

    /**
     * @return Returns the containsDivision.
     */
    public BooleanProperty containsDivisionProperty() {
        return containsDivision;
    }

    /**
     * @return Returns the containsDivision.
     */
    public boolean getContainsDivision() {
        return containsDivision.get();
    }

    /**
     * @param containsDivision The containsDivision to set.
     */
    public void setContainsDivision(boolean containsDivision) {
        this.containsDivision.set(containsDivision);
    }

    /**
     * @return Returns the questionNumber.
     */
    public IntegerProperty questionNumberProperty() {
        return questionNumber;
    }

    /**
     * @return Returns the questionNumber.
     */
    public int getQuestionNumber() {
        return questionNumber.get();
    }

    /**
     * @param questionNumber The questionNumber to set.
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber.set(questionNumber);
    }

}
