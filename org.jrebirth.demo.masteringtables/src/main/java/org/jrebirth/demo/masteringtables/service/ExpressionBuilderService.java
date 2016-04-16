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

import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.concurrent.Priority;
import org.jrebirth.af.api.module.RegistrationPoint;
import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.annotation.OnWave;
import org.jrebirth.af.api.wave.contract.WaveItem;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.WBuilder;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.WaveItemBase;
import org.jrebirth.demo.masteringtables.beans.Expression;

/**
 * The Service ExpressionBuilder is used to build all mathematical tables.
 */
@RegistrationPoint(exclusive = true)
public interface ExpressionBuilderService extends Service {

    /** The Wave Item ALL_EXPRESSIONS. */
    WaveItem<List<Expression>> ALL_EXPRESSIONS = new WaveItemBase<List<Expression>>() {
    };

    /** The WaveType used to build Tables. */
    String BUILD_TABLES = "BUILD_TABLES";

    /** The WaveType return action name. */
    String TABLES_BUILT = "TABLES_BUILT";

    /** The Wave Type DO_BUILD_TABLES. */
    WaveType DO_BUILD_TABLES = WBuilder.waveType(BUILD_TABLES)
                                       .returnAction(TABLES_BUILT)
                                       .returnItem(JRebirthItems.voidItem);

    /**
     * Builds all tables.
     *
     * @param wave the wave
     * @throws InterruptedException if the job is cancelled
     */
    @OnWave(BUILD_TABLES)
    @Priority(PriorityLevel.Highest)
    void doBuildTables(final Wave wave) throws InterruptedException;

    /**
     * Gets the multiplication table.
     *
     * @return the multiplication table
     */
    List<Expression> getMultiplicationTable();

    /**
     * Gets the addition table.
     *
     * @return the addition table
     */
    List<Expression> getAdditionTable();

    /**
     * Gets the subtraction table.
     *
     * @return the subtraction table
     */
    List<Expression> getSubtractionTable();

    /**
     * Gets the division table.
     *
     * @return the division table
     */
    List<Expression> getDivisionTable();

}
