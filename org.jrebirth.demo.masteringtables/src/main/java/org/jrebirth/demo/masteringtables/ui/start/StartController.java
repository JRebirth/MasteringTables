package org.jrebirth.demo.masteringtables.ui.start;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public class StartController extends AbstractController<StartModel, StartView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartController.class);

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public StartController(final StartView view) throws CoreException {
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