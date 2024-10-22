package org.firstinspires.ftc.teamcode.command.group;

import org.firstinspires.ftc.teamcode.command.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialCommandGroup extends Command {
    private int currentCommandIndex = -1;
    private ArrayList<Command> commandList = new ArrayList<>();
    private boolean finished = false;
    public SequentialCommandGroup(Command... commands) {
        addCommands(commands);
    }
    public void addCommands(Command... commands) {
        if (currentCommandIndex != -1) {
            throw new IllegalStateException("Cannot add commands while group is running");
        }
        commandList.addAll(Arrays.asList(commands));
    }
    @Override
    public void init() {
        for (Command command : commandList) {
            Command.initCommand(command,hardwareMap,telemetry);
        }
    }
    @Override
    public void start() {
        if (commandList.isEmpty()) {
            finished = true;
        } else {
            currentCommandIndex = 0;
            commandList.get(0).start();
        }
    }

    @Override
    public void loop() {
        if (commandList.isEmpty()) return;
        Command current =commandList.get(currentCommandIndex);
        current.loop();
        if (current.isFinished()) {
            current.finish(false);
            currentCommandIndex++;
            if (currentCommandIndex < commandList.size()) {
                commandList.get(currentCommandIndex).start();
            } else finished = true;
        }
    }

    @Override
    public void finish(boolean interrrupted) {
        if (interrrupted && !commandList.isEmpty() &&  currentCommandIndex > -1 && currentCommandIndex < commandList.size()) {
            commandList.get(currentCommandIndex).finish(true);
        }
        currentCommandIndex = -1;
    }
    @Override
    public void dispose() {
        for (Command command : commandList) command.dispose();
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
