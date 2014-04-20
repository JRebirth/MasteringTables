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

import org.jrebirth.af.core.command.DefaultPoolCommand;
import org.jrebirth.af.core.wave.Wave;
import org.jrebirth.af.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.menu.GameMenuModel;

/**
 * The command CreateGameContent is used to generate the game list and length according to user choice.
 */
public class CreateGameContent extends DefaultPoolCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void perform(final Wave wave) {

        // This command will not be retained in memory
        final ExpressionBuilderService service = getService(ExpressionBuilderService.class);

        // Retrieve game settings from the ui
        final GameSettings gs = getModel(GameMenuModel.class).getGameSettings();

        // Add tables according to User choice
        final List<Expression> gameList = new ArrayList<>();

        if (gs.containsAddition()) {
            gameList.addAll(service.getAdditionTable());
        }
        if (gs.containsSubtraction()) {
            gameList.addAll(service.getSubtractionTable());
        }
        if (gs.containsMultiplication()) {
            gameList.addAll(service.getMultiplicationTable());
        }
        if (gs.containsDivision()) {
            gameList.addAll(service.getDivisionTable());
        }

        // Add some entropy
        Collections.shuffle(gameList);

        // Get expressions to be asked
        final WaveData<List<Expression>> gameData = WaveData.build(MTWaves.GAME_LIST, gameList.subList(0, gs.getQuestionNumber()));

        // Send a wave Display the game page
        sendWave(MTWaves.START_GAME, gameData);
    }
}
