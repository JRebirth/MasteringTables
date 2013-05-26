package org.jrebirth.demo.masteringtables.ui.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Skin;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import com.sun.javafx.scene.control.skin.ToggleButtonSkin;

public class ArcadeButtonSkin extends ToggleButtonSkin implements Skin<ToggleButton> {

    /*
     * 
     * 
     * <Circle blendMode="SRC_OVER" fill="linear-gradient(from 100.0% 100.0% to 100.0% 0.0%, 0xf0f0f0ff 0.0%, 0xdcdad5ff 45.0%, 0xaba596ff 100.0%)" layoutX="286.0" layoutY="201.0" opacity="1.0"
     * radius="73.0" smooth="true" stroke="#ffffff4d" strokeLineJoin="ROUND" strokeType="OUTSIDE" /> <Text fill="#66ffed" layoutX="281.0" layoutY="202.0" opacity="1.0" scaleX="5.381859890594671"
     * scaleY="6.136808614782183" smooth="true" strikethrough="false" stroke="#ffffff00" strokeType="CENTERED" strokeWidth="0.0" text="X" textAlignment="CENTER" textOrigin="CENTER" underline="false">
     * <effect> <Lighting specularConstant="0.3476190476190476" specularExponent="9.523809523809524" surfaceScale="0.3888888888888889"> <bumpInput> <Shadow /> </bumpInput> <contentInput> <DropShadow
     * color="WHITE" offsetY="1.0"> <input> <InnerShadow blurType="TWO_PASS_BOX" color="#000000e5" height="3.0" offsetY="1.0" radius="1.5" width="5.0" /> </input> </DropShadow> </contentInput> <light>
     * <javafx.scene.effect.Light.Spot color="#66edff" pointsAtZ="-40.0" x="100.0" y="100.0" z="100.0" /> </light> </Lighting> </effect> <font> <Font name="Gorgonzolla" size="17.0" /> </font> </Text>
     */
    public ArcadeButtonSkin(ToggleButton toggleButton) {
        super(toggleButton);

        // <Cirucle blendMode="MULTIPLY" disable="false" fill="BLACK" layoutX="285.0" layoutY="200.0" radius="100.0"
        // stroke="linear-gradient(from 0.0% 0.0% to 100.0% 100.0%, 0xaca79bff 0.0%, 0xfdfcfbff 100.0%)" strokeLineCap="ROUND" strokeLineJoin="BEVEL" strokeType="INSIDE" strokeWidth="17.0" />
        Circle circle1 = CircleBuilder.create()
                .blendMode(BlendMode.MULTIPLY)
                .disable(false)
                .fill(Color.BLACK)
                // .radius(100)
                .stroke(new LinearGradient(0, 0, 100, 100, true, CycleMethod.NO_CYCLE, Arrays.asList(new Stop(0, Color.web("0xaca79b")), new Stop(100, Color.web("0xfdfcfb")))))
                .strokeLineCap(StrokeLineCap.ROUND)
                .strokeLineJoin(StrokeLineJoin.BEVEL)
                .strokeType(StrokeType.INSIDE)
                // .strokeWidth(17.0)
                .build();

        circle1.layoutXProperty().bind(toggleButton.widthProperty().divide(2));
        circle1.layoutYProperty().bind(toggleButton.widthProperty().divide(2));
        circle1.radiusProperty().bind(toggleButton.widthProperty().divide(2));
        circle1.strokeWidthProperty().bind(toggleButton.widthProperty().divide(10));

        // <Circle fill="#877e7e" layoutX="285.0" layoutY="200.0" radius="83.0" stroke="TRANSPARENT" strokeType="INSIDE">
        // <effect> <InnerShadow height="65.08333333333334" radius="30.270833333333336"
        // * width="58.0" /> </effect> </Circle>
        Circle circle2 = CircleBuilder.create()
                .fill(Color.web("#877e7e"))
                .stroke(Color.TRANSPARENT)
                .strokeType(StrokeType.INSIDE)
                .effect(InnerShadowBuilder.create()
                        .height(65)
                        .width(58)
                        .radius(30)
                        .build())
                .build();

        circle2.layoutXProperty().bind(toggleButton.widthProperty().divide(2));
        circle2.layoutYProperty().bind(toggleButton.widthProperty().divide(2));
        circle2.radiusProperty().bind(toggleButton.widthProperty().divide(2.2));

        // <Circle fill="BLACK" layoutX="285.0" layoutY="200.0" radius="83.0" stroke="linear-gradient(from 0.0% 0.0% to 100.0% 100.0%, 0x373535ff 0.0%, 0x9b9b9bff 100.0%)" strokeType="INSIDE" />

        Circle circle3 = CircleBuilder.create()
                .fill(Color.BLACK)

                .build();

        // <Circle
        // * fill="linear-gradient(from 0.0% 0.0% to 0.0% 100.0%, 0xf2f2f2ff 0.0%, 0xc1c2baff 50.0%, 0x9d9d9aff 100.0%)" layoutX="285.0" layoutY="200.0" radius="83.0" stroke="TRANSPARENT"
        // * strokeType="INSIDE"> <effect> <DropShadow blurType="ONE_PASS_BOX" color="#000000cc" height="45.19047619047619" offsetY="4.0" radius="22.095238095238095" width="45.19047619047619" />
        // </effect>
        // * </Circle>
        Circle circle4 = CircleBuilder.create().build();
        Circle circle5 = CircleBuilder.create().build();

        List<Circle> circles = new ArrayList<>();
        circles.add(circle1);
        circles.add(circle2);
        circles.add(circle3);
        circles.add(circle4);
        circles.add(circle5);

        getChildren().addAll(0, circles);

    }
}
