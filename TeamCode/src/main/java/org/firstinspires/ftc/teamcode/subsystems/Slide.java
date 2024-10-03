package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slide extends Subsystem {
    private DcMotorEx motor2;

    public Slide(HardwareMap hardwareMap) {
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Slide motor position ", motor2.getCurrentPosition());
    }
    public void setMotorSpeed(double speed)
    {
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setPower(speed);
    }

    // Action goes here
}
