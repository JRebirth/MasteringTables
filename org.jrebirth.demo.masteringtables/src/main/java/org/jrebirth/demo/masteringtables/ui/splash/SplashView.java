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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

import org.jrebirth.af.core.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;
import org.jrebirth.af.core.ui.DefaultView;
import org.jrebirth.af.core.ui.annotation.RootNodeId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class SplashView.
 */
@RootNodeId("SplashPanel")
public class SplashView extends DefaultView<SplashModel, BorderPane, DefaultController<SplashModel, SplashView>> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SplashView.class);

    /** The loading bar related to expression calculation. */
    private ProgressBar loadingBar;

    /**
     * Instantiates a new page view.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
    public SplashView(final SplashModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        this.loadingBar = new ProgressBar(0.0);
        this.loadingBar.setMinSize(400, 40);
        BorderPane.setAlignment(this.loadingBar, Pos.CENTER);
        BorderPane.setMargin(this.loadingBar, new Insets(40, 0, 30, 0));

        getRootNode().setBottom(this.loadingBar);
    }

    /**
     * @return Returns the loadingBar.
     */
    public ProgressBar getLoadingBar() {
        return this.loadingBar;
    }

}