package org.firstinspires.ftc.teamcode.command.executor.trigger;

import org.firstinspires.ftc.teamcode.command.Command;
import org.firstinspires.ftc.teamcode.command.executor.CommandGroupExecutor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class Trigger implements BooleanSupplier {
    private interface Binding {void update(boolean previous, boolean current);}

    private Set<Binding> bindings;
    private BooleanSupplier condition;
    private CommandGroupExecutor executor;
    private boolean previous;

    public Trigger(BooleanSupplier condition,CommandGroupExecutor executor) {
        bindings = new HashSet<>();
        this.condition = condition;
        this.executor = executor;
        previous = condition.getAsBoolean();

    }
    public void update() {
        for (Binding binding : bindings) {
            binding.update(previous,condition.getAsBoolean());
        }
        previous = condition.getAsBoolean();
    }
    public Trigger onTrue(Command command) {
        bindings.add(
                (prev, current) -> {
                    if (!prev && current) executor.tryAddCommand(command);
                }
        );
        return this;
    }
    public Trigger onFalse(Command command) {
        bindings.add(
                (prev,current) -> {
                    if (prev && !current) executor.tryAddCommand(command);
                }
        );
        return this;
    }
     public Trigger whileTrue(Command command) {
        bindings.add(
                (prev,current) -> {
                    if (!prev && current) executor.tryAddCommand(command);
                    else if (prev && !current) executor.removeCommand(command);
                }
        );
        return this;
    }
    public Trigger whileFalse(Command command) {
        bindings.add(
                (prev,current) -> {
                    if (prev && !current) executor.tryAddCommand(command);
                    else if (!prev && current) executor.removeCommand(command);
                }
        );
        return this;
    }
    @Override
    public boolean getAsBoolean() {
        return condition.getAsBoolean();
    }
}
