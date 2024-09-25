package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.actions.MotorToPositionAction;

public class Thrower extends Subsystem{
    DcMotorEx motor;

    public Thrower(HardwareMap hardwareMap)
    {
        motor = hardwareMap.get(DcMotorEx.class, "motor1");
    }



    /**
     * Method that runs each time the opmode loops.
     * Usually, you will want to output telemetry here (encoder values and such).
     * Warning: Actions may be running, so generally you shouldn't control
     * actuators here, unless you are doing something fun like a state machine
     * (in which case you probably shouldn't control actuators outside of this method...).
     * Instead, have your autonomous run actions, and your teleop schedule actions or run methods
     * directly.
     *
     * @param p Telemetry packet for sending data to the driver hub / dashboard
     */
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("Thrower motor position ", motor.getCurrentPosition());
    }
    public void setSpeed(double speed)
    {
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(speed);
    }

    // Action to send motor to a position
    public Action goTo(int target)
    {
        return new MotorToPositionAction(motor, target, 5, 1.0);
    }
    public Action goHome()
    {
        return goTo(0);
    }


}
