package org.jrebirth.demo.masteringtables.service;

import java.util.ArrayList;
import java.util.List;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.service.ServiceBase;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveTypeBase;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.ExpressionBuilder;
import org.jrebirth.demo.masteringtables.beans.Operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleService</strong>.
 * 
 * @author
 */
public final class ExpressionBuilderService extends ServiceBase {

    public static final WaveItem<List<Expression>> ALL_EXPRESSIONS = new WaveItem<List<Expression>>() {
    };

    /** Perform something. */
    public static final WaveTypeBase DO_BUILD_TABLES = WaveTypeBase.build("BUILD_TABLES");

    /** Wave type to return when something was done. */
    public static final WaveTypeBase RE_TABLES_BUILT = WaveTypeBase.build("TABLES_BUILT", ALL_EXPRESSIONS);

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionBuilderService.class);

    private final List<Expression> allTables = new ArrayList<>();

    private final List<Expression> multiplicationTable = new ArrayList<>();
    private final List<Expression> additionTable = new ArrayList<>();
    private final List<Expression> subtractionTable = new ArrayList<>();
    private final List<Expression> divisionTable = new ArrayList<>();

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

        for (int leftOperand = 1; leftOperand <= 12; leftOperand++) {

            for (int rightOperand = 1; rightOperand <= 12; rightOperand++) {

                this.multiplicationTable.add(ExpressionBuilder.create().left(leftOperand).operator(Operator.multiplication).right(rightOperand).result(leftOperand * rightOperand).build());
                this.additionTable.add(ExpressionBuilder.create().left(leftOperand).operator(Operator.addition).right(rightOperand).result(leftOperand + rightOperand).build());

                this.divisionTable.add(ExpressionBuilder.create().left(rightOperand * leftOperand).operator(Operator.division).right(leftOperand).result(rightOperand).build());
            }

        }

        int tableGap = 0;
        for (int rightOperand = 0; rightOperand <= 11; rightOperand++) {

            for (int leftOperand = tableGap; leftOperand <= tableGap + 12; leftOperand++) {

                this.subtractionTable.add(ExpressionBuilder.create().left(leftOperand).operator(Operator.subtraction).right(rightOperand).result(leftOperand - rightOperand).build());
            }
            tableGap++;
        }

        this.allTables.addAll(this.additionTable);
        this.allTables.addAll(this.subtractionTable);
        this.allTables.addAll(this.multiplicationTable);
        this.allTables.addAll(this.divisionTable);

        LOGGER.trace("Tables are ready !");
        return this.allTables;
    }

    /**
     * @return Returns the allTables.
     */
    public List<Expression> getAllTables() {
        return this.allTables;
    }

    /**
     * @return Returns the multiplicationTable.
     */
    public List<Expression> getMultiplicationTable() {
        return this.multiplicationTable;
    }

    /**
     * @return Returns the additionTable.
     */
    public List<Expression> getAdditionTable() {
        return this.additionTable;
    }

    /**
     * @return Returns the subtractionTable.
     */
    public List<Expression> getSubtractionTable() {
        return this.subtractionTable;
    }

    /**
     * @return Returns the divisionTable.
     */
    public List<Expression> getDivisionTable() {
        return this.divisionTable;
    }

}
