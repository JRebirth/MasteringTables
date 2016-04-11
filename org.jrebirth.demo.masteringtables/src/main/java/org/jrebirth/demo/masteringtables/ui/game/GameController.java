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

import javafx.scene.input.KeyEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.ui.adapter.KeyAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameController.
 */
public class GameController extends DefaultController<GameModel, GameView> implements KeyAdapter {

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
    protected void initEventAdapters() throws CoreException {
        view().node().addEventFilter(KeyEvent.KEY_RELEASED, getHandler(KeyEvent.KEY_RELEASED));
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

        switch (keyEvent.getCode()) {
            case ENTER:
                model().performEnter();
                break;
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
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
                model().performNumber(keyEvent.getCode());
                break;
            case ESCAPE:
                model().performCancel();
                break;
            case DELETE:
            case BACK_SPACE:
                model().performDelete();
                break;
            default:
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
