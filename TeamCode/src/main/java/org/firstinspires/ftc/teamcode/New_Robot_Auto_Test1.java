package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;


@Autonomous
public class New_Robot_Auto_Test1 extends SequentialAuto {
    public New_Robot_Auto_Test1(){
        addCommands(
                new ClawCommand(0),
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
                new MoveArmCommand(2250),
                new WaitCommand(0.2),
                new ClawCommand(0.5),
                new WaitCommand(1),
                new ClawCommand(0),
                new WaitCommand(0.2),
                new MoveForwardCommand(-0.5,0.5),
                new WaitCommand(0.2),
                new TurnCommand(-0.3,1.5),
                new MoveSlideCommand(1400),
                new WaitCommand(0.2),
                new MoveArmCommand(1000),
                new WaitCommand(0.2)



        );
    }
}