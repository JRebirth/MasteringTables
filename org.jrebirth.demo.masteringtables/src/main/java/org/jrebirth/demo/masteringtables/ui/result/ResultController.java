/**

 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2017
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

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser.ExtensionFilter;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.component.command.snapshot.SaveImageWaveBean;
import org.jrebirth.af.component.command.snapshot.SnapshotWaveBean;
import org.jrebirth.af.component.command.snapshot.TakeSnapshotToFile;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.wave.WBuilder;
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

        linkWave(node(), KeyEvent.KEY_RELEASED, MTWaves.DO_SHOW_PAGE, WBuilder.waveData(MTWaves.PAGE, Page.GameMenu));
        linkWave(node(), MouseEvent.MOUSE_CLICKED, MTWaves.DO_SHOW_PAGE, WBuilder.waveData(MTWaves.PAGE, Page.GameMenu));

    }

    public void onMouseClicked(MouseEvent event) {

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");

        callCommand(TakeSnapshotToFile.class,
                    SnapshotWaveBean.of()
                                    .node(node()),
                    SaveImageWaveBean.of()
                                     .chooserTitle("Choose a file location for screenshot")
                                     .fileName(sdf.format(Calendar.getInstance().getTime()) + "-screenshot.png")
                                     .fileExtension(Arrays.asList(new ExtensionFilter("PNG file", "*.png"))));
    }
}
