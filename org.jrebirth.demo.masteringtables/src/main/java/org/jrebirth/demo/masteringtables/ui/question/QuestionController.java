package org.jrebirth.demo.masteringtables.ui.question;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;

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

}