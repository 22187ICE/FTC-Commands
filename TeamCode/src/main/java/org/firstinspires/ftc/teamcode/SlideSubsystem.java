package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class SlideSubsystem {
    private DcMotorEx slide = null;
    public SlideSubsystem(HardwareMap hardwareMap){
        slide  = hardwareMap.get(DcMotorEx.class, "slide");
        slide.setCurrentAlert(5, CurrentUnit.AMPS);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setTargetPosition(0);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPositionTolerance(20);
    }
    public void setPosition(int position){
        slide.setTargetPosition(position);
        slide.setVelocity(1700);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public int getPosition(){
        return slide.getCurrentPosition();
    }
    public int getTargetPosition(){
        return slide.getTargetPosition();
    }
    public boolean atPosition(){
        return !slide.isBusy();
    }
}
