package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;

@Autonomous
public class New_Robot_Auto_Test1 extends SequentialAuto {
    public New_Robot_Auto_Test1(){
        addCommands(
                new MoveForwardCommand(0.35,0.4),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.2,1.55),
                new WaitCommand(0.3),
                new MoveForwardCommand(-0.5,0.75),//afeter specimen first level acent
                new WaitCommand(0.3),
                new StrafeCommand(0.4,2.1),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.4,3),
                new WaitCommand(0.3),
                new TurnCommand(-0.5,0.8),
                new MoveForwardCommand(0.4,0.2)

        );
    }
}