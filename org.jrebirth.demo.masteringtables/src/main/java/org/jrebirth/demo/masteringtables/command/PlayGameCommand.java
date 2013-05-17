package org.jrebirth.demo.masteringtables.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jrebirth.core.command.DefaultPoolCommand;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.start.StartModel;

public class PlayGameCommand extends DefaultPoolCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute(final Wave wave) {

        ExpressionBuilderService service = getService(ExpressionBuilderService.class);

        GameSettings gs = getModel(StartModel.class).getGameSettings();

        List<Expression> gameList = new ArrayList<>();

        if (gs.getContainsAddition()) {
            gameList.addAll(service.getAdditionTable());
        }
        if (gs.getContainsSubtraction()) {
            gameList.addAll(service.getSubtractionTable());
        }
        if (gs.getContainsMultiplication()) {
            gameList.addAll(service.getMultiplicationTable());
        }
        if (gs.getContainsDivision()) {
            gameList.addAll(service.getDivisionTable());
        }

        Collections.shuffle(gameList);

        sendWave(MTWaves.START_GAME, WaveData.build(MTWaves.GAME_LIST, gameList.subList(0, 5)));
    }
}
