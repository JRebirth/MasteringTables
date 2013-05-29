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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import org.jrebirth.core.ui.DefaultModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Game;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.command.CreateGameContent;
import org.jrebirth.demo.masteringtables.service.SessionService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.expression.ExpressionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameModel.
 */
public class GameModel extends DefaultModel<GameModel, GameView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameModel.class);

    private SessionService sessionService;

    /** The success. */
    // private final IntegerProperty success = new SimpleIntegerProperty(1000);

    /** The failure. */
    // private final IntegerProperty failure = new SimpleIntegerProperty(0);

    /** The index. */
    private int index = 0;

    /** The game list. */
    private final List<Expression> gameList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        listen(MTWaves.START_GAME);

        listen(MTWaves.REGISTER_SUCCESS);
        listen(MTWaves.REGISTER_FAILURE);

        this.sessionService = getService(SessionService.class);
    }

    @Override
    protected void customBind() {
        // Nothing to do yet

    }

    /**
     * Start game.
     * 
     * @param expressionList the expression list
     * @param wave the wave
     */
    public void startGame(final List<Expression> expressionList, final Wave wave) {

        this.index = 0;
        this.gameList.clear();
        this.gameList.addAll(expressionList);
        Collections.shuffle(expressionList);

        bindGame();

        getView().getQuestionHolder().getChildren().clear();
        getView().getQuestionHolder().getChildren().add(getModel(ExpressionModel.class).getRootNode());

        StackPane.setAlignment(getModel(ExpressionModel.class).getRootNode(), Pos.CENTER);

        sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));
    }

    /**
     * Return the current game object.
     * 
     * @return the current game
     */
    private Game getGame() {
        return this.sessionService.getCurrentGame();
    }

    private void bindGame() {
        this.sessionService.setCurrentGame(new Game());
        getView().getSuccessCounter().textProperty().bind(getGame().successCountProperty().asString());
        getView().getFailureCounter().textProperty().bind(getGame().failureCountProperty().asString());
    }

    /**
     * Register success.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void registerSuccess(final Expression expression, final Wave wave) {

        getGame().setSuccessCount(getGame().getSuccessCount() + 1);

        this.index++;

        if (this.gameList.size() > this.index) {
            // continue game
            sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));
        } else {

            // Game is finished
            sendWave(MTWaves.FINISH_GAME);
            sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.Result));
        }

    }

    /**
     * Register failure.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void registerFailure(final Expression expression, final Wave wave) {
        getGame().setFailureCount(getGame().getFailureCount() + 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
        callCommand(CreateGameContent.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Custom code to process when the view is hidden
    }

    /**
     * Do enter.
     */
    public void doEnter() {
        // Nothing to do yet

    }

    /**
     * Do number.
     * 
     * @param code the code
     */
    public void doNumber(final KeyCode code) {
        getModel(ExpressionModel.class).appendNumber(code.getName());
    }

    /**
     * Do cancel.
     */
    public void doCancel() {
        // Nothing to do yet

    }

    /**
     * Do delete.
     */
    public void doDelete() {
        getModel(ExpressionModel.class).deleteLastChar();

    }

}
