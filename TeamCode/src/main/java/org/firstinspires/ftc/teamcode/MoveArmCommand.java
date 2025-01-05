package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class MoveArmCommand extends Command {
    private int postion;
    private ArmSubsystem m_arm;
    public MoveArmCommand(int postion){
        this.postion = postion;
    }
    @Override
    public void start() {
        m_arm = new ArmSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        m_arm.setPosition(postion);
    }

    @Override
    public void finish(boolean interrupted) {
        m_arm.setPosition(m_arm.getPosition());
    }

    @Override
    public boolean isFinished() {
        return m_arm.atPosition();
    }
}