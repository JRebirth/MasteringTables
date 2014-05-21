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

import javafx.util.Builder;

/**
 * The Class ExpressionBuilder.
 *
 * @param <B> the generic type of the current builder
 */
public class ExpressionBuilder<B extends ExpressionBuilder<B>> implements Builder<Expression> {

    /** The bit mask. */
    private long bitMask;

    /** The left operand. */
    private int leftOperand;

    /** The right operand. */
    private int rightOperand;

    /** The result operand. */
    private int resultOperand;

    /** The operator. */
    private Operator operator;

    /**
     * Creates the.
     *
     * @return the expression builder
     */
    @SuppressWarnings("rawtypes")
    public static ExpressionBuilder<?> create() {
        return new ExpressionBuilder();
    }

    /**
     * Apply to.
     *
     * @param expr the expr
     */
    public void applyTo(final Expression expr) {
        // super.applyTo(paramWave);
        if (hasBit(0)) {
            expr.left(this.leftOperand);
        }
        if (hasBit(1)) {
            expr.right(this.rightOperand);
        }
        if (hasBit(2)) {
            expr.result(this.resultOperand);
        }
        if (hasBit(3)) {
            expr.operator(this.operator.toString());
        }
    }

    /**
     * Left.
     *
     * @param leftOperand the left operand
     * @return the b
     */
    @SuppressWarnings("unchecked")
    public B left(final int leftOperand) {
        this.leftOperand = leftOperand;
        addBit(0);
        return (B) this;
    }

    /**
     * Right.
     *
     * @param rightOperand the right operand
     * @return the b
     */
    @SuppressWarnings("unchecked")
    public B right(final int rightOperand) {
        this.rightOperand = rightOperand;
        addBit(1);
        return (B) this;
    }

    /**
     * Result.
     *
     * @param resultOperand the result operand
     * @return the b
     */
    @SuppressWarnings("unchecked")
    public B result(final int resultOperand) {
        this.resultOperand = resultOperand;
        addBit(2);
        return (B) this;
    }

    /**
     * Operator.
     *
     * @param operator the operator
     * @return the b
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
     * Adds the bit.
     *
     * @param bit the bit
     */
    protected void addBit(final int bit) {
        this.bitMask |= 1 << bit;
    }

    /**
     * Checks for bit.
     *
     * @param bit the bit
     * @return true, if successful
     */
    protected boolean hasBit(final int bit) {
        return (this.bitMask & 1 << bit) != 0;
    }

}
