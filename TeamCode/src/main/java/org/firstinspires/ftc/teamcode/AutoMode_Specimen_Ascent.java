package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;

@Autonomous
public class AutoMode_Specimen_Ascent extends SequentialAuto {
    public AutoMode_Specimen_Ascent(){
        addCommands(

                new HangSpecimenCommand(),
                // goes to first level accent
                new WaitCommand(0.1),
                new StrafeCommand(0.4,1.5),
                new WaitCommand(0.1),
                new MoveForwardCommand(0.4,2.2),
                new WaitCommand(0.1),
                new TurnCommand(-0.5,0.8),
                new MoveForwardCommand(0.4,0.2)

        );
    }
}
