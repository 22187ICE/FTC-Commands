package org.firstinspires.ftc.teamcode.command.executor;

import org.firstinspires.ftc.teamcode.command.Command;

import java.util.Collection;

public interface CommandGroupExecutor {

    void addCommand(Command command);
    default void addCommands(Command... commands) {
        for (Command command : commands) addCommand(command);
    }
    boolean tryAddCommand(Command command);
    boolean removeCommand(Command command);
    void init();
    void execute();
    void stop();
    void dispose();
    Collection<Command> getCommands();
}
