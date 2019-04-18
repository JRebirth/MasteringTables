/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2017
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

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.api.ui.annotation.OnMouse;
import org.jrebirth.af.api.ui.annotation.RootNodeId;
import org.jrebirth.af.api.ui.annotation.type.Mouse;
import org.jrebirth.af.core.ui.DefaultView;
import org.jrebirth.demo.masteringtables.resources.MTColors;
import org.jrebirth.demo.masteringtables.resources.MTImages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ResultView.
 */
@RootNodeId("ResultPanel")
public class ResultView extends DefaultView<ResultModel, BorderPane, ResultController> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultView.class);

    /** The ratio label. */
    private Label ratioLabel;

    /** The time label. */
    private Label timeLabel;

    /** The success label. */
    private Label successLabel;

    /** The failure label. */
    private Label failureLabel;

    /** The monster image. */
    private ImageView monsterImage;

    /** The time bean. */
    private SVGPath timeBean;

    /** The success bean. */
    private SVGPath successBean;

    /** The failure bean. */
    private SVGPath failureBean;

    /** The ratio circle. */
    private Circle ratioCircle;

    /** The success icon. */
    private ImageView successIcon;

    /** The failure icon. */
    private ImageView failureIcon;

    /**
     * The print button allowing to capture a screenshot.
     */
    @OnMouse(value = Mouse.Clicked)
    private Button printResult;

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
    protected void initView() {

        node().setFocusTraversable(true);

        final String beanPath = "M264.489,353.896h0.152c-10.026-28-15.393-58.608-15.192-90.053c0.21-33.038,6.578-64.879,17.979-93.896"
                + "c-0.077,0.192-0.156,0.299-0.229,0.491c3.331-11.38,5.158-23.444,5.236-35.892C272.895,62.568,214.922,3.827,142.943,3.364"
                + "c-71.979-0.46-130.7,57.504-131.16,129.482c-0.081,12.446,1.591,24.485,4.778,35.907c-0.073-0.192-0.15-0.387-0.224-0.578"
                + "c11.027,29.158,16.985,61.041,16.776,94.078c-0.203,31.442-5.963,61.643-16.347,89.643h0.15c-4.319,13-6.706,26.28-6.799,40.542"
                + "C9.66,464.417,67.636,523.015,139.613,523.474c71.979,0.459,130.693-57.118,131.155-129.096"
                + "C270.861,380.109,268.652,365.896,264.489,353.896z";

        this.timeBean = new SVGPath();
        this.timeBean.setContent(beanPath);
        this.timeBean.setScaleX(1.0);
        this.timeBean.setScaleY(1.0);
        this.timeBean.setLayoutX(80);
        this.timeBean.setLayoutY(14);
        this.timeBean.setRotate(-34.0);
        this.timeBean.setFill(Color.LIGHTGREY);
        this.timeBean.setEffect(getDropShadow());

        this.successBean = new SVGPath();
        this.successBean.setContent(beanPath);
        this.successBean.setScaleX(0.84);
        this.successBean.setScaleY(0.84);
        this.successBean.setLayoutX(270);
        this.successBean.setLayoutY(80);
        this.successBean.setRotate(62.0);
        this.successBean.setFill(Color.LIGHTGREY);
        this.successBean.setEffect(getDropShadow());

        this.failureBean = new SVGPath();
        this.failureBean.setContent(beanPath);
        this.failureBean.setScaleX(0.73);
        this.failureBean.setScaleY(0.73);
        this.failureBean.setLayoutX(460);
        this.failureBean.setLayoutY(85);
        this.failureBean.setRotate(-58);
        this.failureBean.setFill(Color.LIGHTGREY);
        this.failureBean.setEffect(getDropShadow());

        this.ratioCircle = new Circle();
        this.ratioCircle.setFill(Color.LIGHTGREY);
        this.ratioCircle.setRadius(150);
        this.ratioCircle.setLayoutX(154);
        this.ratioCircle.setLayoutY(154);
        this.ratioCircle.setEffect(getDropShadow());

        // Image

        this.successIcon = new ImageView(MTImages.RESULT_SUCCESS_ICON.get());
        this.successIcon.setLayoutX(495);
        this.successIcon.setLayoutY(195);
        this.successIcon.setOpacity(0);

        this.failureIcon = new ImageView(MTImages.RESULT_FAILURE_ICON.get());
        this.failureIcon.setLayoutX(666);
        this.failureIcon.setLayoutY(320);
        this.failureIcon.setOpacity(0);

        this.monsterImage = new ImageView(MTImages.RESULT_MONSTER.get());
        this.monsterImage.setScaleX(0.9);
        this.monsterImage.setScaleY(0.9);
        this.monsterImage.setLayoutX(410);
        this.monsterImage.setLayoutY(1200);

        this.ratioLabel = new Label();
        this.ratioLabel.setId("ResultRatioLabel");
        this.ratioLabel.setLayoutX(28);
        this.ratioLabel.setLayoutY(80);
        this.ratioLabel.setScaleX(0);
        this.ratioLabel.setScaleY(0);

        this.timeLabel = new Label();
        this.timeLabel.setId("ResultTimeLabel");
        this.timeLabel.setLayoutX(170);
        this.timeLabel.setLayoutY(330);
        this.timeLabel.setScaleX(0);
        this.timeLabel.setScaleY(0);

        this.successLabel = new Label();
        this.successLabel.setId("ResultSuccessLabel");
        this.successLabel.setLayoutX(444);
        this.successLabel.setLayoutY(255);
        this.successLabel.setScaleX(0);
        this.successLabel.setScaleY(0);

        this.failureLabel = new Label();
        this.failureLabel.setId("ResultFailureLabel");
        this.failureLabel.setLayoutX(645);
        this.failureLabel.setLayoutY(390);
        this.failureLabel.setScaleX(0);
        this.failureLabel.setScaleY(0);

        printResult = new Button("Print Results");
        printResult.setLayoutX(40);
        printResult.setLayoutY(540);

        final Pane p = new Pane();

        p.setPrefHeight(600);
        p.setPrefWidth(800);
        p.setMinHeight(600);
        p.setMinWidth(800);
        p.getChildren().addAll(this.failureBean, this.successBean, this.timeBean, this.ratioCircle, this.monsterImage, this.successIcon, this.failureIcon, this.timeLabel,
                               this.successLabel,
                               this.failureLabel,
                               this.ratioLabel,
                               this.printResult);

        node().setCenter(p);

    }

    /**
     * Build the drop shadow.
     *
     * @return the drop shadow effect
     */
    private Effect getDropShadow() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(0);
        ds.setOffsetY(5);
        ds.setColor(MTColors.BEAN_SHADOW.get());
        ds.setBlurType(BlurType.GAUSSIAN);
        ds.setRadius(5);
        ds.setSpread(0.1);
        return ds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {

        TranslateTransition tt = new TranslateTransition();
        tt.setNode(this.monsterImage);
        tt.setDelay(Duration.millis(500));
        tt.setDuration(Duration.millis(400));
        tt.setByY(-766);

        FadeTransition ft = new FadeTransition();
        ft.setNode(this.successIcon);
        ft.setDuration(Duration.millis(500));
        ft.setFromValue(0);
        ft.setToValue(1);

        ParallelTransition pt1 = new ParallelTransition();
        pt1.getChildren().addAll(
                                 tt,
                                 buildBeanAnimation(this.successLabel, this.successBean, MTColors.RESULT_SUCCESS.get()),
                                 ft);

        FadeTransition ft0 = new FadeTransition();
        ft0.setNode(this.failureIcon);
        ft0.setDuration(Duration.millis(500));
        ft0.setFromValue(0);
        ft0.setToValue(1);

        ParallelTransition pt2 = new ParallelTransition();
        pt2.getChildren().addAll(
                                 buildBeanAnimation(this.failureLabel, this.failureBean, MTColors.RESULT_FAILURE.get()),
                                 ft0);

        SequentialTransition st = new SequentialTransition();
        st.getChildren().addAll(

                                buildBeanAnimation(this.ratioLabel, this.ratioCircle, MTColors.RESULT_RATIO.get()),
                                buildBeanAnimation(this.timeLabel, this.timeBean, MTColors.RESULT_TIME.get()),
                                pt1, pt2);

        st.playFromStart();

    }

    /**
     * Build a bean animation.
     *
     * @param label the attached label
     * @param shape the shape to show
     * @param fillColor the color to use to paint the shape
     *
     * @return the bean animation
     */
    private Animation buildBeanAnimation(final Label label, final Shape shape, final Color fillColor) {
        ScaleTransition st = new ScaleTransition();
        st.setNode(label);
        st.setDelay(Duration.millis(50));
        st.setDuration(Duration.millis(300));

        st.setFromX(0);
        st.setFromY(0);
        st.setToX(1);
        st.setToY(1);

        FillTransition ft = new FillTransition();
        ft.setShape(shape);
        ft.setFromValue(Color.LIGHTGREY);
        ft.setToValue(fillColor);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(
                                st,
                                ft);
        return pt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        this.ratioCircle.setFill(Color.LIGHTGRAY);
        this.timeBean.setFill(Color.LIGHTGRAY);
        this.successBean.setFill(Color.LIGHTGRAY);
        this.failureBean.setFill(Color.LIGHTGRAY);

        this.ratioLabel.setScaleX(0);
        this.timeLabel.setScaleX(0);
        this.successLabel.setScaleX(0);
        this.failureLabel.setScaleX(0);

        this.ratioLabel.setScaleY(0);
        this.timeLabel.setScaleY(0);
        this.successLabel.setScaleY(0);
        this.failureLabel.setScaleY(0);

        this.monsterImage.setTranslateY(0);

        this.failureIcon.setOpacity(0);
        this.successIcon.setOpacity(0);
    }

    /**
     * Gets the time label.
     *
     * @return Returns the timeLabel.
     */
    Label getTimeLabel() {
        return this.timeLabel;
    }

    /**
     * Gets the success label.
     *
     * @return Returns the successLabel.
     */
    Label getSuccessLabel() {
        return this.successLabel;
    }

    /**
     * Gets the failure label.
     *
     * @return Returns the failureLabel.
     */
    Label getFailureLabel() {
        return this.failureLabel;
    }

    /**
     * Gets the ratio label.
     *
     * @return Returns the ratioLabel.
     */
    Label getRatioLabel() {
        return this.ratioLabel;
    }

}
