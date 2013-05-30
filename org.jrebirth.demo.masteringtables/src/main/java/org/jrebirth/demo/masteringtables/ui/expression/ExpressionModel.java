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

import org.jrebirth.core.ui.DefaultObjectModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ExpressionModel.
 */
public class ExpressionModel extends DefaultObjectModel<ExpressionModel, ExpressionView, Expression> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionModel.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {
        // Listen event to display a given expression
        listen(MTWaves.DISPLAY_EXPRESSION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void bind() {

        // Bind expression properties
        getView().getLeftOperand().textProperty().bind(getObject().leftProperty().asString());
        getView().getOperator().textProperty().bind(getObject().operatorProperty());
        getView().getRightOperand().textProperty().bind(getObject().rightProperty().asString());

        getView().getEquality().setText("=");
        getView().getResult().setText("");

    }

    /**
     * Display expression.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void doDisplayExpression(final Expression expression, final Wave wave) {

        // Store the current expression
        setObject(expression);

        // Start the show animation
        getView().getShowExpression().play();
    }

    /**
     * Append number.
     * 
     * @param name the name
     */
    public void appendNumber(String name) {

        if (name.contains("Numpad")) {
            name = name.replaceAll("Numpad ", "");
        } else {

        }
        getView().getResult().setText(getView().getResult().getText() + name);

        checkResult();

    }

    /**
     * Check result.
     */
    private void checkResult() {
        final int type = Integer.parseInt(getView().getResult().getText());

        if (type == getObject().getResult()) {
            getView().getExpressionResolved().play();
        } else {
            if (String.valueOf(type).length() == String.valueOf(getObject().getResult()).length()) {
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

}
