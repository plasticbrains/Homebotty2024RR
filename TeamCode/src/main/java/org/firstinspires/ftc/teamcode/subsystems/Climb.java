package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climb extends  Subsystem{
    private DcMotorEx motor4;

    public Climb(HardwareMap hardwareMap) {
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        motor4.setDirection(DcMotorSimple.Direction.FORWARD);
        motor4.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Slide motor position ", motor4.getCurrentPosition());
    }
    public void setMotorSpeed(double speed)
    {
        motor4.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor4.setPower(speed);
    }

    // Action goes Here
}
