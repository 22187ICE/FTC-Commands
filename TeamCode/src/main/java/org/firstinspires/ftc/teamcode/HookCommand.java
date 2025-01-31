package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class HookCommand extends Command {
    private double position;
    private IntakeSubsystem m_hook;
    public HookCommand(double position){
        this.position = position;
    }
    @Override
    public void start() {
        m_hook = new IntakeSubsystem(hardwareMap);
        m_hook.setHook(position);
    }

    @Override
    public void loop() {
        m_hook.setHook(position);
    }

    @Override
    public void finish(boolean interrupted) {
        m_hook.setHook(position);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
