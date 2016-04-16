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
package org.jrebirth.demo.masteringtables.ui.expression;

import javafx.event.ActionEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.wave.WBuilder;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ExpressionController.
 */
public class ExpressionController extends DefaultController<ExpressionModel, ExpressionView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionController.class);

    /**
     * Instantiates a new question controller.
     *
     * @param view the view
     * @throws CoreException the core exception
     */
    public ExpressionController(final ExpressionView view) throws CoreException {
        super(view);
    }

    /**
     * On finished expression resolved.
     *
     * @param actionEvent the action event
     */
    public void onFinishedExpressionResolved(final ActionEvent actionEvent) {

        // Reset basic scale
        view().getResult().setScaleX(1);
        view().getResult().setScaleY(1);

        // Send a register success event
        model().sendWave(MTWaves.REGISTER_SUCCESS, WBuilder.waveData(MTWaves.EXPRESSION, model().object()));
    }

    /**
     * On finished expression failure.
     *
     * @param actionEvent the action event
     */
    public void onFinishedExpressionFailure(final ActionEvent actionEvent) {

        // Reset basic scale and erase current result
        view().getResult().setText("");
        view().getResult().setScaleX(1);
        view().getResult().setScaleY(1);

        // Send a register failure event
        model().sendWave(MTWaves.REGISTER_FAILURE, WBuilder.waveData(MTWaves.EXPRESSION, model().object()));
    }
}
