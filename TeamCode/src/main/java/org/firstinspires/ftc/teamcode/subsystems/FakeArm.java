package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.actions.MotorToPositionAction;
import org.firstinspires.ftc.teamcode.actions.ServoToPositionAction;

// example subsystem that contains one motor and one servo
public class FakeArm extends Subsystem {

    private DcMotorEx motor1;
    private Servo servo1;

    // set up the subsystem, using hardwareMap to initialize hardware
    public FakeArm(HardwareMap hardwareMap) {
        //set up motor
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // set up servo
        servo1 = hardwareMap.get(Servo.class, "servo1");
    }
    /**
     * Method that runs each time the opmode loops.
     * Usually, you will want to output telemetry here (encoder values and such).
     * Warning: Actions may be running, so generally you shouldn't control
     * actuators here, unless you are doing something fun like a state machin
     * (in which case you probably shouldn't control actuators outside of this method...).
     * Instead, have your autonomous run actions, and your teleop schedule actions or run methods
     * directly.
     * @param p Telemetry packet for sending data to the driver hub / dashboard
     */
    @Override
    public void periodic(TelemetryPacket p) {
        p.put("motor1 position", motor1.getCurrentPosition());
    }

    // Action that sends the motor to a specific encoder location
    public Action setMotorPosition(int target) {
        return new MotorToPositionAction(motor1, target, 5, 1);
    }

    // Send the motor to a common preset location, such as a scoring position
    public Action motorPresetPosition()
    {
        return setMotorPosition(0);
    }

    // Action to send the servo to a specific location
    public Action setServoPosition(double target)
    {
        return new ServoToPositionAction(servo1, target);
    }

    // Run motor at a certain power level. Use this to control with a joystick
    // On a real robot, you will probably want to use if statements to make sure
    // you don't crash the arm of the robot!
    public void setMotorSpeed(double power)
    {
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor1.setPower(power);
    }
}
