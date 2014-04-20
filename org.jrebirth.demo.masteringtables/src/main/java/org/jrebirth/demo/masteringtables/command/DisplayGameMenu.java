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

import org.jrebirth.af.core.command.DefaultCommand;
import org.jrebirth.af.core.concurrent.RunInto;
import org.jrebirth.af.core.concurrent.RunType;
import org.jrebirth.af.core.concurrent.RunnablePriority;
import org.jrebirth.af.core.wave.JRebirthWaves;
import org.jrebirth.af.core.wave.OnWave;
import org.jrebirth.af.core.wave.Wave;
import org.jrebirth.af.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class DisplayGameMenu.
 * 
 * Wait 5 second then display the game menu
 */
public class DisplayGameMenu extends DefaultCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayGameMenu.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initCommand() {
        LOGGER.trace("Initialize Command " + this.getClass().getSimpleName());
        listen(ExpressionBuilderService.RE_TABLES_BUILT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void perform(final Wave wave) {

        // Call the right service to generate all tables
        // Forward the progress bar attached to the upstream wave
        returnData(ExpressionBuilderService.class, ExpressionBuilderService.DO_BUILD_TABLES,
                wave.getData(JRebirthWaves.PROGRESS_BAR));
    }

    /**
     * Tables built.
     * 
     * @param wave the wave
     */
    @OnWave(ExpressionBuilderService.TABLES_BUILT)
    @RunInto(value = RunType.JTP, priority = RunnablePriority.High)
    public void doTablesBuilt(final boolean bool, final Wave wave) {
        // When tables are built, launch the wave that will display the game menu
        sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.GameMenu));
    }
}
