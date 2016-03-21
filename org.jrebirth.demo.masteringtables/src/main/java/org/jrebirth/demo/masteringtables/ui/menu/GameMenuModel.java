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
package org.jrebirth.demo.masteringtables.ui.menu;

import java.util.concurrent.atomic.AtomicBoolean;

import javafx.util.Duration;

import org.jrebirth.af.api.annotation.LinkComponent;
import org.jrebirth.af.api.annotation.Releasable;
import org.jrebirth.af.api.wave.contract.WaveData;
import org.jrebirth.af.core.command.basic.showmodel.FadeInOutWaveBean;
import org.jrebirth.af.core.command.basic.showmodel.ShowTemporaryCommand;
import org.jrebirth.af.core.ui.object.DefaultObjectModel;
import org.jrebirth.af.core.wave.Builders;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.powered.AdModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameMenuModel.
 */
public class GameMenuModel extends DefaultObjectModel<GameMenuModel, GameMenuView, GameSettings> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameMenuModel.class);

    /** The service used to build quiz data. */
    @LinkComponent
    private ExpressionBuilderService expressionBuilderService;

    private final AtomicBoolean hasShown = new AtomicBoolean(false);

    @Releasable
    public boolean canRelease() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void showView() {
        super.showView();

        final FadeInOutWaveBean fiowb = FadeInOutWaveBean.create().showDuration(Duration.millis(4000));

        if (!this.hasShown.getAndSet(true)) {
            attachUi(AdModel.class, Builders.buildUiData(getView().topPlaceHolder(), fiowb, ShowTemporaryCommand.class).toArray(new WaveData[0]));
        }

    }

}
