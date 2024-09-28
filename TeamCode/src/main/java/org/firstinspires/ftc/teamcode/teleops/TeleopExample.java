package org.firstinspires.ftc.teamcode.teleops;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

/*
Example teleop with a single subsystem and some buttons
 */
@TeleOp(name = "Teleop Example Fake Arm")
public class TeleopExample extends ActionSchedulerOpMode {

    // Stuff to run when teleop initializes
    @Override
    public void initOpMode() {

    }

    // Stuff to do on every program loop
    @Override
    public void loopOpMode(TelemetryPacket p) {

        // If arm isn't running an action, control the motor with the joystick
        if(!isBusy(Robot.fakeArm))
        {
            Robot.fakeArm.setMotorSpeed(gamepad2.left_stick_y);
        }

        // Run actions bound to buttons
        if(gamepad2.x)
        {
            runAction(Robot.fakeArm.motorPresetPosition(), Robot.fakeArm);
        }
        if(gamepad2.y)
        {
            runAction(Robot.fakeArm.setMotorPosition(100), Robot.fakeArm);
        }
        if(gamepad2.a)
        {
            runAction(Robot.fakeArm.setServoPosition(0), Robot.fakeArm);
        }
        if(gamepad2.b)
        {
            runAction(Robot.fakeArm.setServoPosition(0.5), Robot.fakeArm);
        }

        // Mecanum Drive
        if(!isBusy(Robot.mecanumDrive))
        {
            // Get joystick values
            double lr = gamepad1.left_stick_x;
            double fb = -gamepad1.left_stick_y;
            double rot = -gamepad1.right_stick_x;

            // Tell mecanumDrive what to do
            Robot.mecanumDrive.setDrivePowers(new PoseVelocity2d(new Vector2d(fb,-lr),rot));
        }

        // Emergency cancel button
        if(gamepad2.back)
        {
            cancelActions();
        }
    }
}
