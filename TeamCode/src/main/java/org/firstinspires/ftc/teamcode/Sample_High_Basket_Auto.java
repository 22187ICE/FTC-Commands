package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;
@Autonomous
public class Sample_High_Basket_Auto extends SequentialAuto {
    public Sample_High_Basket_Auto() {
        addCommands(
                new ClawCommand(0),
                new WaitCommand(0.3),
                new MoveArmCommand(2300),
                new WaitCommand(0.3),
                new TurnCommand(0.7, 0.5),
                new WaitCommand(0.3),
                new MoveSlideCommand(-1450),
                new WaitCommand(0.3),
                new StrafeCommand(-0.5, 0.2),
                new WaitCommand(0.3),
                new TurnCommand(0.2, 0.4),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.6, 0.6),
                new WaitCommand(0.3),
                new ClawCommand(0.5),
                new WaitCommand(0.3),
                new ClawCommand(0),
                new WaitCommand(0.3),
                new MoveForwardCommand(-0.5, 0.3),
                new WaitCommand(0.3),
                new WristCommand(0),
                new WaitCommand(0.3),
                new MoveSlideCommand(1450),
                new WaitCommand(0.3),
                new MoveArmCommand(-2300)
        );
    }
}
