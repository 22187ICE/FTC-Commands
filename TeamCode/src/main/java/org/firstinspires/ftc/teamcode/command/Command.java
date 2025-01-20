package org.firstinspires.ftc.teamcode.command;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.command.builtin.ConditionalCommand;
import org.firstinspires.ftc.teamcode.command.builtin.EmptyCommand;
import org.firstinspires.ftc.teamcode.command.builtin.RepeatCommand;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;
import org.firstinspires.ftc.teamcode.command.builtin.WaitUntilCommand;
import org.firstinspires.ftc.teamcode.command.group.ParallelCommandGroup;
import org.firstinspires.ftc.teamcode.command.group.ParallelDeadlineGroup;
import org.firstinspires.ftc.teamcode.command.group.ParallelRaceGroup;
import org.firstinspires.ftc.teamcode.command.group.SequentialCommandGroup;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.List;

public abstract class Command {
    protected HardwareMap hardwareMap;
    protected Telemetry telemetry;
    private final Set<Class<? extends Subsystem>> requiredSubsystems = new HashSet<>();

    public void addRequirement(Class<? extends Subsystem> requirement) {
        requiredSubsystems.add(requirement);
    }
    public void addRequirements(Class<? extends Subsystem>... requirements) {
        for (Class<? extends Subsystem> requirement : requirements) addRequirement(requirement);
    }
    public Set<Class<? extends Subsystem>> getRequirements() {
        return Collections.unmodifiableSet(requiredSubsystems);
    }
    public void init() {}

    public abstract void start();

    public abstract void loop();

    public abstract void finish(boolean interrupted);

    public void dispose() {}

    public abstract boolean isFinished();

    public static void runCommand(Command command) {
        command.start();
        while (!command.isFinished()) {
            command.loop();
        }
        command.finish(false);
    }
    public static void fullRunCommand(Command command, HardwareMap hardwareMap, Telemetry telemetry) {
        initCommand(command,hardwareMap,telemetry);
        runCommand(command);
        command.dispose();
    }
    public static void initCommand(Command command, HardwareMap hardwareMap, Telemetry telemetry) {
        command.hardwareMap = hardwareMap;
        command.telemetry = telemetry;
        command.init();
    }
    // "modifier" methods
    public ParallelRaceGroup withTimeout(double seconds) {
        return raceWith(new WaitCommand(seconds));
    }
    public ParallelRaceGroup until(BooleanSupplier condition) {
        return raceWith(new WaitUntilCommand(condition));
    }
    public ParallelRaceGroup raceWith(Command... commands) {
        ParallelRaceGroup group = new ParallelRaceGroup(commands);
        group.addCommands(this);
        return group;
    }
    public ParallelCommandGroup alongWith(Command... parallel) {
        ParallelCommandGroup group = new ParallelCommandGroup(this);
        group.addCommands(parallel);
        return group;
    }
    public SequentialCommandGroup andThen(Command... next) {
        SequentialCommandGroup group = new SequentialCommandGroup(this);
        group.addCommands(next);
        return group;
    }
    public ParallelDeadlineGroup deadlineFor(Command... parallel) {
        return new ParallelDeadlineGroup(this, parallel);
    }
    public RepeatCommand repeatedly() {
        return new RepeatCommand(this);
    }
    public ConditionalCommand unless(BooleanSupplier condition) {
        return new ConditionalCommand(new EmptyCommand(), this, condition);
    }
    public ConditionalCommand onlyIf(BooleanSupplier condition) {
        return unless(() -> !condition.getAsBoolean());
    }


}
