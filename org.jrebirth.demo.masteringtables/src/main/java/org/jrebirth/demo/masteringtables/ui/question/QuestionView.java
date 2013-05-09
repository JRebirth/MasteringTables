package org.jrebirth.demo.masteringtables.ui.question;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.demo.masteringtables.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>QuestionView</strong>.
 * 
 * @author
 */
public class QuestionView extends AbstractView<QuestionModel, GridPane, QuestionController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionView.class);

    private Text leftOperand;
    private Text operator;
    private Text rightOperand;
    private Text equality;
    private Text result;

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

        leftOperand = TextBuilder.create().font(MTFonts.SPLASH.get()).build();

        operator = TextBuilder.create().font(MTFonts.SPLASH.get()).build();

        rightOperand = TextBuilder.create().font(MTFonts.SPLASH.get()).build();

        equality = TextBuilder.create()
                .font(MTFonts.SPLASH.get())
                .text("=")
                .build();

        result = TextBuilder.create()
                .font(MTFonts.SPLASH.get())
                .text("")
                .build();

        GridPane.setColumnIndex(leftOperand, 0);
        GridPane.setColumnIndex(operator, 1);
        GridPane.setColumnIndex(rightOperand, 2);
        GridPane.setColumnIndex(equality, 3);
        GridPane.setColumnIndex(result, 4);

        getRootNode().getChildren().addAll(leftOperand, operator, rightOperand, equality, result);
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
        return leftOperand;
    }

    /**
     * @return Returns the operator.
     */
    Text getOperator() {
        return operator;
    }

    /**
     * @return Returns the rightOperand.
     */
    Text getRightOperand() {
        return rightOperand;
    }

    /**
     * @return Returns the equality.
     */
    Text getEquality() {
        return equality;
    }

    /**
     * @return Returns the result.
     */
    Text getResult() {
        return result;
    }

}