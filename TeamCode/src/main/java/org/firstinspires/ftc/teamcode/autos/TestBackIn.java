package org.firstinspires.ftc.teamcode.autos;


import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Test Back In")
public class TestBackIn extends ActionAutonomous{
    /**
     * Opmodes should define the action to be taken during autonomous here.
     * Usually, this should be done using org.firstinspires.ftc.teamcode.Robot.mecanumDrive's actionBuilder
     *
     * @return an Action representing autonomous (probably built by TrajectoryActionBuilder in
     */
    @Override
    public Action autonomousActions() {
        return Robot.mecanumDrive.actionBuilder(new Pose2d(35.43, -60.44, Math.toRadians(90.00)))
                .strafeTo(new Vector2d(35.43, -60.44))
                .strafeTo(new Vector2d(35.62, -12.57))
                .build();



    }

    /**
     * Return a reference to your robot's drivetrain in this function.
     * This will be used to set the starting pose.
     */
    @Override
    public MecanumDrive getDrivetrain() {
        return Robot.mecanumDrive;
    }

    /**
     * This function should return your robot's starting position for this autonomous.
     * This will only be used if this opmode is actually run, and ignored if
     * this auto is used in other opmodes.
     */
    @Override
    public Pose2d getStartingPose() {
        return new Pose2d(35.43, -60.44, Math.toRadians(90.00));

    }
}
