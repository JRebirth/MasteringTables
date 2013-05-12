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

/**
 * @author
 */
public class GameView extends AbstractView<GameModel, BorderPane, GameController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameView.class);

    private StackPane questionHolder;

    private Label successLabel;

    private Label failureLabel;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
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
     * @return Returns the questionHolder.
     */
    StackPane getQuestionHolder() {
        return this.questionHolder;
    }

    private Node buildTopPanel() {
        final AnchorPane ap = new AnchorPane();

        final StackPane successPane = new StackPane();

        this.successLabel = LabelBuilder.create().font(MTFonts.SPLASH.get()).build();

        successPane.getChildren().addAll(this.successLabel);

        final StackPane failurePane = new StackPane();
        this.failureLabel = LabelBuilder.create().font(MTFonts.SPLASH.get()).build();
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

}