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
package org.jrebirth.demo.masteringtables.ui.game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;
import org.jrebirth.core.ui.adapter.KeyAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameController.
 */
public class GameController extends AbstractController<GameModel, GameView> implements KeyAdapter {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    /**
     * Instantiates a new game controller.
     * 
     * @param view the view
     * @throws CoreException the core exception
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void key(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nothing to do yet

    }

}