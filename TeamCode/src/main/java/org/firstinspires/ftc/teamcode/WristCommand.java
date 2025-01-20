package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class WristCommand extends Command {
    private double position;
    private IntakeSubsystem m_wrist;
public WristCommand(double position){

    this.position = position;

}
    @Override
    public void start() {
        m_wrist = new IntakeSubsystem(hardwareMap);
        m_wrist.setWrist(position);

    }

    @Override
    public void loop() {


    }

    @Override
    public void finish(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
