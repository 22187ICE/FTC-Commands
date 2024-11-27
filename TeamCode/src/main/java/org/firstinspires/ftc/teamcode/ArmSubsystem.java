package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class ArmSubsystem {
    private DcMotorEx arm = null;
       public ArmSubsystem(HardwareMap hardwareMap){
           arm  = hardwareMap.get(DcMotorEx.class, "arm");
           arm.setCurrentAlert(5, CurrentUnit.AMPS);
           arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           arm.setTargetPosition(0);
           arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
           arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
           arm.setTargetPositionTolerance(20);
       }
       public void setPosition(int position){
           arm.setTargetPosition(position);
           arm.setVelocity(2100);
           arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       }
       public int getPosition(){
           return arm.getCurrentPosition();
       }
       public int getTargetPosition(){
           return arm.getTargetPosition();
       }
        public boolean atPosition(){
           return !arm.isBusy();
        }
}
