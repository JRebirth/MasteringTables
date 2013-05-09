package org.jrebirth.demo.masteringtables.beans;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Expression {

    private final SimpleIntegerProperty leftProperty = new SimpleIntegerProperty();
    private final SimpleIntegerProperty rightProperty = new SimpleIntegerProperty();
    private final SimpleIntegerProperty resultProperty = new SimpleIntegerProperty();

    private final SimpleObjectProperty<Operator> operatorProperty = new SimpleObjectProperty<>();

    /**
     * @return Returns the left.
     */
    public int getLeft() {
        return this.leftProperty.get();
    }

    /**
     * @param left The left to set.
     */
    public void setLeft(final int left) {
        this.leftProperty.set(left);
    }

    public SimpleIntegerProperty leftProperty() {
        return this.leftProperty;
    }

    /**
     * @return Returns the right.
     */
    public int getRight() {
        return this.rightProperty.get();
    }

    /**
     * @param right The right to set.
     */
    public void setRight(final int right) {
        this.rightProperty.set(right);
    }

    public SimpleIntegerProperty rightProperty() {
        return this.rightProperty;
    }

    /**
     * @return Returns the result.
     */
    public int getResult() {
        return this.resultProperty.get();
    }

    /**
     * @param result The result to set.
     */
    public void setResult(final int result) {
        this.resultProperty.set(result);
    }

    public SimpleIntegerProperty resultProperty() {
        return this.resultProperty;
    }

    /**
     * @return Returns the operator.
     */
    public Operator getOperator() {
        return this.operatorProperty.get();
    }

    /**
     * @param operator The operator to set.
     */
    public void setOperator(final Operator operator) {
        this.operatorProperty.set(operator);
    }

    public SimpleObjectProperty<Operator> operatorProperty() {
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
