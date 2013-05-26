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
package org.jrebirth.demo.masteringtables.ui.game;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.demo.masteringtables.resources.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GameView.
 */
public class GameView extends AbstractView<GameModel, BorderPane, GameController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameView.class);

    /** The question holder. */
    private StackPane questionHolder;

    /** The success label. */
    private Label successLabel;

    /** The failure label. */
    private Label failureLabel;

    /**
     * Instantiates a new game view.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
    public GameView(final GameModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {
        getRootNode().setTop(buildTopPanel());

        this.questionHolder = new StackPane();
        getRootNode().setCenter(this.questionHolder);

        getRootNode().setFocusTraversable(true);
    }

    /**
     * Gets the question holder.
     * 
     * @return the question holder
     */
    StackPane getQuestionHolder() {
        return this.questionHolder;
    }

    /**
     * Builds the top panel.
     * 
     * @return the node
     */
    private Node buildTopPanel() {
        final AnchorPane ap = new AnchorPane();

        final StackPane successPane = new StackPane();

        this.successLabel = LabelBuilder.create().font(MTFonts.COUNTER.get()).build();

        successPane.getChildren().addAll(this.successLabel);

        final StackPane failurePane = new StackPane();
        this.failureLabel = LabelBuilder.create().font(MTFonts.COUNTER.get()).build();
        failurePane.getChildren().addAll(this.failureLabel);

        AnchorPane.setRightAnchor(failurePane, 20.0);
        AnchorPane.setRightAnchor(successPane, 60.0);

        ap.getChildren().addAll(successPane, failurePane);

        return ap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Custom code to process when the view is displayed the 1+n time
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Custom code to process when the view is hidden
    }

    /**
     * Gets the success label.
     * 
     * @return the success label
     */
    Label getSuccessLabel() {
        return this.successLabel;
    }

    /**
     * Gets the failure label.
     * 
     * @return the failure label
     */
    Label getFailureLabel() {
        return this.failureLabel;
    }

}