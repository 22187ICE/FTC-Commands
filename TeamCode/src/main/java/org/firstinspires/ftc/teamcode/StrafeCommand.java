package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.command.Command;

public class StrafeCommand extends Command {
    private boolean finished = false;
    private DriveSubsystem m_drive;
    private double speed = 0;
    private ElapsedTime time = new ElapsedTime();
    private double seconds = 0;
    public StrafeCommand(double speed, double seconds) {
        this.speed = speed;
        this.seconds = seconds;
    }
    @Override
    public void start() {
        m_drive = new DriveSubsystem(hardwareMap);
        time.reset();
    }

    @Override
    public void loop() {
       m_drive.setMotors(-speed,speed,speed,-speed);
        if(time.seconds()>=seconds){
            finished = true;
        }
    }

    @Override
    public void finish(boolean interrupted) {
        m_drive.setMotors(0);
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
