/**
 more info at : www.jrebirth.org .
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
package org.jrebirth.demo.masteringtables.ui.expression;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class QuestionModel.
 */
public class ExpressionModel extends AbstractModel<ExpressionModel, ExpressionView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionModel.class);

    /** The expression. */
    private Expression expression;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {
        // Put the code to initialize your model here
        listen(MTWaves.DISPLAY_EXPRESSION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeInnerModels() {
        // Put the code to initialize inner models here (if any)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processAction(final Wave wave) {
        // Process a wave action, you must listen the wave type before
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
        // Custom code to process when the view is displayed
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Custom code to process when the view is hidden
    }

    /**
     * Display expression.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void displayExpression(final Expression expression, final Wave wave) {

        this.expression = expression;

        getView().getLeftOperand().setText(String.valueOf(getExpression().getLeft()));
        getView().getOperator().setText(getExpression().getOperator().toString());
        getView().getRightOperand().setText(String.valueOf(getExpression().getRight()));
        getView().getEquality().setText("=");
        getView().getResult().setText("");

        getView().getShowExpression().play();

    }

    /**
     * Append number.
     * 
     * @param name the name
     */
    public void appendNumber(String name) {

        name = name.replaceAll("Numpad ", "");
        getView().getResult().setText(getView().getResult().getText() + name);

        checkResult();

    }

    /**
     * Check result.
     */
    private void checkResult() {
        final int type = Integer.parseInt(getView().getResult().getText());

        if (type == this.expression.getResult()) {
            getView().getExpressionResolved().play();
        } else {
            if (String.valueOf(type).length() == String.valueOf(this.expression.getResult()).length()) {
                getView().getExpressionFailure().play();
            }
        }
    }

    /**
     * Delete last char.
     */
    public void deleteLastChar() {
        getView().getResult().setText(getView().getResult().getText().substring(0, Math.max(0, getView().getResult().getText().length() - 1)));
    }

    /**
     * Gets the expression.
     * 
     * @return the expression
     */
    public Expression getExpression() {
        return this.expression;
    }
}
