package org.jrebirth.demo.masteringtables.ui.question;

import javafx.event.ActionEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public class QuestionController extends AbstractController<QuestionModel, QuestionView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public QuestionController(final QuestionView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {
        // Listen events
    }

    public void onFinishedExpressionResolved(final ActionEvent actionEvent) {
        getView().getResult().setScaleX(1);
        getView().getResult().setScaleY(1);
        getModel().sendWave(MTWaves.REGISTER_SUCCESS, WaveData.build(MTWaves.EXPRESSION, getModel().getExpression()));
    }

    public void onFinishedExpressionFailure(final ActionEvent actionEvent) {
        getView().getResult().setText("");
        getView().getResult().setScaleX(1);
        getView().getResult().setScaleY(1);
        getModel().sendWave(MTWaves.REGISTER_FAILURE, WaveData.build(MTWaves.EXPRESSION, getModel().getExpression()));
    }
}