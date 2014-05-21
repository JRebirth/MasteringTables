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

import org.jrebirth.af.core.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultView;
import org.jrebirth.af.core.ui.annotation.RootNodeId;
import org.jrebirth.demo.masteringtables.resources.MTFonts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameView.
 */
@RootNodeId("GamePanel")
public class GameView extends DefaultView<GameModel, BorderPane, GameController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameView.class);

    /** The expression holder. */
    private StackPane expressionHolder;

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
     *
     * @throws CoreException the core exception
     */
    public GameView(final GameModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        getRootNode().setTop(buildTopPanel());

        // This stackPane will hold the expression view
        this.expressionHolder = new StackPane();
        getRootNode().setCenter(this.expressionHolder);

        getRootNode().setFocusTraversable(true);

    }

    /**
     * Gets the expression holder.
     *
     * @return the expression holder
     */
    StackPane getExpressionHolder() {
        return this.expressionHolder;
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
                .build();

        this.successIcon = LabelBuilder.create()
                .id("SuccessIcon")
                .build();

        StackPane.setMargin(this.successIcon, new Insets(0, 0, 12, 92));
        StackPane.setAlignment(this.successIcon, Pos.TOP_RIGHT);

        StackPane.setAlignment(this.successCounter, Pos.BOTTOM_LEFT);

        final StackPane successPane = StackPaneBuilder.create()
                .children(this.successIcon, this.successCounter)
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

        StackPane.setMargin(this.failureIcon, new Insets(0, 0, 12, 92));
        StackPane.setAlignment(this.failureIcon, Pos.TOP_RIGHT);

        StackPane.setAlignment(this.failureCounter, Pos.BOTTOM_LEFT);

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