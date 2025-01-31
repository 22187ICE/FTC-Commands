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
                new WaitCommand(0.5),
                new MoveArmCommand(2350),
                new WaitCommand(0.2),
                new StrafeCommand(-0.5,1),
                new WaitCommand(0.2),
                new TurnCommand(0.3,0.5),
                new WaitCommand(0.2),
                new MoveForwardCommand(0.5,0.5),
                new WaitCommand(0.2),
                new MoveSlideCommand(-1400),
                new WaitCommand(0.2),
                new MoveForwardCommand(0.3,0.8),
                new WaitCommand(0.2),
                new MoveArmCommand(-100),
                new WaitCommand(0.2),
                new ClawCommand(0.5),
                new WaitCommand(1),
                new ClawCommand(0),
                new WaitCommand(0.2),
                new MoveArmCommand(100),
                new WaitCommand(0.2),
                new MoveForwardCommand(-0.5,0.5),
                new WaitCommand(0.2),
                new TurnCommand(-0.3,1.5),
                new MoveSlideCommand(1400),
                new WaitCommand(0.2),
                new MoveArmCommand(-1300),
                new WaitCommand(0.2),
                new MoveForwardCommand(1,0.5),
                new TurnCommand(0.4,0.55),
                new WaitCommand(0.2),
                new MoveForwardCommand(-0.5,1),
                new WaitCommand(0.2),
                new TouchBarCommand(1),
                new WaitCommand(0.5)
        );
    }
}
