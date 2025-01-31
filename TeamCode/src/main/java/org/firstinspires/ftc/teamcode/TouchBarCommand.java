package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class TouchBarCommand extends Command {
    private double position;
    private IntakeSubsystem m_barToucher;
    public TouchBarCommand(double position){

        this.position = position;

    }
    @Override
    public void start() {
        m_barToucher = new IntakeSubsystem(hardwareMap);
        m_barToucher.setBarToucher(position);

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