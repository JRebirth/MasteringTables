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
import org.jrebirth.demo.masteringtables.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>QuestionView</strong>.
 * 
 * @author
 */
public class QuestionView extends AbstractView<QuestionModel, FlowPane, QuestionController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionView.class);

    private Text leftOperand;
    private Text operator;
    private Text rightOperand;
    private Text equality;
    private Text result;

    private Animation showExpression;

    @OnFinished(name = "ExpressionResolved")
    private Animation expressionResolved;

    @OnFinished(name = "ExpressionFailure")
    private Animation expressionFailure;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
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
     * @return Returns the showExpression.
     */
    public Animation getShowExpression() {
        return this.showExpression;
    }

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
     * @return Returns the expressionFailure.
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
     * @return Returns the leftOperand.
     */
    Text getLeftOperand() {
        return this.leftOperand;
    }

    /**
     * @return Returns the operator.
     */
    Text getOperator() {
        return this.operator;
    }

    /**
     * @return Returns the rightOperand.
     */
    Text getRightOperand() {
        return this.rightOperand;
    }

    /**
     * @return Returns the equality.
     */
    Text getEquality() {
        return this.equality;
    }

    /**
     * @return Returns the result.
     */
    Text getResult() {
        return this.result;
    }

}