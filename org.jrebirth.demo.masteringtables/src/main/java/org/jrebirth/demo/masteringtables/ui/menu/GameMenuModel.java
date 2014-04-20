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
package org.jrebirth.demo.masteringtables.ui.menu;

import org.jrebirth.af.core.annotation.Component;
import org.jrebirth.af.core.ui.DefaultModel;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameMenuModel.
 */
public class GameMenuModel extends DefaultModel<GameMenuModel, GameMenuView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameMenuModel.class);

    /** The service used to build quiz data. */
    @Component
    private ExpressionBuilderService expressionBuilderService;

    /** The game settings bean. */
    private final GameSettings gameSettings = new GameSettings();

    /**
     * Gets the game settings.
     * 
     * @return the game settings
     */
    public GameSettings getGameSettings() {
        return this.gameSettings;
    }
}
