package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;

@Autonomous
public class AutoMode_Spesimen_Acent extends SequentialAuto {
    public AutoMode_Spesimen_Acent(){
        addCommands(
                new MoveForwardCommand(0.35,0.4),
                new WaitCommand(0.3),
                new MoveArmCommand(1600),
                new WaitCommand(0.3),
                new WristCommand(0.55),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.2,1.55),
                new WaitCommand(0.3),
                new MoveArmCommand(2000),
                new WaitCommand(0.3),
                Commands.parallel(
                        new IntakeCommand(-1).withTimeout(2),
                        new MoveForwardCommand(-0.5,0.75)
                ),
                //afeter specimen first level acent
                new WaitCommand(0.3),
                new StrafeCommand(0.4,2.1),
                new WaitCommand(0.3),
                new MoveForwardCommand(0.4,3),
                new WaitCommand(0.3),
                new TurnCommand(-0.5,0.8),
                new MoveForwardCommand(0.4,0.2)



//                new WristCommand(0.5),
//                new MoveForwardCommand(0.5,0.3),
//                new WaitCommand(0.3),
//                new MoveArmCommand(2360),
//                new WaitCommand(0.3),
//                new MoveForwardCommand(0.6,0.3),
//                new WaitCommand(0.3),
//                new StrafeCommand(0.8,1),
//                new WaitCommand(0.3),
//                new MoveForwardCommand(0.6,0.7),
//                new WaitCommand(0.3),
//                new StrafeCommand(-0.8,0.6),
//                new TurnCommand(-0.4,0.7),
//                new MoveForwardCommand(0.3,0.1),
//                new MoveArmCommand(1900),
//                new IntakeCommand(1).withTimeout(2.5),
//                new WristCommand(0.5),
//                new WristCommand(0)


        );
    }
}
