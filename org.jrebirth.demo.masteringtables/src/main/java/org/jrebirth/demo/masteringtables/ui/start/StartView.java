package org.jrebirth.demo.masteringtables.ui.start;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 */
public class StartView extends AbstractView<StartModel, BorderPane, StartController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartView.class);

    private StackPane questionHolder;

    private Label successLabel;

    private Label failureLabel;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public StartView(final StartModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {

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

}