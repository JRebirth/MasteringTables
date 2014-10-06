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

import java.util.ArrayList;
import java.util.List;

import org.jrebirth.af.core.concurrent.Priority;
import org.jrebirth.af.core.concurrent.RunnablePriority;
import org.jrebirth.af.core.service.DefaultService;
import org.jrebirth.af.core.wave.Wave;
import org.jrebirth.af.processor.annotation.Register;
import org.jrebirth.af.processor.annotation.RegistrationPriority;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Service ExpressionBuilder is used to build all mathematical tables.
 */
@Register(value = ExpressionBuilderService.class, priority = RegistrationPriority.Normal)
public final class ExpressionBuilderServiceImpl extends DefaultService implements ExpressionBuilderService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionBuilderServiceImpl.class);

    /** The multiplication table. */
    private final List<Expression> multiplicationTable = new ArrayList<>();

    /** The addition table. */
    private final List<Expression> additionTable = new ArrayList<>();

    /** The subtraction table. */
    private final List<Expression> subtractionTable = new ArrayList<>();

    /** The division table. */
    private final List<Expression> divisionTable = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void initService() {

        // Define the service method
        listen(DO_BUILD_TABLES);
    }

    /**
     * {@inheritDoc}
     */
    @Priority(RunnablePriority.Highest)
    public boolean doBuildTables(final Wave wave) throws InterruptedException {

        LOGGER.trace("Build Tables.");

        final int allItems = 12 * 12 * 3 + 12 * 13;
        int counter = 0;

        updateProgress(wave, 0, allItems);

        // 12 * 12 * 3 items (432)
        for (int leftOperand = 1; leftOperand <= 12; leftOperand++) {

            for (int rightOperand = 1; rightOperand <= 12; rightOperand++) {

                this.multiplicationTable.add(Expression.create()
                        .left(leftOperand)
                        .operator(Operator.multiplication.toString())
                        .right(rightOperand)
                        .result(leftOperand * rightOperand)
                        );
                // updateProgress(wave, ++counter, allItems);
                Thread.sleep(2);

                this.additionTable.add(Expression.create()
                        .left(leftOperand)
                        .operator(Operator.addition.toString())
                        .right(rightOperand)
                        .result(leftOperand + rightOperand)
                        );
                // updateProgress(wave, ++counter, allItems);
                Thread.sleep(2);

                this.divisionTable.add(Expression.create()
                        .left(rightOperand * leftOperand)
                        .operator(Operator.division.toString())
                        .right(leftOperand)
                        .result(rightOperand)
                        );
                // updateProgress(wave, ++counter, allItems);
                Thread.sleep(2);

                counter += 3;
                updateProgress(wave, counter, allItems);
            }

        }

        // 12 * 13 * 1 items (156)
        int tableGap = 0;
        for (int rightOperand = 0; rightOperand <= 11; rightOperand++) {

            for (int leftOperand = tableGap; leftOperand <= tableGap + 12; leftOperand++) {

                this.subtractionTable.add(Expression.create()
                        .left(leftOperand)
                        .operator(Operator.subtraction.toString())
                        .right(rightOperand)
                        .result(leftOperand - rightOperand)
                        );
                // updateProgress(wave, ++counter, allItems);
                Thread.sleep(2);
            }
            counter += 13;
            updateProgress(wave, counter, allItems);
            tableGap++;
        }

        LOGGER.trace("Tables are ready !");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public List<Expression> getMultiplicationTable() {
        return this.multiplicationTable;
    }

    /**
     * {@inheritDoc}
     */
    public List<Expression> getAdditionTable() {
        return this.additionTable;
    }

    /**
     * {@inheritDoc}
     */
    public List<Expression> getSubtractionTable() {
        return this.subtractionTable;
    }

    /**
     * {@inheritDoc}
     */
    public List<Expression> getDivisionTable() {
        return this.divisionTable;
    }

}
