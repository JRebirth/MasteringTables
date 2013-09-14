/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.demo.masteringtables.beans;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The Class GameSettings stores all data used to set up a game.
 */
public class GameSettings {

    /** The contains addition. */
    private final BooleanProperty containsAddition = new SimpleBooleanProperty();

    /** The contains subtraction. */
    private final BooleanProperty containsSubtraction = new SimpleBooleanProperty();

    /** The contains multiplication. */
    private final BooleanProperty containsMultiplication = new SimpleBooleanProperty();

    /** The contains division. */
    private final BooleanProperty containsDivision = new SimpleBooleanProperty();

    /** The question number. */
    private final IntegerProperty questionNumber = new SimpleIntegerProperty();

    /**
     * Contains addition property.
     * 
     * @return the boolean property
     */
    public BooleanProperty containsAdditionProperty() {
        return this.containsAddition;
    }

    /**
     * Gets the contains addition.
     * 
     * @return the contains addition
     */
    public boolean containsAddition() {
        return this.containsAddition.get();
    }

    /**
     * Sets the contains addition.
     * 
     * @param containsAddition the new contains addition
     */
    public void setContainsAddition(final boolean containsAddition) {
        this.containsAddition.set(containsAddition);
    }

    /**
     * Contains subtraction property.
     * 
     * @return the boolean property
     */
    public BooleanProperty containsSubtractionProperty() {
        return this.containsSubtraction;
    }

    /**
     * Gets the contains subtraction.
     * 
     * @return the contains subtraction
     */
    public boolean containsSubtraction() {
        return this.containsSubtraction.get();
    }

    /**
     * Sets the contains subtraction.
     * 
     * @param containsSubtraction the new contains subtraction
     */
    public void setContainsSubtraction(final boolean containsSubtraction) {
        this.containsSubtraction.set(containsSubtraction);
    }

    /**
     * Contains multiplication property.
     * 
     * @return the boolean property
     */
    public BooleanProperty containsMultiplicationProperty() {
        return this.containsMultiplication;
    }

    /**
     * Gets the contains multiplication.
     * 
     * @return the contains multiplication
     */
    public boolean containsMultiplication() {
        return this.containsMultiplication.get();
    }

    /**
     * Sets the contains multiplication.
     * 
     * @param containsMultiplication the new contains multiplication
     */
    void setContainsMultiplication(final boolean containsMultiplication) {
        this.containsMultiplication.set(containsMultiplication);
    }

    /**
     * Contains division property.
     * 
     * @return the boolean property
     */
    public BooleanProperty containsDivisionProperty() {
        return this.containsDivision;
    }

    /**
     * Gets the contains division.
     * 
     * @return the contains division
     */
    public boolean containsDivision() {
        return this.containsDivision.get();
    }

    /**
     * Sets the contains division.
     * 
     * @param containsDivision the new contains division
     */
    public void setContainsDivision(final boolean containsDivision) {
        this.containsDivision.set(containsDivision);
    }

    /**
     * Question number property.
     * 
     * @return the integer property
     */
    public IntegerProperty questionNumberProperty() {
        return this.questionNumber;
    }

    /**
     * Gets the question number.
     * 
     * @return the question number
     */
    public int getQuestionNumber() {
        return this.questionNumber.get();
    }

    /**
     * Sets the question number.
     * 
     * @param questionNumber the new question number
     */
    public void setQuestionNumber(final int questionNumber) {
        this.questionNumber.set(questionNumber);
    }

}
