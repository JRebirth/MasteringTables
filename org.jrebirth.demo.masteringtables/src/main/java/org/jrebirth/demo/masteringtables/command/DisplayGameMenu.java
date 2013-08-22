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

import java.util.concurrent.TimeUnit;

import org.jrebirth.core.command.DefaultCommand;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Page;
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
    protected void execute(final Wave wave) {

        // Sleep 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (final InterruptedException e) {
            LOGGER.error("Failure while sleeping 3s");
        }

        // Then launch the wave that will display the game menu
        sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.GameMenu));

    }
}
