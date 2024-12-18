package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.Commands;
import org.firstinspires.ftc.teamcode.command.SequentialAuto;
import org.firstinspires.ftc.teamcode.command.builtin.WaitCommand;
@Autonomous
public class AutoMode_Specimen extends SequentialAuto {
    public AutoMode_Specimen(){
        addCommands(
                new HangSpecimenCommand()
        );
    }
}
