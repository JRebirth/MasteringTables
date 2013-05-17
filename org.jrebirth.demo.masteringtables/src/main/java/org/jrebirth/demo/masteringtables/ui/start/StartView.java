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

/**
 * @author
 */
public class StartView extends AbstractView<StartModel, BorderPane, StartController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartView.class);

    private ToggleButton addition;
    private ToggleButton subtraction;
    private ToggleButton multiplication;
    private ToggleButton division;

    @OnAction(name = "Start")
    private Button start;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public StartView(final StartModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        FlowPane fp = FlowPaneBuilder.create()
                .children(new ImageView(loadImage("image/Mastering_Tables_Header.png")))
                .build();
        fp.setAlignment(Pos.CENTER);
        getRootNode().setTop(fp);

        getRootNode().setCenter(buildGameConfigPanel());

        getRootNode().setBottom(buildStartGamePanel());

        BooleanBinding bb1 = Bindings.or(addition.selectedProperty(), subtraction.selectedProperty());
        BooleanBinding bb2 = Bindings.or(multiplication.selectedProperty(), division.selectedProperty());
        BooleanBinding bb = Bindings.or(bb1, bb2);

        start.disableProperty().bind(bb.not());
    }

    private Node buildStartGamePanel() {
        FlowPane fp = new FlowPane();

        start = ButtonBuilder.create()
                .styleClass("StartButton")
                .text("Start Game")
                .build();

        fp.getChildren().add(start);
        fp.setAlignment(Pos.TOP_CENTER);

        return fp;
    }

    private Node buildGameConfigPanel() {

        GridPane pane = GridPaneBuilder.create()
                .hgap(10)
                .vgap(10)
                .build();

        addition = buildChoiceButton(Operator.addition.toString());
        subtraction = buildChoiceButton(Operator.subtraction.toString());
        multiplication = buildChoiceButton(Operator.multiplication.toString());
        division = buildChoiceButton(Operator.division.toString());

        GridPane.setConstraints(addition, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(subtraction, 2, 1, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(multiplication, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(division, 2, 2, 1, 1, HPos.CENTER, VPos.CENTER);

        pane.getChildren().addAll(addition, subtraction, multiplication, division);
        pane.setAlignment(Pos.CENTER);

        // Bound widget to properties
        getModel().getGameSettings().containsAdditionProperty().bind(addition.selectedProperty());
        getModel().getGameSettings().containsSubtractionProperty().bind(subtraction.selectedProperty());
        getModel().getGameSettings().containsMultiplicationProperty().bind(multiplication.selectedProperty());
        getModel().getGameSettings().containsDivisionProperty().bind(division.selectedProperty());

        return pane;
    }

    /**
     * TODO To complete.
     * 
     * @return
     */
    private ToggleButton buildChoiceButton(String name) {
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