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

import javafx.scene.layout.StackPane;

import org.jrebirth.af.core.command.basic.showmodel.DisplayModelWaveBean;
import org.jrebirth.af.core.command.basic.showmodel.ShowFadingModelCommand;
import org.jrebirth.af.core.key.UniqueKey;
import org.jrebirth.af.core.ui.Model;
import org.jrebirth.af.core.ui.annotation.RootNodeId;
import org.jrebirth.af.core.ui.simple.DefaultSimpleModel;
import org.jrebirth.af.core.wave.Wave;
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
@RootNodeId("PagePanel")
public class PageModel extends DefaultSimpleModel<StackPane> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PageModel.class);

    /** Hold the current mode displayed as a page. */
    private UniqueKey<? extends Model> currentModelKey;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {

        listen(MTWaves.SHOW_PAGE);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSimpleView() {
        super.initSimpleView();
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

        // Create the Wave Bean that will hold all data processed by chained
        // commands
        final DisplayModelWaveBean waveBean = DisplayModelWaveBean.create()
                // Define the placeholder that will receive the content
                .childrenPlaceHolder(getRootNode().getChildren())
                // Allow to add element behind the stack to allow transition
                .appendChild(false);

        switch (page) {

            case Splash:
                waveBean.showModelKey(UniqueKey.key(SplashModel.class));
                break;

            case Game:
                waveBean.showModelKey(UniqueKey.key(GameModel.class));
                break;

            case Result:
                waveBean.showModelKey(UniqueKey.key(ResultModel.class,
                        getModel(GameModel.class).getObject()));
                break;

            default:
            case GameMenu:
                waveBean.showModelKey(UniqueKey.key(GameMenuModel.class));
                break;
        }

        waveBean.hideModelKey(this.currentModelKey);

        this.currentModelKey = waveBean.showModelKey();
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
