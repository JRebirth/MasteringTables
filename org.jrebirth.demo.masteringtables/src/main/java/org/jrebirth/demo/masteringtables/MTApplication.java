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
package org.jrebirth.demo.masteringtables;

import java.util.List;
import java.util.Locale;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.af.api.resource.ResourceItem;
import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.core.application.DefaultApplication;
import org.jrebirth.demo.masteringtables.resources.MTColors;
import org.jrebirth.demo.masteringtables.resources.MTImages;
import org.jrebirth.demo.masteringtables.resources.MTStyles;
import org.jrebirth.demo.masteringtables.ui.page.PageModel;

/**
 * The MTApplication is the main class used to start the application in standalone mode.
 */
public final class MTApplication extends DefaultApplication<StackPane> {

    /**
     * The main method triggered by Java Runtime.
     *
     * @param args the arguments
     */
    public static void main(final String... args) {
        preloadAndLaunch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void preInit() {
        super.preInit();

        Locale.setDefault(Locale.FRANCE);
        // JRebirthParameters.LOG_RESOLUTION.define(false);

        // try {
        // Class.forName(MTWaves.class.getName(), true, Thread.currentThread().getContextClassLoader());
        // } catch (final ClassNotFoundException e) {
        // throw new AssertionError(e); // Can't happen
        // }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> getFirstModelClass() {
        return PageModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
        stage.setResizable(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeScene(final Scene scene) {
        addCSS(scene, MTStyles.MAIN);
        addCSS(scene, MTStyles.MENU);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<? extends ResourceItem<?, ?, ?>> getResourceToPreload() {
        // // Define fonts that will be available from CSS
        // return Collections.Arrays.asList(new FontItem[] {
        // MTFonts.EXPRESSION,
        // MTFonts.COUNTER,
        // });

        return resourceEnumToList(MTColors.class, MTImages.class);
    }

    private List<? extends ResourceItem<?, ?, ?>> resourceEnumToList(final Class<? extends ResourceItem<?, ?, ?>>... enumeration) {

        return null;
    }

}
