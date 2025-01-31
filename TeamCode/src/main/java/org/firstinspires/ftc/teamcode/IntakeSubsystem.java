package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem {
    private Servo hook;
    private Servo intake;
    private Servo wrist;
    private Servo barToucher;
    public IntakeSubsystem(HardwareMap hardwareMap){
        hook = hardwareMap.get(Servo.class,"hook");
        intake = hardwareMap.get(Servo.class,"intake");
        wrist = hardwareMap.get(Servo.class,"wrist");
        barToucher  = hardwareMap.get(Servo.class,"barToucher");

    }
    public void setHook(double position){
        hook.setPosition(position);
    }
    public void setIntake(double position){
        intake.setPosition(position);
    }
    public void setWrist(double position){
        wrist.setPosition(position);
    }
    public void setBarToucher(double position){
        barToucher.setPosition(position);
    }
}
