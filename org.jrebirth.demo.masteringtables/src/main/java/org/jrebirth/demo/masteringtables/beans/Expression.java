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
import javafx.beans.property.StringProperty;

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
    private final StringProperty operatorProperty = new SimpleStringProperty();

    /**
     * Gets the left.
     * 
     * @return the left
     */
    public int getLeft() {
        return this.leftProperty.get();
    }

    /**
     * Sets the left.
     * 
     * @param left the new left
     */
    public void setLeft(final int left) {
        this.leftProperty.set(left);
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
    public int getRight() {
        return this.rightProperty.get();
    }

    /**
     * Sets the right.
     * 
     * @param right the new right
     */
    public void setRight(final int right) {
        this.rightProperty.set(right);
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
    public int getResult() {
        return this.resultProperty.get();
    }

    /**
     * Sets the result.
     * 
     * @param result the new result
     */
    public void setResult(final int result) {
        this.resultProperty.set(result);
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
    public String getOperator() {
        return this.operatorProperty.get();
    }

    /**
     * Sets the operator.
     * 
     * @param operator the new operator
     */
    public void setOperator(final String operator) {
        this.operatorProperty.set(operator);
    }

    /**
     * Operator property.
     * 
     * @return the simple object property
     */
    public StringProperty operatorProperty() {
        return this.operatorProperty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getLeft());
        sb.append(getOperator().toString());
        sb.append(getRight());
        sb.append("=");
        sb.append(getResult());

        return sb.toString();
    }

}
