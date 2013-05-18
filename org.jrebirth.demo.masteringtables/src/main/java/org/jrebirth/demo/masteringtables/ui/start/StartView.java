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
package org.jrebirth.demo.masteringtables.ui.start;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleButtonBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.core.ui.annotation.OnAction;
import org.jrebirth.demo.masteringtables.beans.Operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class StartView.
 */
public class StartView extends AbstractView<StartModel, BorderPane, StartController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartView.class);

    /** The addition. */
    private ToggleButton addition;

    /** The subtraction. */
    private ToggleButton subtraction;

    /** The multiplication. */
    private ToggleButton multiplication;

    /** The division. */
    private ToggleButton division;

    /** The start. */
    @OnAction(name = "Start")
    private Button start;

    /**
     * Instantiates a new start view.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
    public StartView(final StartModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        final FlowPane fp = FlowPaneBuilder.create()
                .children(new ImageView(loadImage("image/Mastering_Tables_Header.png")))
                .build();
        fp.setAlignment(Pos.CENTER);
        getRootNode().setTop(fp);

        getRootNode().setCenter(buildGameConfigPanel());

        getRootNode().setBottom(buildStartGamePanel());

        final BooleanBinding bb1 = Bindings.or(this.addition.selectedProperty(), this.subtraction.selectedProperty());
        final BooleanBinding bb2 = Bindings.or(this.multiplication.selectedProperty(), this.division.selectedProperty());
        final BooleanBinding bb = Bindings.or(bb1, bb2);

        this.start.disableProperty().bind(bb.not());
    }

    /**
     * Builds the start game panel.
     * 
     * @return the node
     */
    private Node buildStartGamePanel() {
        final FlowPane fp = new FlowPane();

        this.start = ButtonBuilder.create()
                .styleClass("StartButton")
                .text("Start Game")
                .build();

        fp.getChildren().add(this.start);
        fp.setAlignment(Pos.TOP_CENTER);

        return fp;
    }

    /**
     * Builds the game config panel.
     * 
     * @return the node
     */
    private Node buildGameConfigPanel() {

        final GridPane pane = GridPaneBuilder.create()
                .hgap(10)
                .vgap(10)
                .build();

        this.addition = buildChoiceButton(Operator.addition.toString());
        this.subtraction = buildChoiceButton(Operator.subtraction.toString());
        this.multiplication = buildChoiceButton(Operator.multiplication.toString());
        this.division = buildChoiceButton(Operator.division.toString());

        GridPane.setConstraints(this.addition, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(this.subtraction, 2, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(this.multiplication, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(this.division, 2, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        pane.getChildren().addAll(this.addition, this.subtraction, this.multiplication, this.division);
        pane.setAlignment(Pos.CENTER);

        // Bound widget to properties
        getModel().getGameSettings().containsAdditionProperty().bind(this.addition.selectedProperty());
        getModel().getGameSettings().containsSubtractionProperty().bind(this.subtraction.selectedProperty());
        getModel().getGameSettings().containsMultiplicationProperty().bind(this.multiplication.selectedProperty());
        getModel().getGameSettings().containsDivisionProperty().bind(this.division.selectedProperty());

        return pane;
    }

    /**
     * Builds the choice button.
     * 
     * @param name the name
     * @return the toggle button
     */
    private ToggleButton buildChoiceButton(final String name) {
        return ToggleButtonBuilder.create()
                .styleClass("ChoiceButton", "toggle-button")
                .minWidth(100)
                .minHeight(100)
                .maxWidth(100)
                .maxHeight(100)
                .text(name)
                .build();

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

}
