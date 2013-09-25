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
package org.jrebirth.demo.masteringtables.ui.splash;

import org.jrebirth.core.ui.DefaultModel;
import org.jrebirth.core.wave.JRebirthWaves;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.command.DisplayGameMenu;

/**
 * The Class SplashModel.
 */
public class SplashModel extends DefaultModel<SplashModel, SplashView> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void showView() {
        // Wait 3s and display the game menu
        callCommand(DisplayGameMenu.class, WaveData.build(JRebirthWaves.PROGRESS_BAR, getView().getLoadingBar()));
    }

}
