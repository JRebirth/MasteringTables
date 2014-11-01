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
package org.jrebirth.demo.masteringtables.ui.result;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.wave.Builders;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameController.
 */
public class ResultController extends DefaultController<ResultModel, ResultView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

    /**
     * Instantiates a new game controller.
     *
     * @param view the view
     * @throws CoreException the core exception
     */
    public ResultController(final ResultView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventAdapters() throws CoreException {

        linkWave(getRootNode(), KeyEvent.KEY_RELEASED, MTWaves.SHOW_PAGE, Builders.waveData(MTWaves.PAGE, Page.GameMenu));
        linkWave(getRootNode(), MouseEvent.MOUSE_CLICKED, MTWaves.SHOW_PAGE, Builders.waveData(MTWaves.PAGE, Page.GameMenu));

    }
}
