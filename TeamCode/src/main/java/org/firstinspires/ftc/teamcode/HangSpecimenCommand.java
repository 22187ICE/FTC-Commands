package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;
import org.firstinspires.ftc.teamcode.command.group.SequentialCommandGroup;

public class HangSpecimenCommand extends SequentialCommandGroup {
    public HangSpecimenCommand() {
        addCommands(
                new MoveForwardCommand(0.3, 0.5),
                new WaitCommand(0.1),
                new MoveArmCommand(1600),
                new WaitCommand(0.1),
                new WristCommand(0.5),
                new WaitCommand(0.1),
                new MoveForwardCommand(0.2, 1.2),
                new WaitCommand(0.1),
                new MoveArmCommand(2000),
                new WaitCommand(0.1),
                Commands.parallel(
                        new IntakeCommand(1).withTimeout(2),
                        new MoveForwardCommand(-0.5, 0.75)
                )
        );
    }
}
