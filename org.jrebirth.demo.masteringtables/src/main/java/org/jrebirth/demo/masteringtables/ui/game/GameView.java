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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.demo.masteringtables.resources.MTFonts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameView.
 */
public class GameView extends AbstractView<GameModel, BorderPane, GameController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameView.class);

    /** The question holder. */
    private StackPane questionHolder;

    /** The success label. */
    private Label successIcon;

    /** The success text counter. */
    private Label successCounter;

    /** The failure label. */
    private Label failureIcon;

    /** The failure text counter. */
    private Label failureCounter;

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

        // Success Part

        this.successCounter = LabelBuilder.create()
                .id("SuccessCounter")
                .font(MTFonts.COUNTER.get())
                .minWidth(100)
                .alignment(Pos.CENTER_RIGHT)
                // .style("-fx-background-color:#CCC")
                .build();

        this.successIcon = LabelBuilder.create()
                .id("SuccessIcon")
                // .style("-fx-background-color:#233")
                .build();

        StackPane.setMargin(successIcon, new Insets(0, 0, 12, 92));
        StackPane.setAlignment(successIcon, Pos.TOP_RIGHT);

        StackPane.setAlignment(successCounter, Pos.BOTTOM_LEFT);

        final StackPane successPane = StackPaneBuilder.create()
                .children(this.successIcon, this.successCounter)
                // .style("-fx-background-color:#CCC")
                .build();

        // Failure Part

        this.failureCounter = LabelBuilder.create()
                .id("FailureCounter")
                .font(MTFonts.COUNTER.get())
                .minWidth(100)
                .alignment(Pos.CENTER_RIGHT)
                .build();

        this.failureIcon = LabelBuilder.create()
                .id("FailureIcon")
                .build();

        StackPane.setMargin(failureIcon, new Insets(0, 0, 12, 92));
        StackPane.setAlignment(failureIcon, Pos.TOP_RIGHT);

        StackPane.setAlignment(failureCounter, Pos.BOTTOM_LEFT);

        final StackPane failurePane = StackPaneBuilder.create()
                .children(this.failureIcon, this.failureCounter)
                .build();

        // Add Part to the view root node

        AnchorPane.setTopAnchor(failurePane, 10.0);
        AnchorPane.setRightAnchor(failurePane, 20.0);

        AnchorPane.setTopAnchor(successPane, 10.0);
        AnchorPane.setRightAnchor(successPane, 200.0);

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
     * Gets the success counter.
     * 
     * @return the success counter
     */
    Label getSuccessCounter() {
        return this.successCounter;
    }

    /**
     * Gets the failure counter.
     * 
     * @return the failure counter
     */
    Label getFailureCounter() {
        return this.failureCounter;
    }

}