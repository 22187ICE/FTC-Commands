package org.firstinspires.ftc.teamcode.command.group;

import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.Subsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ParallelRaceGroup extends Command{
    protected ArrayList<Command> commandList = new ArrayList<>();
    protected boolean finished = true;
    public ParallelRaceGroup(Command... commands) {
        addCommands(commands);
    }
    public void addCommands(Command... commands) {
        if (!finished) {
            throw new IllegalStateException("Cannot add commands while group is running");
        }
        for (Command c : commands) {
            for (Class<? extends Subsystem> requirement : c.getRequirements()) {
                if (getRequirements().contains(requirement)) throw new IllegalStateException("Cannot run multiple commands with the same requirements in parallel");
                addRequirement(requirement);
            }
            commandList.add(c);
        }
    }
    @Override
    public void init() {
        for (Command command : commandList) {
            Command.initCommand(command,hardwareMap,telemetry);
        }
    }
    @Override
    public void start() {
        if (!commandList.isEmpty()) {
            finished = false;
            for (Command command : commandList) command.start();
        }
    }

    @Override
    public void loop() {
        for (Command cmd : commandList) {
            cmd.loop();
            if (cmd.isFinished()) finished = true;
        }
    }

    @Override
    public void finish(boolean interrrupted) {
        for (Command c : commandList) c.finish(!c.isFinished());
    }
    @Override
    public void dispose() {
        for (Command command : commandList) command.dispose();
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public Collection<Command> getCommands() {
        return Collections.unmodifiableCollection(commandList);
    }
}
