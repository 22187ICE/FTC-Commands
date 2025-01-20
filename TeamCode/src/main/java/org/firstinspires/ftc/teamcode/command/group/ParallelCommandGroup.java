package org.firstinspires.ftc.teamcode.command.group;

import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.Subsystem;
import org.firstinspires.ftc.teamcode.command.builtin.EmptyCommand;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParallelCommandGroup extends Command {
    protected Map<Command, Boolean> commandMap = new LinkedHashMap<>();
    protected boolean started = false;
    public ParallelCommandGroup(Command... commands) {
        //signals that command has started
        addCommands(new EmptyCommand());
        addCommands(commands);
    }
    public void addCommands(Command... commands) {
        if (started) {
            throw new IllegalStateException(
                    "Commands cannot be added to a composition while it's running");
        }
        for (Command c : commands) {
            for (Class<? extends Subsystem> requirement : c.getRequirements()) {
                if (getRequirements().contains(requirement)) throw new IllegalStateException("Cannot run multiple commands with the same requirements in parallel");
                addRequirement(requirement);
            }
            commandMap.put(c,false);
        }
    }
    @Override
    public void init() {
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            Command.initCommand(entry.getKey(),hardwareMap,telemetry);
        }
    }
    @Override
    public void start() {
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            entry.getKey().start();
            entry.setValue(true);
        }
        started = true;
    }

    @Override
    public void loop() {
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            Command command = entry.getKey();
            if (!entry.getValue()) continue;
            command.loop();
            if (command.isFinished()) {
                entry.setValue(false);
                command.finish(false);
            }
        }
    }

    @Override
    public void finish(boolean interrupted) {
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            if (entry.getValue()) entry.getKey().finish(true);
        }
    }
    @Override
    public void dispose() {
        for (Map.Entry<Command,Boolean> entry : commandMap.entrySet()) {
            entry.getKey().dispose();
        }
    }
    @Override
    public boolean isFinished() {
        return !commandMap.containsValue(true);
    }
    public Collection<Command> getCommands() {
        return Collections.unmodifiableCollection(commandMap.keySet());
    }
}
