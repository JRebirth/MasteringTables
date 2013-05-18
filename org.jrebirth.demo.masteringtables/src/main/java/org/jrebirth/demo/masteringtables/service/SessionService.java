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

// TODO: Auto-generated Javadoc
/**
 * The Class SessionService.
 */
public final class SessionService extends ServiceBase {

    /** The Constant ALL_EXPRESSIONS. */
    public static final WaveItem<List<Expression>> ALL_EXPRESSIONS = new WaveItem<List<Expression>>() {
    };

    /** The Constant DO_BUILD_TABLES. */
    public static final WaveTypeBase DO_BUILD_TABLES = WaveTypeBase.build("BUILD_TABLES");

    /** The Constant RE_TABLES_BUILT. */
    public static final WaveTypeBase RE_TABLES_BUILT = WaveTypeBase.build("TABLES_BUILT", ALL_EXPRESSIONS);

    /** The Constant LOGGER. */
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
     * Builds the tables.
     * 
     * @param wave the wave
     * @return the list
     */
    public List<Expression> buildTables(final Wave wave) {

        LOGGER.trace("Build Tables.");
        return null;
    }

}
