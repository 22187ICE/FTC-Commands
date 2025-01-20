package org.firstinspires.ftc.teamcode.command.executor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;
import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.group.SequentialCommandGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SequentialCommandExecutor implements CommandGroupExecutor {
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private ArrayList<Command> commandList = new ArrayList<>();
    private int index = -1;
    private boolean needStart = true;
    private boolean stopped = false;
    public SequentialCommandExecutor(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
    }

    @Override
    public void addCommand(Command command) {
        //executor already started
        if (index != -1) {
            Command.initCommand(command,hardwareMap,telemetry);

        }
        commandList.add(command);
    }

    @Override
    public boolean tryAddCommand(Command command) {
        addCommand(command);
        return true;
    }

    @Override
    public boolean removeCommand(Command command) {
        for (int i = index; i < commandList.size(); i++) {
            if (commandList.get(i).equals(command)) {
                if (i == index && !needStart) commandList.get(i).finish(true);
                commandList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void init() {
        for (Command cmd : commandList) {
            Command.initCommand(cmd,hardwareMap,telemetry);
        }
        index = 0;
    }

    @Override
    public void execute() {
        if (stopped) return;
        if (index == -1) init();
        if (index >= commandList.size()) return;
        Command current = commandList.get(index);
        if (needStart) {
            current.start();
            needStart = false;
        }
        current.loop();
        if (current.isFinished()) {
            current.finish(false);
            index++;
            if (index < commandList.size()) commandList.get(index).start();
            else needStart = true;
        }
    }

    @Override
    public void stop() {
        stopped = true;

        //if no command needs started there is a currently active command
        if (!needStart) {
            //interrupt the active command
            commandList.get(index).finish(true);
        }
    }

    @Override
    public void dispose() {
        for (Command c : commandList) c.dispose();
    }


    @Override
    public Collection<Command> getCommands() {
        return Collections.unmodifiableList(commandList);
    }
}
