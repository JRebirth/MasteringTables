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
package org.jrebirth.demo.masteringtables.ui.start;

import javafx.event.ActionEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractController;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.demo.masteringtables.beans.Page;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class StartController.
 */
public class StartController extends AbstractController<StartModel, StartView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartController.class);

    /**
     * Instantiates a new start controller.
     * 
     * @param view the view
     * @throws CoreException the core exception
     */
    public StartController(final StartView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {
        // Listen events
    }

    /**
     * On action start.
     * 
     * @param actionEvent the action event
     */
    public void onActionStart(final ActionEvent actionEvent) {
        getModel().sendWave(MTWaves.SHOW_PAGE, WaveData.build(MTWaves.PAGE, Page.Game));
    }

}