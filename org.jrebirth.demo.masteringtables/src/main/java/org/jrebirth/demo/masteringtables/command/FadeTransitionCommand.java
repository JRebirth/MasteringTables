package org.jrebirth.demo.masteringtables.command;

import javafx.animation.Animation;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.ParallelTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

import org.jrebirth.core.command.AbstractSingleCommand;
import org.jrebirth.core.command.basic.DisplayModelWaveBean;
import org.jrebirth.core.concurrent.RunInto;
import org.jrebirth.core.concurrent.RunType;
import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.wave.Wave;

@RunInto(RunType.JAT)
public class FadeTransitionCommand extends AbstractSingleCommand<DisplayModelWaveBean> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute(final Wave wave) {

        final Node oldNode = getWaveBean(wave).getChidrenPlaceHolder().get(getWaveBean(wave).getChidrenPlaceHolder().size() - 1);

        Node newNode = getWaveBean(wave).getCreatedNode();

        if (oldNode != null && newNode != null) {
            Animation animation = ParallelTransitionBuilder.create()
                    .children(
                            FadeTransitionBuilder.create()
                                    .duration(Duration.millis(600))
                                    .node(oldNode)
                                    .fromValue(1.0)
                                    .toValue(0.0)
                                    .build(),
                            FadeTransitionBuilder.create()
                                    .duration(Duration.millis(600))
                                    .node(newNode)
                                    .fromValue(0.0)
                                    .toValue(1.0)
                                    .build()

                    )
                    .build();

            animation.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    getWaveBean(wave).getChidrenPlaceHolder().remove(oldNode);

                    System.out.println("Stack child size" + getWaveBean(wave).getChidrenPlaceHolder().size());
                }
            });

            animation.playFromStart();
        }
    }

    @Override
    public void ready() throws CoreException {
        // Nothing to do yet

    }

}
