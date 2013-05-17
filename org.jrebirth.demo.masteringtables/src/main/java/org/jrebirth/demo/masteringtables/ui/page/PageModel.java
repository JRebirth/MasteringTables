package org.jrebirth.demo.masteringtables.ui.page;

import java.util.List;

import org.jrebirth.core.command.basic.DisplayModelWaveBean;
import org.jrebirth.core.command.basic.ShowModelCommand;
import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.command.StartGameCommand;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.service.SessionService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;
import org.jrebirth.demo.masteringtables.ui.game.GameModel;
import org.jrebirth.demo.masteringtables.ui.start.StartModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
public class PageModel extends AbstractModel<PageModel, PageView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageModel.class);

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

    public void tablesBuilt(final List<Expression> allTables, final Wave wave) {

        showPage(Page.StartMenu, null);

    }

    public void showPage(Page page, Wave wave) {

        DisplayModelWaveBean waveBean = new DisplayModelWaveBean();
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
    protected void processAction(final Wave wave) {
        // Process a wave action, you must listen the wave type before
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Custom code to process when the view is hidden
    }

}
