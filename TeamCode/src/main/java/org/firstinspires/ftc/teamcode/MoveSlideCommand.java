package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.command.Command;

public class MoveSlideCommand extends Command {
    private int postion;
    private SlideSubsystem m_slide;
    public MoveSlideCommand(int postion){
        this.postion = postion;
    }
    @Override
    public void start() {
        m_slide = new SlideSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        m_slide.setPosition(postion);
    }

    @Override
    public void finish(boolean interrupted) {
        m_slide.setPosition(m_slide.getPosition());
    }

    @Override
    public boolean isFinished() {
        return m_slide.atPosition();
    }
}