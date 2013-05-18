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
package org.jrebirth.demo.masteringtables.ui.question;

import javafx.animation.Animation;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBuilder;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.core.ui.annotation.OnFinished;
import org.jrebirth.demo.masteringtables.resources.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionView.
 */
public class QuestionView extends AbstractView<QuestionModel, FlowPane, QuestionController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionView.class);

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
    public QuestionView(final QuestionModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        getRootNode().setId("QuestionPanel");
        getRootNode().setAlignment(Pos.CENTER);
        getRootNode().setMaxSize(600, 200);

        this.leftOperand = TextBuilder.create()
                .scaleX(0).scaleY(0)
                .wrappingWidth(100)
                .textAlignment(TextAlignment.CENTER)
                .font(MTFonts.SPLASH.get())
                .build();

        this.operator = TextBuilder.create()
                .scaleX(0).scaleY(0)
                .wrappingWidth(100)
                .textAlignment(TextAlignment.CENTER)
                .font(MTFonts.SPLASH.get())
                .build();

        this.rightOperand = TextBuilder.create()
                .scaleX(0).scaleY(0)
                .font(MTFonts.SPLASH.get())
                .textAlignment(TextAlignment.CENTER)
                .build();

        this.equality = TextBuilder.create()
                .scaleX(0).scaleY(0)
                .wrappingWidth(100)
                .textAlignment(TextAlignment.CENTER)
                .font(MTFonts.SPLASH.get())
                .text("=")
                .build();

        this.result = TextBuilder.create()
                .wrappingWidth(200)
                .textAlignment(TextAlignment.CENTER)
                .font(MTFonts.SPLASH.get())
                .text("")
                .build();

        getRootNode().getChildren().addAll(this.leftOperand, this.operator, this.rightOperand, this.equality, this.result);

        getExpressionResolved();
        getExpressionFailure();

        this.showExpression = SequentialTransitionBuilder.create()
                .children(
                        buildTextPartAnimation(getLeftOperand()),
                        buildTextPartAnimation(getOperator()),
                        buildTextPartAnimation(getRightOperand()),
                        buildTextPartAnimation(getEquality())
                )
                .build();
    }

    /**
     * Builds the text part animation.
     * 
     * @param textNode the text node
     * @return the animation
     */
    private Animation buildTextPartAnimation(final Text textNode) {
        return ParallelTransitionBuilder.create()
                .node(textNode)
                .children(
                        ScaleTransitionBuilder.create()
                                .fromX(0.0).toX(1.0)
                                .fromY(0.0).toY(1.0)
                                .build()
                )

                .build();
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
     * Gets the expression resolved.
     * 
     * @return the expression resolved
     */
    Animation getExpressionResolved() {

        if (this.expressionResolved == null) {
            this.expressionResolved = ParallelTransitionBuilder.create()
                    .delay(Duration.millis(600))
                    // .duration(Duration.millis(400))
                    .children(
                            ScaleTransitionBuilder.create()
                                    .node(getResult())
                                    .fromX(1).toX(4.0)
                                    .fromY(1).toY(4.0)
                                    .build(),

                            ScaleTransitionBuilder.create()
                                    .node(getLeftOperand())
                                    .fromX(1).toX(0)
                                    .fromY(1).toY(0)
                                    .build(),
                            ScaleTransitionBuilder.create()
                                    .node(getOperator())
                                    .fromX(1).toX(0)
                                    .fromY(1).toY(0)
                                    .build(),
                            ScaleTransitionBuilder.create()
                                    .node(getRightOperand())
                                    .fromX(1).toX(0)
                                    .fromY(1).toY(0)
                                    .build(),
                            ScaleTransitionBuilder.create()
                                    .node(getEquality())
                                    .fromX(1).toX(0)
                                    .fromY(1).toY(0)
                                    .build()
                    ).build();
        }
        return this.expressionResolved;
    }

    /**
     * Gets the expression failure.
     * 
     * @return the expression failure
     */
    public Animation getExpressionFailure() {
        if (this.expressionFailure == null) {
            this.expressionFailure = ScaleTransitionBuilder.create()
                    .delay(Duration.millis(1000))
                    .node(getResult())
                    .fromX(1).toX(0.0)
                    .fromY(1).toY(0.0)
                    .duration(Duration.millis(500))
                    .build();
        }
        return this.expressionFailure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {
        // Custom code to process when the view is displayed the first time
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Custom code to process when the view is displayed the 1+n time
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Custom code to process when the view is hidden
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