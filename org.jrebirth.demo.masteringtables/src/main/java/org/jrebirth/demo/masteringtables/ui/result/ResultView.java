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

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.DefaultController;
import org.jrebirth.core.ui.DefaultView;
import org.jrebirth.core.ui.annotation.RootNodeId;
import org.jrebirth.demo.masteringtables.resources.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ResultView.
 */
@RootNodeId("ResultPanel")
public class ResultView extends DefaultView<ResultModel, BorderPane, DefaultController<ResultModel, ResultView>> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultView.class);

    private Label successLabel;
    private Label failureLabel;

    private Label ratioLabel;

    /**
     * Instantiates a new page view.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
    public ResultView(final ResultModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        final VBox vbox = new VBox();

        this.successLabel = LabelBuilder.create()
                .font(MTFonts.EXPRESSION.get())
                .build();

        this.failureLabel = LabelBuilder.create()
                .font(MTFonts.EXPRESSION.get())
                .build();

        this.ratioLabel = LabelBuilder.create()
                .font(MTFonts.EXPRESSION.get())
                .build();

        vbox.getChildren().addAll(this.successLabel, this.failureLabel, this.ratioLabel);

        vbox.setAlignment(Pos.CENTER);
        getRootNode().setCenter(vbox);

    }

    /**
     * @return Returns the successLabel.
     */
    Label getSuccessLabel() {
        return this.successLabel;
    }

    /**
     * @return Returns the failureLabel.
     */
    Label getFailureLabel() {
        return this.failureLabel;
    }

    /**
     * @return Returns the ratioLabel.
     */
    Label getRatioLabel() {
        return this.ratioLabel;
    }

}