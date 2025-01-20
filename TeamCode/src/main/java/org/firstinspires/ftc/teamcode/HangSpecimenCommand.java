package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;
import org.firstinspires.ftc.teamcode.command.group.SequentialCommandGroup;

public class HangSpecimenCommand extends SequentialCommandGroup {
    public HangSpecimenCommand() {
        addCommands(
                new ClawCommand(0),
                new WaitCommand(0.3),
                new MoveArmCommand(1300),
                new WaitCommand(0.3),
                new WristCommand(0),
                new WaitCommand(0.3),
                new MoveSlideCommand(-300),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.5,1),
                new WaitCommand(0.3),
                new MoveArmCommand(-100),
                new WaitCommand(0.3),
                new MoveForwardCommand(-0.3,0.5),
                new WaitCommand(0.3),
                new ClawCommand(0.5)


        );

    }
}
