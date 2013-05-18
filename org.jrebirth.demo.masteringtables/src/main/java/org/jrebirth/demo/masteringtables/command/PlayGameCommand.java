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

// TODO: Auto-generated Javadoc
/**
 * The Class PlayGameCommand.
 */
public class PlayGameCommand extends DefaultPoolCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute(final Wave wave) {

        final ExpressionBuilderService service = getService(ExpressionBuilderService.class);

        final GameSettings gs = getModel(StartModel.class).getGameSettings();

        final List<Expression> gameList = new ArrayList<>();

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
