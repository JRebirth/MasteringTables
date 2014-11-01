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

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

import org.jrebirth.af.core.ui.object.DefaultObjectModel;
import org.jrebirth.demo.masteringtables.beans.Game;
import org.jrebirth.demo.masteringtables.service.SessionService;

/**
 * The Class ResultModel.
 */
public class ResultModel extends DefaultObjectModel<ResultModel, ResultView, Game> {

    /** The session service is used to store game statistics. */
    private SessionService sessionService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {

        // Store an hard link to avoid losing game stats
        this.sessionService = getService(SessionService.class);
        // not used yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void bind() {

        final Game g = getObject();

        getView().getTimeLabel().textProperty().bind(g.timeEllapsedProperty());

        // Bind number of success and failure to UI objects
        getView().getSuccessLabel().textProperty().bind(g.successCountProperty().asString());
        getView().getFailureLabel().textProperty().bind(g.failureCountProperty().asString());

        if (g.getSuccessCount() > 0) {
            // Compute Hit ratio
            final NumberBinding totalattempt = g.successCountProperty().add(g.failureCountProperty());
            final NumberBinding ratio = Bindings.when(totalattempt.greaterThan(0))
                                                .then(Bindings.divide(g.successCountProperty().multiply(100), totalattempt))
                                                .otherwise(0);

            getView().getRatioLabel().textProperty().bind(ratio.asString().concat("%"));

        }
    }

}
