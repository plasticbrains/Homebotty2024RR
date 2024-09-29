package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

//Sam's example of continous servo

public class SpinningServo extends Subsystem {

    // Variable to hold our servo
    private CRServo servo;

    // Constructor
    public SpinningServo(HardwareMap hardwareMap)
    {
        servo = hardwareMap.get(CRServo.class, "crservo1");
        servo.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    // Set the speed. NOT an action!
    public void setSpeed(double speed)
    {
        servo.setPower(speed);
    }

    // Action to set the speed to a specific value
    public Action setSpeedAction(double speed)
    {
        return new InstantAction(() -> {
            setSpeed(speed);
        });
    }

    // Sequence to spit a thing out
    public Action spitOut()
    {
        return new SequentialAction(
                setSpeedAction(-1),
                new SleepAction(1),
                setSpeedAction(0)
        );
    }



    @Override
    public void periodic(TelemetryPacket p) {
        p.put("crservo1 data", servo.getPower());
    }

}
