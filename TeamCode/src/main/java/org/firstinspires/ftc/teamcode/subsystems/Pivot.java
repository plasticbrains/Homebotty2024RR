package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Pivot extends Subsystem {
    private DcMotorEx motor3;

    public Pivot(HardwareMap hardwareMap) {
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor3.setDirection(DcMotorSimple.Direction.FORWARD);
        motor3.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
    }
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Pivot motor position ", motor3.getCurrentPosition());
    }
    public void setMotorSpeed(double speed)
    {
        motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor3.setPower(speed);
    }

    // Action Goes here
}
