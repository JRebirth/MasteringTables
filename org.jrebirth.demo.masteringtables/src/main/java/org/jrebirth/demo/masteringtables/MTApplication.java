package org.jrebirth.demo.masteringtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.core.application.AbstractApplication;
import org.jrebirth.core.resource.font.FontItem;
import org.jrebirth.core.ui.Model;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveBuilder;
import org.jrebirth.core.wave.WaveGroup;
import org.jrebirth.demo.masteringtables.resources.MTFonts;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.page.PageModel;

/**
 * The class <strong>MTApplication</strong>.
 * 
 * @author
 */
public final class MTApplication extends AbstractApplication<StackPane> {

    /**
     * Application launcher.
     * 
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        Application.launch(MTApplication.class, args);
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
    protected String getApplicationTitle() {
        return "Mastering Tables - Powered by JRebirth";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeScene(final Scene scene) {
        addCSS(scene, "style/mt.css");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FontItem> getFontToPreload() {
        return Arrays.asList(new FontItem[] {
                MTFonts.SPLASH
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Wave> getPreBootWaveList() {
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Wave> getPostBootWaveList() {
        final List<Wave> waveList = new ArrayList<>();
        waveList.add(
                WaveBuilder.create()
                        .waveGroup(WaveGroup.RETURN_DATA)
                        .relatedClass(ExpressionBuilderService.class)
                        .waveType(ExpressionBuilderService.DO_BUILD_TABLES)
                        .build()
                );

        return waveList;
    }

}
