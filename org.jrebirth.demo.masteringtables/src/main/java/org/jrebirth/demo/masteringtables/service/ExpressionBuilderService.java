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

import org.jrebirth.af.core.concurrent.Priority;
import org.jrebirth.af.core.concurrent.RunnablePriority;
import org.jrebirth.af.core.service.Service;
import org.jrebirth.af.core.wave.JRebirthItems;
import org.jrebirth.af.core.wave.Wave;
import org.jrebirth.af.core.wave.WaveItem;
import org.jrebirth.af.core.wave.WaveType;
import org.jrebirth.af.processor.annotation.RegistrationPoint;
import org.jrebirth.demo.masteringtables.beans.Expression;

/**
 * The Service ExpressionBuilder is used to build all mathematical tables.
 */
@RegistrationPoint(exclusive = true)
public interface ExpressionBuilderService extends Service {

    /** The Wave Item ALL_EXPRESSIONS. */
    WaveItem<List<Expression>> ALL_EXPRESSIONS = new WaveItem<List<Expression>>() {
    };

    /** The WaveType return action name. */
    String TABLES_BUILT = "TABLES_BUILT";

    /** The Wave Type DO_BUILD_TABLES. */
    WaveType DO_BUILD_TABLES = WaveType.create("BUILD_TABLES")
            .returnAction(TABLES_BUILT)
            .returnItem(JRebirthItems.booleanItem);

    /**
     * Builds all tables.
     *
     * @param wave the wave
     * @throws InterruptedException if the job is cancelled
     */
    @Priority(RunnablePriority.Highest)
    boolean doBuildTables(final Wave wave) throws InterruptedException;

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
