package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem {
    private Servo intake;
    private Servo wrist;
    public IntakeSubsystem(HardwareMap hardwareMap){
        intake = hardwareMap.get(Servo.class,"intake");
        wrist = hardwareMap.get(Servo.class,"wrist");
    }
    public void setIntake(double position){
        intake.setPosition(position);
    }
    public void setWrist(double position){
        wrist.setPosition(position);
    }
}
