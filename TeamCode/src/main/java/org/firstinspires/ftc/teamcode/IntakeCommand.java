package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class IntakeCommand extends Command {
    private double power;
    private IntakeSubsystem m_intake;
    public IntakeCommand(double power){
        this.power = power;
    }
    @Override
    public void start() {
        m_intake = new IntakeSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        m_intake.setIntake(power);
    }

    @Override
    public void finish(boolean interrupted) {
        m_intake.setIntake(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
