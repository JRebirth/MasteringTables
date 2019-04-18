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
package org.jrebirth.demo.masteringtables.ui.expression;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.api.ui.annotation.OnFinished;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.DefaultView;
import org.jrebirth.demo.masteringtables.resources.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ExpressionView.
 */
@RootNodeId("ExpressionPanel")
public class ExpressionView extends DefaultView<ExpressionModel, FlowPane, ExpressionController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionView.class);

    /** The left operand. */
    private Text leftOperand;

    /** The operator. */
    private Text operator;

    /** The right operand. */
    private Text rightOperand;

    /** The equality. */
    private Text equality;

    /** The result. */
    private Text result;

    /** The show expression. */
    private Animation showExpression;

    /** The expression resolved. */
    @OnFinished(name = "ExpressionResolved")
    private Animation expressionResolved;

    /** The expression failure. */
    @OnFinished(name = "ExpressionFailure")
    private Animation expressionFailure;

    /**
     * Instantiates a new question view.
     *
     * @param model the model
     * @throws CoreException the core exception
     */
    public ExpressionView(final ExpressionModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        node().setAlignment(Pos.CENTER);

        node().setPrefSize(650, 200);
        node().setMaxSize(700, 200);

        this.leftOperand = getExpressionText();
        this.leftOperand.setWrappingWidth(180);

        this.operator = getExpressionText();
        this.operator.setWrappingWidth(60);

        this.rightOperand = getExpressionText();
        this.rightOperand.setWrappingWidth(120);

        this.equality = getExpressionText();
        this.equality.setWrappingWidth(60);
        this.equality.setText("=");

        this.result = getExpressionText();
        this.result.setWrappingWidth(180);
        this.result.setScaleX(1.0);
        this.result.setScaleY(1.0);
        this.result.setText("");

        node().getChildren().addAll(this.leftOperand, this.operator, this.rightOperand, this.equality, this.result);

        // Manage Animation
        this.expressionResolved = buildExpressionResolved();
        this.expressionFailure = buildExpressionFailure();

        this.showExpression = new SequentialTransition();
        ((SequentialTransition) this.showExpression).getChildren().addAll(
                                                                          buildTextPartAnimation(getLeftOperand()),
                                                                          buildTextPartAnimation(getOperator()),
                                                                          buildTextPartAnimation(getRightOperand()),
                                                                          buildTextPartAnimation(getEquality()));

        // Add a nice drop shadow in all direction
        final DropShadow s = new DropShadow();
        s.setHeight(10);
        s.setWidth(10);
        s.setColor(Color.BLACK);
        s.setBlurType(BlurType.THREE_PASS_BOX);
        s.setRadius(10);
        s.setSpread(0.1);

        node().setEffect(s);
    }

    /**
     * Return the text builder used for expression part.
     *
     * @return the text builder
     */
    private Text getExpressionText() {
        Text t = new Text();
        t.setScaleX(0);
        t.setScaleY(0);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(MTFonts.EXPRESSION.get());
        return t;
    }

    /**
     * Builds the text part animation.
     *
     * @param textNode the text node
     * @return the animation
     */
    private Animation buildTextPartAnimation(final Text textNode) {

        ScaleTransition st = new ScaleTransition();
        st.setDuration(Duration.millis(300)); // SHOULD BE CONFIGURABLE (Game Speed)
        st.setFromX(0.0);
        st.setToX(1.0);
        st.setFromY(0.0);
        st.setToY(1.0);

        ParallelTransition pt = new ParallelTransition();
        pt.setNode(textNode);
        pt.getChildren().addAll(st);

        return pt;
    }

    /**
     * Gets the show expression.
     *
     * @return the show expression
     */
    public Animation getShowExpression() {
        return this.showExpression;
    }

    /**
     * @return Returns the expressionResolved.
     */
    Animation getExpressionResolved() {
        return this.expressionResolved;
    }

    /**
     * Gets the expression resolved.
     *
     * @return the expression resolved
     */
    private Animation buildExpressionResolved() {

        ParallelTransition pt = new ParallelTransition();
        pt.setDelay(Duration.millis(400));
        pt.getChildren().addAll(
                                buildScaleTransition(this.result, 1.0, 4.0),
                                buildScaleTransition(getLeftOperand(), 1, 0),
                                buildScaleTransition(getOperator(), 1, 0),
                                buildScaleTransition(getRightOperand(), 1, 0),
                                buildScaleTransition(getEquality(), 1, 0));
        return pt;
    }

    /**
     * TODO To complete.
     */
    private ScaleTransition buildScaleTransition(Node node, double from, double to) {
        ScaleTransition st = new ScaleTransition();
        st.setNode(node);
        st.setFromX(from);
        st.setToX(to);
        st.setFromY(from);
        st.setToY(to);
        return st;
    }

    /**
     * @return Returns the expressionFailure.
     */
    Animation getExpressionFailure() {
        return this.expressionFailure;
    }

    /**
     * Gets the expression failure.
     *
     * @return the expression failure
     */
    private Animation buildExpressionFailure() {
        ScaleTransition st = new ScaleTransition();
        st.setDelay(Duration.millis(500));
        st.setNode(getResult());
        st.setFromX(1);
        st.setToX(0.0);
        st.setFromY(1);
        st.setToY(0.0);
        st.setDuration(Duration.millis(400));
        return st;
    }

    /**
     * Gets the left operand.
     *
     * @return the left operand
     */
    Text getLeftOperand() {
        return this.leftOperand;
    }

    /**
     * Gets the operator.
     *
     * @return the operator
     */
    Text getOperator() {
        return this.operator;
    }

    /**
     * Gets the right operand.
     *
     * @return the right operand
     */
    Text getRightOperand() {
        return this.rightOperand;
    }

    /**
     * Gets the equality.
     *
     * @return the equality
     */
    Text getEquality() {
        return this.equality;
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    Text getResult() {
        return this.result;
    }

}
