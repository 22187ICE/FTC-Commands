package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous
public class ResetArm extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        new ArmSubsystem(hardwareMap).resetPosition();
    }
}
