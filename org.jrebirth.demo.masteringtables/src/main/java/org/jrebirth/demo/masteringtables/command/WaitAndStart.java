package org.jrebirth.demo.masteringtables.command;

import java.util.concurrent.TimeUnit;

import org.jrebirth.core.command.DefaultCommand;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitAndStart extends DefaultCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(WaitAndStart.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute(Wave wave) {

        // Sleep 5 seconds
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            LOGGER.error("Splash failure while sleeping 5s");
        }

        // Then launch the wave that will display teh game menu
        sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.StartMenu));

    }
}
