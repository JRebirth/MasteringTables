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
package org.jrebirth.demo.masteringtables.ui;

import java.util.List;

import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveType;
import org.jrebirth.core.wave.WaveTypeBase;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Page;

/**
 * The Interface MTWaves that store all Wave Items and Wave Types used for asynchronous messaging.
 */
public interface MTWaves {

    /******************************/
    /** WaveItem */
    /******************************/

    /** The expression to ask to user. */
    WaveItem<Expression> EXPRESSION = new WaveItem<Expression>() {
    };

    /** The game list. */
    WaveItem<List<Expression>> GAME_LIST = new WaveItem<List<Expression>>() {
    };

    /** The page to display. */
    WaveItem<Page> PAGE = new WaveItem<Page>() {
    };

    /******************************/
    /** WaveType related to Model */
    /******************************/

    /** Show Page action. */
    WaveType SHOW_PAGE = WaveTypeBase.build("SHOW_PAGE", PAGE);

    /** The Start Game action code. */
    String START_GAME_CODE = "START_GAME";

    /** Start game action. */
    WaveType START_GAME = WaveTypeBase.build(START_GAME_CODE, GAME_LIST);

    /** Finish game action. */
    WaveType FINISH_GAME = WaveTypeBase.build("FINISH_GAME");

    /** Display expression action. */
    WaveType DISPLAY_EXPRESSION = WaveTypeBase.build("DISPLAY_EXPRESSION", EXPRESSION);

    /** Register expression success action. */
    WaveType REGISTER_SUCCESS = WaveTypeBase.build("REGISTER_SUCCESS", EXPRESSION);

    /** Register expression failure action. */
    WaveType REGISTER_FAILURE = WaveTypeBase.build("REGISTER_FAILURE", EXPRESSION);
}
