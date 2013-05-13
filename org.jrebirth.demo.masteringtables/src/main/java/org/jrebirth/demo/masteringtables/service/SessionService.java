package org.jrebirth.demo.masteringtables.service;

import java.util.List;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.service.ServiceBase;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveTypeBase;
import org.jrebirth.demo.masteringtables.beans.Expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SessionService</strong>.
 * 
 * @author
 */
public final class SessionService extends ServiceBase {

    public static final WaveItem<List<Expression>> ALL_EXPRESSIONS = new WaveItem<List<Expression>>() {
    };

    /** Perform something. */
    public static final WaveTypeBase DO_BUILD_TABLES = WaveTypeBase.build("BUILD_TABLES");

    /** Wave type to return when something was done. */
    public static final WaveTypeBase RE_TABLES_BUILT = WaveTypeBase.build("TABLES_BUILT", ALL_EXPRESSIONS);

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void ready() throws CoreException {
        super.ready();

        // Define the service method
        registerCallback(DO_BUILD_TABLES, RE_TABLES_BUILT);
    }

    /**
     * Do something.
     * 
     * @param wave the source wave
     */
    public List<Expression> buildTables(final Wave wave) {

        LOGGER.trace("Build Tables.");
        return null;
    }

}
