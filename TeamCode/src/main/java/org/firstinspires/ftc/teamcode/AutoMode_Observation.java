package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.command.SequentialAuto;

@Autonomous
public class AutoMode_Observation extends SequentialAuto {
    public AutoMode_Observation(){
        addCommands(

                new StrafeCommand(-0.3,6)




        );
    }
}

