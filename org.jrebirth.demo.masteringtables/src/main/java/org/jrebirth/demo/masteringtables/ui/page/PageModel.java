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
package org.jrebirth.demo.masteringtables.ui.page;

import org.jrebirth.core.command.basic.showmodel.DisplayModelWaveBean;
import org.jrebirth.core.command.basic.showmodel.ShowFadingModelCommand;
import org.jrebirth.core.ui.DefaultModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.game.GameModel;
import org.jrebirth.demo.masteringtables.ui.menu.GameMenuModel;
import org.jrebirth.demo.masteringtables.ui.result.ResultModel;
import org.jrebirth.demo.masteringtables.ui.splash.SplashModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PageModel.
 */
public class PageModel extends DefaultModel<PageModel, PageView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageModel.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {

        listen(MTWaves.SHOW_PAGE);
    }

    /**
     * Show page.
     * 
     * Called when model received a SHOW_PAGE wave type.
     * 
     * @param page the page
     * @param wave the wave
     */
    public void doShowPage(final Page page, final Wave wave) {

        LOGGER.info("Show Page: " + page.toString());

        // Create the Wave Bean that will hold all data processed by chained commands
        final DisplayModelWaveBean waveBean = new DisplayModelWaveBean();
        // Define the placeholder that will receive the content
        waveBean.setChidrenPlaceHolder(getView().getRootNode().getChildren());
        // Allow to add element behin the stack to allow transition
        waveBean.setAppendChild(false);

        switch (page) {

            case Splash:
                waveBean.setModelClass(SplashModel.class);
                break;

            case Game:
                waveBean.setModelClass(GameModel.class);
                break;

            case Result:
                waveBean.setModelClass(ResultModel.class);
                break;

            default:
            case GameMenu:
                waveBean.setModelClass(GameMenuModel.class);
                break;
        }

        callCommand(ShowFadingModelCommand.class, waveBean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void showView() {
        // On redisplay show the start page
        doShowPage(Page.Splash, null);
    }

}
