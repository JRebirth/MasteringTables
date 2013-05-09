package org.jrebirth.demo.masteringtables.beans;

public enum Operator {
    subtraction,
    addition,
    multiplication,
    division;

    Operator() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String res;
        switch (this) {
            case subtraction:
                res = "-";
                break;
            case addition:
                res = "+";
                break;
            case multiplication:
                res = "x";
                break;
            case division:
                res = "÷";
                break;
            default:
                res = "";

        }
        return res;
    }
}