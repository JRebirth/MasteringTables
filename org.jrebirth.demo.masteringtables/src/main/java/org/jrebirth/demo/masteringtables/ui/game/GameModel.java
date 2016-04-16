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

import static org.jrebirth.af.core.wave.WBuilder.waveData;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import org.jrebirth.af.api.annotation.Link;
import org.jrebirth.af.api.component.basic.InnerComponent;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.annotation.OnWave;
import org.jrebirth.af.core.ui.object.DefaultObjectModel;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Game;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.command.CreateGameContent;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.expression.ExpressionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameModel.
 */
public class GameModel extends DefaultObjectModel<GameModel, GameView, Game> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameModel.class);

    /** The Expression UI inner component. */
    @Link
    protected InnerComponent<ExpressionModel> expressionModel;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {

        // listen(MTWaves.START_GAME);

        listen(MTWaves.REGISTER_SUCCESS);
        listen(MTWaves.REGISTER_FAILURE);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initInnerComponents() {
        // Preload the expression model
        expressionModel.get();
    }

    @Override
    protected void bind() {

        // Bind counter values
        view().getSuccessCounter().textProperty().bind(object().successCountProperty().asString());
        view().getFailureCounter().textProperty().bind(object().failureCountProperty().asString());

    }

    /**
     * Start game.
     *
     * @param expressionList the expression list
     * @param wave the wave
     */
    @OnWave(MTWaves.START_GAME_CODE)
    public void doStartGame(final List<Expression> expressionList, final Wave wave) {

        // Reset the current index and counters
        object().setIndex(0);
        object().setSuccessCount(0);
        object().setFailureCount(0);

        // Add new generated list of expression
        object().getGameList().clear();
        object().getGameList().addAll(expressionList);

        // Clear the current expression panel
        view().getExpressionHolder().getChildren().clear();
        view().getExpressionHolder().getChildren().add(expressionModel.get().node());

        // Center the panel
        StackPane.setAlignment(expressionModel.get().node(), Pos.CENTER);

        view().startTimer();

        // Display the current expression with the help of the inner model
        sendWave(MTWaves.DISPLAY_EXPRESSION, waveData(MTWaves.EXPRESSION, object().getCurrentExpression()));
    }

    /**
     * Register success.
     *
     * @param expression the expression
     * @param wave the wave
     */
    public void doRegisterSuccess(final Expression expression, final Wave wave) {

        object().setSuccessCount(object().getSuccessCount() + 1);

        object().setIndex(object().getIndex() + 1);

        if (object().hasMoreExpression()) {
            // continue game
            sendWave(MTWaves.DISPLAY_EXPRESSION, waveData(MTWaves.EXPRESSION, object().getCurrentExpression()));
        } else {

            view().stopTimer();

            // Game is finished
            // sendWave(MTWaves.FINISH_GAME);
            sendWave(MTWaves.DO_SHOW_PAGE, waveData(MTWaves.PAGE, Page.Result));
        }

    }

    /**
     * Register failure.
     *
     * @param expression the expression
     * @param wave the wave
     */
    public void doRegisterFailure(final Expression expression, final Wave wave) {
        object().setFailureCount(object().getFailureCount() + 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void showView() {

        callCommand(CreateGameContent.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void hideView() {
        findInnerComponent(expressionModel).reset();
    }

    /**
     * Do number.
     *
     * @param code the code
     */
    public void performNumber(final KeyCode code) {
        findInnerComponent(expressionModel).appendNumber(code.getName());
    }

    /**
     * Do Enter.
     */
    public void performEnter() {
        // Nothing to do yet

    }

    /**
     * Do cancel.
     */
    public void performCancel() {
        // Cancel the game
        sendWave(MTWaves.FINISH_GAME);

        // Display the star menu
        sendWave(MTWaves.DO_SHOW_PAGE, waveData(MTWaves.PAGE, Page.GameMenu));

    }

    /**
     * Do delete.
     */
    public void performDelete() {
        findInnerComponent(expressionModel).deleteLastChar();

    }

    // @OnRelease
    // public void customRelease() {
    // getInnerModel(EXPRESSION).release();
    // }

}
