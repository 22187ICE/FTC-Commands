package org.firstinspires.ftc.teamcode.command.executor.trigger;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.command.executor.CommandGroupExecutor;

public class TriggerGamepad {
    private final Gamepad gamepad;
    public final Trigger a,b,x,y,dpad_up,dpad_down,dpad_left,dpad_right,back,circle,cross,guide,start,left_bumper,
            right_bumper,left_stick_button, right_stick_button,triangle,square,share,options,touchpad,touchpad_finger_1,
            touchpad_finger_2,ps;
    public TriggerGamepad(Gamepad gamepad, CommandGroupExecutor executor) {
        this.gamepad = gamepad;
        a = new Trigger(()->gamepad.a,executor);
        b = new Trigger(()->gamepad.b,executor);
        x = new Trigger(()->gamepad.x,executor);
        y = new Trigger(()->gamepad.y,executor);
        dpad_up = new Trigger(()->gamepad.dpad_up,executor);
        dpad_down = new Trigger(()->gamepad.dpad_down,executor);
        dpad_left = new Trigger(()->gamepad.dpad_left,executor);
        dpad_right = new Trigger(()->gamepad.dpad_right,executor);
        back = new Trigger(()->gamepad.back,executor);
        circle = new Trigger(()->gamepad.circle,executor);
        cross = new Trigger(()->gamepad.cross,executor);
        guide = new Trigger(()->gamepad.guide,executor);
        start = new Trigger(()->gamepad.start,executor);
        left_bumper = new Trigger(()->gamepad.left_bumper,executor);
        right_bumper = new Trigger(()->gamepad.right_bumper,executor);
        left_stick_button = new Trigger(()->gamepad.left_stick_button,executor);
        right_stick_button = new Trigger(()->gamepad.right_stick_button,executor);
        triangle = new Trigger(()->gamepad.triangle,executor);
        square = new Trigger(()->gamepad.square,executor);
        share = new Trigger(()->gamepad.share,executor);
        options = new Trigger(()->gamepad.options,executor);
        touchpad = new Trigger(()->gamepad.touchpad,executor);
        ps = new Trigger(()->gamepad.ps,executor);
        touchpad_finger_1 = new Trigger(()->gamepad.touchpad_finger_1,executor);
        touchpad_finger_2 = new Trigger(()->gamepad.touchpad_finger_2,executor);
    }
    public void update() {
        a.update();
        b.update();
        x.update();
        y.update();
        dpad_up.update();
        dpad_down.update();
        dpad_left.update();
        dpad_right.update();
        back.update();
        circle.update();
        cross.update();
        guide.update();
        start.update();
        left_bumper.update();
        right_bumper.update();
        left_stick_button.update();
        right_stick_button.update();
        triangle.update();
        square.update();
        share.update();
        options.update();
        touchpad.update();
        ps.update();
        touchpad_finger_1.update();
        touchpad_finger_2.update();
    }
    public Gamepad getGamepad() {
        return gamepad;
    }
}
