package org.firstinspires.ftc.teamcode.teleops;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
//wifi 4381442210024
@TeleOp(name="My Teleop")
public class Teleop1 extends ActionSchedulerOpMode{

    @Override
    public void initOpMode() {

    }

    @Override
    public void loopOpMode(TelemetryPacket p) {

        if (!isBusy(Robot.mecanumDrive)) {
            Robot.mecanumDrive.setDrivePowers(
                    new PoseVelocity2d(new Vector2d(gamepad1.left_stick_x, gamepad1.left_stick_y),gamepad1.right_stick_y));
        }


    }
}
