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
package org.jrebirth.demo.masteringtables.ui.result;

import javafx.beans.binding.NumberBinding;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Game;
import org.jrebirth.demo.masteringtables.command.WaitAndStart;
import org.jrebirth.demo.masteringtables.service.SessionService;

/**
 * The Class SplashModel.
 */
public class ResultModel extends AbstractModel<ResultModel, ResultView> {

    private SessionService sessionService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        sessionService = getService(SessionService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeInnerModels() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {

        Game g = sessionService.getCurrentGame();

        getView().getSuccessLabel().textProperty().bind(g.successCountProperty().asString());
        getView().getFailureLabel().textProperty().bind(g.failureCountProperty().asString());

        NumberBinding ratio = g.successCountProperty().multiply(100)
                .divide(g.successCountProperty().add(g.failureCountProperty()));

        getView().getRatioLabel().textProperty().bind(ratio.asString().concat(" %"));

        callCommand(WaitAndStart.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processAction(final Wave wave) {
        // Nothing to do yet

    }
}
