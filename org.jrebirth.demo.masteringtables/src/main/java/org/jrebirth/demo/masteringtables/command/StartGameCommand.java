package org.jrebirth.demo.masteringtables.command;

import org.jrebirth.core.command.DefaultMultiCommand;
import org.jrebirth.core.command.basic.ShowModelCommand;

public class StartGameCommand extends DefaultMultiCommand {

    /**
     * Default Constructor.
     * 
     * This command will build the Game View and then launch a wave to start the game.
     */
    public StartGameCommand() {
        super();// Run into JIT and is sequential
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSubCommand() {
        addCommandClass(ShowModelCommand.class);
        addCommandClass(PlayGameCommand.class);

    }
}
