package org.jrebirth.demo.masteringtables.ui;

import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveType;
import org.jrebirth.core.wave.WaveTypeBase;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.ui.page.Page;

/**
 * The class <strong>JRebirthWaveItem</strong>.
 * 
 * @author Sébastien Bordes
 */
public interface MTWaves {

    /******************************/
    /** WaveItem */
    /******************************/

    WaveItem<Expression> EXPRESSION = new WaveItem<Expression>() {
    };

    WaveItem<Page> PAGE = new WaveItem<Page>() {
    };

    /******************************/
    /** WaveType related to Model */
    /******************************/

    WaveType SHOW_PAGE = WaveTypeBase.build("SHOW_PAGE", PAGE);

    WaveType START_GAME = WaveTypeBase.build("START_GAME");
    WaveType FINISH_GAME = WaveTypeBase.build("FINISH_GAME");

    WaveType DISPLAY_EXPRESSION = WaveTypeBase.build("DISPLAY_EXPRESSION", EXPRESSION);

    WaveType REGISTER_SUCCESS = WaveTypeBase.build("REGISTER_SUCCESS", EXPRESSION);
    WaveType REGISTER_FAILURE = WaveTypeBase.build("REGISTER_FAILURE", EXPRESSION);
}
