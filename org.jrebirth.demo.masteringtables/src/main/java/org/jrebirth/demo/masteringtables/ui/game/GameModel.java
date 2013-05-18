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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.question.QuestionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GameModel.
 */
public class GameModel extends AbstractModel<GameModel, GameView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameModel.class);

    /** The success. */
    private final IntegerProperty success = new SimpleIntegerProperty(0);

    /** The failure. */
    private final IntegerProperty failure = new SimpleIntegerProperty(0);

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
     * Start game.
     * 
     * @param expressionList the expression list
     * @param wave the wave
     */
    public void startGame(final List<Expression> expressionList, final Wave wave) {

        this.gameList.clear();
        this.gameList.addAll(expressionList);
        Collections.shuffle(expressionList);

        getView().getQuestionHolder().getChildren().clear();
        getView().getQuestionHolder().getChildren().add(getModel(QuestionModel.class).getRootNode());

        StackPane.setAlignment(getModel(QuestionModel.class).getRootNode(), Pos.CENTER);

        sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));
    }

    /**
     * Register success.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void registerSuccess(final Expression expression, final Wave wave) {

        this.success.setValue(this.success.getValue() + 1);
        this.index++;

        if (this.gameList.size() > this.index) {
            // continue game
            sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));
        } else {
            // Game is finished
            sendWave(MTWaves.FINISH_GAME);
            sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.StartMenu));
        }

    }

    /**
     * Register failure.
     * 
     * @param expression the expression
     * @param wave the wave
     */
    public void registerFailure(final Expression expression, final Wave wave) {
        this.failure.setValue(this.failure.getValue() + 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
        getView().getSuccessLabel().textProperty().bind(this.success.asString());
        getView().getFailureLabel().textProperty().bind(this.failure.asString());
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
        getModel(QuestionModel.class).appendNumber(code.getName());
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
        getModel(QuestionModel.class).deleteLastChar();

    }

    /**
     * Gets the success location.
     * 
     * @return the success location
     */
    public Bounds getSuccessLocation() {
        return getView().getSuccessLabel().localToScene(getView().getSuccessLabel().getBoundsInLocal());
    }

    /**
     * Gets the failure location.
     * 
     * @return the failure location
     */
    public Bounds getFailureLocation() {
        return getView().getFailureLabel().localToScene(getView().getFailureLabel().getBoundsInLocal());
    }

}
