package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slide extends Subsystem {
    DcMotorEx motor;

    public Slide(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "motor2");
    }
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Slide motor position ", motor.getCurrentPosition());
    }
    public void setMotorSpeed(double speed)
    {
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(speed);
    }

    // Action goes here
}
