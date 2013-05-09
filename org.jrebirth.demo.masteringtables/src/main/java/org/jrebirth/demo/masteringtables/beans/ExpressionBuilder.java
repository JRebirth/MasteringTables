package org.jrebirth.demo.masteringtables.beans;

import javafx.util.Builder;

/**
 * The class <strong>ExpressionBuilder</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @param <B> the builder recursive type
 */
public class ExpressionBuilder<B extends ExpressionBuilder<B>> implements Builder<Expression> {

    /** The field used to store the property mask (allow up to 64 properties). */
    private long bitMask;

    private int leftOperand;
    private int rightOperand;
    private int resultOperand;
    private Operator operator;

    /**
     * Create a WaveBuilder instance.
     * 
     * @return new instance of WaveBuilder
     */
    @SuppressWarnings("rawtypes")
    public static ExpressionBuilder<?> create() {
        return new ExpressionBuilder();
    }

    /**
     * Apply all wave properties.
     * 
     * @param expr the wave that need to be initialized with builder values
     */
    public void applyTo(final Expression expr) {
        // super.applyTo(paramWave);
        if (hasBit(0)) {
            expr.setLeft(this.leftOperand);
        }
        if (hasBit(1)) {
            expr.setRight(this.rightOperand);
        }
        if (hasBit(2)) {
            expr.setResult(this.resultOperand);
        }
        if (hasBit(3)) {
            expr.setOperator(this.operator);
        }
    }

    /**
     * Define the wave group.
     * 
     * @param waveGroup the wave group to set
     * 
     * @return the builder
     */
    @SuppressWarnings("unchecked")
    public B left(final int leftOperand) {
        this.leftOperand = leftOperand;
        addBit(0);
        return (B) this;
    }

    /**
     * Define the wave type.
     * 
     * @param waveType the wave type to set
     * 
     * @return the builder
     */
    @SuppressWarnings("unchecked")
    public B right(final int rightOperand) {
        this.rightOperand = rightOperand;
        addBit(1);
        return (B) this;
    }

    /**
     * Define the related class.
     * 
     * @param relatedClass the related class to set
     * 
     * @return the builder
     */
    @SuppressWarnings("unchecked")
    public B result(final int resultOperand) {
        this.resultOperand = resultOperand;
        addBit(2);
        return (B) this;
    }

    /**
     * Define the related class.
     * 
     * @param relatedClass the related class to set
     * 
     * @return the builder
     */
    @SuppressWarnings("unchecked")
    public B operator(final Operator operator) {
        this.operator = operator;
        addBit(3);
        return (B) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Expression build() {
        final Expression localWave = new Expression();
        applyTo(localWave);
        return localWave;
    }

    /**
     * Add a bit to the mask.
     * 
     * @param bit the bit to add
     */
    protected void addBit(final int bit) {
        this.bitMask |= 1 << bit;
    }

    /**
     * Check if the mask contains the requested bit.
     * 
     * @param bit the requested bit
     * 
     * @return true if the mask contains the requested bit
     */
    protected boolean hasBit(final int bit) {
        return (this.bitMask & 1 << bit) != 0;
    }

}
