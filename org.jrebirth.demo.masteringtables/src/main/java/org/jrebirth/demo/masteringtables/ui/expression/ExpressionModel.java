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

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.object.DefaultObjectModel;
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
        view().getLeftOperand().textProperty().bind(object().leftProperty().asString());
        view().getOperator().textProperty().bind(object().operatorProperty());
        view().getRightOperand().textProperty().bind(object().rightProperty().asString());

        view().getEquality().setText("=");
        view().getResult().setText("");

    }

    /**
     * Display expression.
     *
     * @param expression the expression
     * @param wave the wave
     */
    public void doDisplayExpression(final Expression expression, final Wave wave) {

        // Store the current expression
        object(expression);

        // Start the show animation
        view().getShowExpression().play();
    }

    /**
     * Append number.
     *
     * @param name the name
     */
    public void appendNumber(final String name) {

        String number = name;
        if (name.contains("Numpad")) {
            number = name.replaceAll("Numpad ", "");
        }
        view().getResult().setText(view().getResult().getText() + number);

        checkResult();

    }

    /**
     * Check result.
     */
    private void checkResult() {
        final int type = Integer.parseInt(view().getResult().getText());

        if (type == object().result()) {
            view().getExpressionResolved().play();
        } else {
            if (String.valueOf(type).length() == String.valueOf(object().result()).length()) {
                view().getExpressionFailure().play();
            }
        }
    }

    /**
     * Delete last char.
     */
    public void deleteLastChar() {
        view().getResult().setText(view().getResult().getText().substring(0, Math.max(0, view().getResult().getText().length() - 1)));
    }

    /**
     * Reset the result text.
     */
    public void reset() {
        view().getResult().setText("");
    }

}
