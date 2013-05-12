package org.jrebirth.demo.masteringtables.ui.game;

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
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.question.QuestionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
public class GameModel extends AbstractModel<GameModel, GameView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameModel.class);

    private final IntegerProperty success = new SimpleIntegerProperty(0);

    private final IntegerProperty failure = new SimpleIntegerProperty(0);

    private int index = 0;

    private List<Expression> gameList;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        listen(ExpressionBuilderService.RE_TABLES_BUILT);

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

    public void tablesBuilt(final List<Expression> allTables, final Wave wave) {

        Collections.shuffle(allTables);
        this.gameList = allTables.subList(0, 10);

        getView().getQuestionHolder().getChildren().clear();
        getView().getQuestionHolder().getChildren().add(getModel(QuestionModel.class).getRootNode());
        StackPane.setAlignment(getModel(QuestionModel.class).getRootNode(), Pos.CENTER);

        sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));

    }

    public void startGame(final List<Expression> expressionList, final Wave wave) {

    }

    public void registerSuccess(final Expression expression, final Wave wave) {

        this.success.setValue(this.success.getValue() + 1);
        this.index++;

        if (this.gameList.size() > this.index) {
            // continue game
            sendWave(MTWaves.DISPLAY_EXPRESSION, WaveData.build(MTWaves.EXPRESSION, this.gameList.get(this.index)));
        } else {
            // Game is finished
            sendWave(MTWaves.FINISH_GAME);
        }

    }

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

    public void doEnter() {
        // Nothing to do yet

    }

    public void doNumber(final KeyCode code) {
        getModel(QuestionModel.class).appendNumber(code.getName());
    }

    public void doCancel() {
        // Nothing to do yet

    }

    public void doDelete() {
        getModel(QuestionModel.class).deleteLastChar();

    }

    public Bounds getSuccessLocation() {
        return getView().getSuccessLabel().localToScene(getView().getSuccessLabel().getBoundsInLocal());
    }

    public Bounds getFailureLocation() {
        return getView().getFailureLabel().localToScene(getView().getFailureLabel().getBoundsInLocal());
    }

}
