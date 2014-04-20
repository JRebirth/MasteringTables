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

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * The Bean Expression.
 */
public class Expression {

    /** The left property. */
    private final SimpleIntegerProperty leftProperty = new SimpleIntegerProperty();

    /** The right property. */
    private final SimpleIntegerProperty rightProperty = new SimpleIntegerProperty();

    /** The result property. */
    private final SimpleIntegerProperty resultProperty = new SimpleIntegerProperty();

    /** The operator property. */
    private final SimpleStringProperty operatorProperty = new SimpleStringProperty();

    /**
     * Create a new instance of Expression object.
     * 
     * @return the fresh instance
     */
    public static Expression create() {
        return new Expression();
    }

    /**
     * Gets the left.
     * 
     * @return the left
     */
    public int left() {
        return this.leftProperty.get();
    }

    /**
     * Sets the left.
     * 
     * @param left the new left
     * 
     * @return the current instance to chain setters
     */
    public Expression left(final int left) {
        this.leftProperty.set(left);
        return this;
    }

    /**
     * Left property.
     * 
     * @return the simple integer property
     */
    public SimpleIntegerProperty leftProperty() {
        return this.leftProperty;
    }

    /**
     * Gets the right.
     * 
     * @return the right
     */
    public int right() {
        return this.rightProperty.get();
    }

    /**
     * Sets the right.
     * 
     * @param right the new right
     * 
     * @return the current instance to chain setters
     */
    public Expression right(final int right) {
        this.rightProperty.set(right);
        return this;
    }

    /**
     * Right property.
     * 
     * @return the simple integer property
     */
    public SimpleIntegerProperty rightProperty() {
        return this.rightProperty;
    }

    /**
     * Gets the result.
     * 
     * @return the result
     */
    public int result() {
        return this.resultProperty.get();
    }

    /**
     * Sets the result.
     * 
     * @param result the new result
     * 
     * @return the current instance to chain setters
     */
    public Expression result(final int result) {
        this.resultProperty.set(result);
        return this;
    }

    /**
     * Result property.
     * 
     * @return the simple integer property
     */
    public SimpleIntegerProperty resultProperty() {
        return this.resultProperty;
    }

    /**
     * Gets the operator.
     * 
     * @return the operator
     */
    public String operator() {
        return this.operatorProperty.get();
    }

    /**
     * Sets the operator.
     * 
     * @param operator the new operator
     * 
     * @return the current instance to chain setters
     */
    public Expression operator(final String operator) {
        this.operatorProperty.set(operator);
        return this;
    }

    /**
     * Operator property.
     * 
     * @return the simple object property
     */
    public SimpleStringProperty operatorProperty() {
        return this.operatorProperty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        sb.append(left());
        sb.append(operator().toString());
        sb.append(right());
        sb.append("=");
        sb.append(result());

        return sb.toString();
    }

}
