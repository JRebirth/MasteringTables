package org.jrebirth.demo.masteringtables.ui.game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;
import org.jrebirth.core.ui.adapter.KeyAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public class GameController extends AbstractController<GameModel, GameView> implements KeyAdapter {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public GameController(final GameView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {
        getView().getRootNode().addEventFilter(KeyEvent.KEY_RELEASED, getHandler(KeyEvent.KEY_RELEASED));
        // getRootNode().requestFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {
        // Listen events
    }

    @Override
    public void key(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {

        }
        switch (keyEvent.getCode()) {
            case ENTER:
                getModel().doEnter();
                break;
            case NUMPAD0:
            case NUMPAD1:
            case NUMPAD2:
            case NUMPAD3:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9:
                getModel().doNumber(keyEvent.getCode());
                break;
            case ESCAPE:
                getModel().doCancel();
                break;
            case DELETE:
            case BACK_SPACE:
                getModel().doDelete();
                break;

        }

    }

    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

}