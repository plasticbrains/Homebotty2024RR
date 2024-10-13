package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.Robot.pivot;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.actions.MotorToPositionAction;

public class Pivot extends Subsystem {
    private DcMotorEx pivot;

    public Pivot(HardwareMap hardwareMap) {
        pivot = hardwareMap.get(DcMotorEx.class, "motor3");
        pivot.setDirection(DcMotorSimple.Direction.FORWARD);
        pivot.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
    }
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Pivot motor position ", pivot.getCurrentPosition());
    }
    public void setMotorSpeed(double speed)
    {
        pivot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        pivot.setPower(speed);
    }

    // Action Goes here
    public Action setMotorPosition(int target) {
        return new MotorToPositionAction(pivot, target,5,1);
    }
    public Action pivotNinetyPosition()
    {
        return setMotorPosition(620);
    }
}
