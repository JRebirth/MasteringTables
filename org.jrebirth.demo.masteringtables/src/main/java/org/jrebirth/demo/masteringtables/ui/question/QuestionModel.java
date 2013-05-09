package org.jrebirth.demo.masteringtables.ui.question;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
public class QuestionModel extends AbstractModel<QuestionModel, QuestionView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionModel.class);

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

    public void displayExpression(final Expression expression, final Wave wave) {

        this.expression = expression;

        getView().getLeftOperand().setText(String.valueOf(expression.getLeft()));

        getView().getOperator().setText(expression.getOperator().toString());

        getView().getResult().setText("");

        getView().getRightOperand().setText(String.valueOf(expression.getRight()));
    }

    public void appendNumber(String name) {

        name = name.replaceAll("Numpad ", "");
        getView().getResult().setText(getView().getResult().getText() + name);

        checkResult();

    }

    private void checkResult() {
        final int type = Integer.parseInt(getView().getResult().getText());

        if (type == this.expression.getResult()) {
            sendWave(MTWaves.REGISTER_SUCCESS, WaveData.build(MTWaves.EXPRESSION, this.expression));
        } else {
            if (String.valueOf(type).length() == String.valueOf(this.expression.getResult()).length()) {
                sendWave(MTWaves.REGISTER_FAILURE, WaveData.build(MTWaves.EXPRESSION, this.expression));
            }

        }
    }

    public void deleteLastChar() {
        getView().getResult().setText(getView().getResult().getText().substring(0, Math.max(0, getView().getResult().getText().length() - 1)));
    }
}
