package org.firstinspires.ftc.teamcode.teleops;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
//wifi 4381442210024
@TeleOp(name="MecanumDriveRR")
public class Teleop1 extends ActionSchedulerOpMode{

    @Override
    public void initOpMode() {

    }

    @Override
    public void loopOpMode(TelemetryPacket p) {



        if (!isBusy(Robot.mecanumDrive)) {
            //Get joystick values
            double lr = -gamepad1.left_stick_x;
            double fb = -gamepad1.left_stick_y;
            double rot = -gamepad1.right_stick_x;

            if (gamepad1.right_trigger > .05) {
                lr = lr/2;
                fb = fb/2;
                rot = rot/2;

            }

            //Tell mecanumDrive what to do
            Robot.mecanumDrive.setDrivePowers(
                    new PoseVelocity2d(new Vector2d(fb, lr),rot));
        }

        if (!isBusy(Robot.slide)) {
            Robot.slide.setMotorSpeed(-gamepad2.left_stick_y);
        }

        if (!isBusy(Robot.thrower)) {
            Robot.thrower.setSpeed(-gamepad2.right_stick_y);
        }

        if (!isBusy(Robot.pivot)) {
            Robot.pivot.setMotorSpeed(gamepad2.left_trigger);
        }

        if (!isBusy(Robot.climb)) {
            Robot.climb.setMotorSpeed(gamepad2.right_trigger);
        }

        if (gamepad2.triangle) {
            runAction(Robot.pivot.pivotNinetyPosition(), Robot.pivot);
        }

        if (gamepad2.back) {
            cancelActions();
        }


    }
}
