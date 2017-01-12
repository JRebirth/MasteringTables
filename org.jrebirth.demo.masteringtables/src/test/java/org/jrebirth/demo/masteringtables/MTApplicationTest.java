package org.jrebirth.demo.masteringtables;

import java.util.concurrent.TimeUnit;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import org.jrebirth.af.api.facade.LocalFacade;
import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.core.application.JRebirthApplicationTest;
import org.jrebirth.af.core.concurrent.JRebirthThread;
import org.jrebirth.demo.masteringtables.ui.expression.ExpressionModel;
import org.jrebirth.demo.masteringtables.ui.menu.GameMenuModel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

/**
 * The class <strong>StageTest</strong>.
 *
 * @author Sébastien Bordes
 */
public class MTApplicationTest extends JRebirthApplicationTest<MTApplication> {

    public MTApplicationTest() {
        super(MTApplication.class);
    }

    @BeforeClass
    public static void startUp() throws Exception {
        ApplicationTest.launch(MTApplication.class);
    }

    @Test
    public void checkFullConf() {

        final MTApplication app = application;

        sleep(5, TimeUnit.SECONDS);

        final LocalFacade<Model> uF = JRebirthThread.getThread().getFacade().uiFacade();

        final GameMenuModel gmm = uF.retrieve(GameMenuModel.class);

        // while(!app.rootNode().getChildren().contains(gmm.node())){
        // sleep(500);
        // }

        clickOn("#addButton", MouseButton.PRIMARY);
        clickOn("#multiplyButton", MouseButton.PRIMARY);

        clickOn("#playButton");// , MouseButton.PRIMARY);

        sleep(2, TimeUnit.SECONDS);

        final ExpressionModel em = uF.retrieve(ExpressionModel.class);

        for (int i = 0; i < 5; i++) {
            final int result = em.object().result();
            if (result / 100 > 0) {
                type(intToKey(result / 100));
            }
            if (result % 100 / 10 > 0) {
                type(intToKey(result % 100 / 10));
            }
            if (result % 10 > 0) {
                type(intToKey(result % 10));
            }
            sleep(2, TimeUnit.SECONDS);

        }

        sleep(5, TimeUnit.SECONDS);

        clickOn(MouseButton.PRIMARY);
        sleep(5, TimeUnit.SECONDS);

    }

    private KeyCode intToKey(int i) {
        switch (i) {
            case 0:
                return KeyCode.DIGIT0;
            case 1:
                return KeyCode.DIGIT1;
            case 2:
                return KeyCode.DIGIT2;
            case 3:
                return KeyCode.DIGIT3;
            case 4:
                return KeyCode.DIGIT4;
            case 5:
                return KeyCode.DIGIT5;
            case 6:
                return KeyCode.DIGIT6;
            case 7:
                return KeyCode.DIGIT7;
            case 8:
                return KeyCode.DIGIT8;
            case 9:
                return KeyCode.DIGIT9;
        }
        return null;
    }

}
