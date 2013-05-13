package org.jrebirth.demo.masteringtables.ui.start;

import javafx.geometry.Pos;
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
    }

    private Node buildStartGamePanel() {
        FlowPane fp = new FlowPane();

        start = ButtonBuilder.create()
                .text("Start Game")
                .build();

        fp.getChildren().add(start);
        fp.setAlignment(Pos.TOP_CENTER);

        return fp;
    }

    private Node buildGameConfigPanel() {

        GridPane pane = new GridPane();

        addition = ToggleButtonBuilder.create()
                .text(Operator.addition.toString())
                .build();
        subtraction = ToggleButtonBuilder.create()
                .text(Operator.subtraction.toString())
                .build();
        multiplication = ToggleButtonBuilder.create()
                .text(Operator.multiplication.toString())
                .build();
        division = ToggleButtonBuilder.create()
                .text(Operator.division.toString())
                .build();

        GridPane.setConstraints(addition, 1, 1);
        GridPane.setConstraints(subtraction, 2, 1);
        GridPane.setConstraints(multiplication, 1, 2);
        GridPane.setConstraints(division, 2, 2);

        pane.getChildren().addAll(addition, subtraction, multiplication, division);
        pane.setAlignment(Pos.CENTER);

        return pane;
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