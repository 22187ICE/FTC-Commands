package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class ClawCommand extends Command {
    private double position;
    private IntakeSubsystem m_intake;
    public ClawCommand(double position){
        this.position = position;
    }
    @Override
    public void start() {
        m_intake = new IntakeSubsystem(hardwareMap);
        m_intake.setIntake(position);
    }

    @Override
    public void loop() {
        m_intake.setIntake(position);
    }

    @Override
    public void finish(boolean interrupted) {
        m_intake.setIntake(position);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
