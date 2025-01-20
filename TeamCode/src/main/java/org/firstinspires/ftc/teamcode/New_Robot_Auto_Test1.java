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
                new WaitCommand(0.2),
                new MoveArmCommand(2300),
                new WaitCommand(0.2),
                new MoveSlideCommand(-1550),
                new WaitCommand(0.2),
                new MoveForwardCommand(0.5,0.6),
                new WaitCommand(0.2),
                new StrafeCommand(0.3,0.3),
                new WaitCommand(0.2),
                new TurnCommand(0.2,0.3),
                new WaitCommand(1),
                new MoveArmCommand(-200),
                new StrafeCommand(0.3,0.5),
                new TurnCommand(0.3,0.3),
                new MoveForwardCommand(0.3,0.3),
                new WaitCommand(0.2),
                new ClawCommand(0.5),
                new WaitCommand(1),
                new ClawCommand(0),
                //finshes first sample
                new StrafeCommand(-0.3,0.5),
                new WaitCommand(0.2),
                new TurnCommand(-0.5,0.6),
                new WaitCommand(0.2),
                new MoveForwardCommand(-0.5,0.3),
                new WaitCommand(0.2),
                new StrafeCommand(-0.2,0.2),

                new WaitCommand(0.2),
                new MoveArmCommand(-1500),
                new WaitCommand(0.2),
                new StrafeCommand(-0.3,0.4),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.3,0.3),
                new MoveArmCommand(-200),
                new ClawCommand(0),
                new WaitCommand(0.2),
                new MoveSlideCommand(1550),
                new WaitCommand(0.2),
                new MoveArmCommand(-2300)
        );
    }
}