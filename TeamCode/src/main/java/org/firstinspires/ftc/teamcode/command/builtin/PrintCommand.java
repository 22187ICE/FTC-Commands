package org.firstinspires.ftc.teamcode.command.builtin;

import org.firstinspires.ftc.teamcode.command.Command;

import java.util.function.Supplier;

public class PrintCommand extends Command {
    private Supplier<String> text;
    public PrintCommand(String text) {
        this(()->text);
    }
    public PrintCommand(Supplier<String> text) {
        this.text = text;
    }
    @Override
    public void start() {
        telemetry.addLine(text.get());
        telemetry.update();
    }

    @Override
    public void loop() {}

    @Override
    public void finish(boolean interrupted) {}
    @Override
    public boolean isFinished() {
        return true;
    }
}
