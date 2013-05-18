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

import java.util.List;

import org.jrebirth.core.command.basic.DisplayModelWaveBean;
import org.jrebirth.core.command.basic.ShowModelCommand;
import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.command.StartGameCommand;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.service.SessionService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.game.GameModel;
import org.jrebirth.demo.masteringtables.ui.start.StartModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PageModel.
 */
public class PageModel extends AbstractModel<PageModel, PageView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageModel.class);

    /** The session service. */
    private SessionService sessionService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        listen(ExpressionBuilderService.RE_TABLES_BUILT);
        listen(MTWaves.SHOW_PAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeInnerModels() {

    }

    /**
     * Tables built.
     * 
     * @param allTables the all tables
     * @param wave the wave
     */
    public void tablesBuilt(final List<Expression> allTables, final Wave wave) {

        showPage(Page.StartMenu, null);

    }

    /**
     * Show page.
     * 
     * @param page the page
     * @param wave the wave
     */
    public void showPage(final Page page, final Wave wave) {

        final DisplayModelWaveBean waveBean = new DisplayModelWaveBean();
        waveBean.setUniquePlaceHolder(getView().getRootNode().centerProperty());

        switch (page) {
            case Game:
                waveBean.setModelClass(GameModel.class);
                callCommand(StartGameCommand.class, waveBean);
                break;
            case ShowResult:
                waveBean.setModelClass(GameModel.class);
                callCommand(ShowModelCommand.class, waveBean);
                break;
            default:
            case StartMenu:
                waveBean.setModelClass(StartModel.class);
                callCommand(ShowModelCommand.class, waveBean);
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processAction(final Wave wave) {
        // Nothing to do yet

    }
}
