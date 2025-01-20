package org.firstinspires.ftc.teamcode.command.executor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.Subsystem;
import org.firstinspires.ftc.teamcode.command.group.ParallelCommandGroup;
import org.firstinspires.ftc.teamcode.command.group.SequentialCommandGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ParallelCommandExecutor implements CommandGroupExecutor {
    private enum State {
        PRE_INIT,
        INITIALIZED,
        STARTED,
        STOPPED
    }
    public enum ConflictBehavior {
        REPLACE_OLD,
        IGNORE_NEW
    }
    private State state = State.PRE_INIT;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Map<Command, Boolean> commandMap = new LinkedHashMap<>(); //I need something to allow for duplicate commands maybe remove on finish???
    private Set<Class<? extends Subsystem>> requirements;
    private ConflictBehavior conflictBehavior;
    public ParallelCommandExecutor(HardwareMap hardwareMap, Telemetry telemetry) {
        this(hardwareMap,telemetry,ConflictBehavior.IGNORE_NEW);
    }
    public ParallelCommandExecutor(HardwareMap hardwareMap, Telemetry telemetry, ConflictBehavior conflictBehavior) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        requirements = new HashSet<>();
        this.conflictBehavior = conflictBehavior;
    }
    @Override
    public void addCommand(Command command) {
        if (state == State.STOPPED) return;
        //return if command is already running
        if (commandMap.getOrDefault(command,false)) return;
        for (Class<? extends Subsystem> requirement : command.getRequirements()) { //TODO implement requirement system for this
            if (requirements.contains(requirement)) {
                if (conflictBehavior == ConflictBehavior.IGNORE_NEW) return;
                else {
                    for (Command cmd : commandMap.keySet()) {
                        if (cmd.getRequirements().contains(requirement)) removeCommand(cmd);
                    }
                }

            }
        }
        requirements.addAll(command.getRequirements());
        if (state == State.INITIALIZED || state == State.STARTED) Command.initCommand(command,hardwareMap,telemetry);
        if (state == State.STARTED) command.start();
        commandMap.put(command,state == State.STARTED);
    }

    @Override
    public boolean tryAddCommand(Command command) {
        if (state == State.STOPPED) return false;
        try {
            addCommand(command);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override
    public boolean removeCommand(Command command) {
        if (commandMap.getOrDefault(command,false)) {
            command.finish(true);
            commandMap.put(command,false);
            requirements.removeAll(command.getRequirements());
            return true;
        }
        return false;
    }

    @Override
    public void init() {
        state = State.INITIALIZED;
        for (Command cmd : commandMap.keySet()) {
            Command.initCommand(cmd,hardwareMap,telemetry);
        }
    }

    @Override
    public void execute() {
        if (state == State.STOPPED) return;
        if (state == State.PRE_INIT) init();
        if (state == State.INITIALIZED) {
            for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
                entry.getKey().start();
                entry.setValue(true);
            }
            state = State.STARTED;
        }
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            Command command = entry.getKey();
            if (!entry.getValue()) continue;
            command.loop();
            if (command.isFinished()) {
                entry.setValue(false);
                command.finish(false);
                //remove requirements when the command is done, so other commands with different requirements can be added
                requirements.removeAll(command.getRequirements());
            }
        }

    }

    @Override
    public void stop() {
        for (Map.Entry<Command, Boolean> entry : commandMap.entrySet()) {
            if (entry.getValue()) entry.getKey().finish(true);
        }
        state = State.STOPPED;
    }

    @Override
    public void dispose() {
        for (Map.Entry<Command,Boolean> entry : commandMap.entrySet()) {
            entry.getKey().dispose();
        }
        state = State.STOPPED;
    }
    @Override
    public Collection<Command> getCommands() {
        return Collections.unmodifiableCollection(commandMap.keySet());
    }
}
