package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem {
    private CRServo intake;
    private Servo wrist;
    public IntakeSubsystem(HardwareMap hardwareMap){
        intake = hardwareMap.get(CRServo.class,"intake");
        wrist = hardwareMap.get(Servo.class,"wrist");

    }
    public void setIntake(double speed){
        intake.setPower(speed);

    }
    public void setWrist(double position){

        wrist.setPosition(position);
    }

}
