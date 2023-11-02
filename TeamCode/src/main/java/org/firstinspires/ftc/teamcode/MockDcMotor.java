package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MockDcMotor implements DcMotor{
    private ZeroPowerBehavior zeroPowerBehavior;
    private Direction direction;
    private double power;
    private RunMode runMode = null;

    public MotorConfigurationType getMotorType() {
        return null;
    }

    public void setMotorType(MotorConfigurationType motorType) {

    }

    public DcMotorController getController() {
        return null;
    }

    public int getPortNumber() {
        return 0;
    }

    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        this.zeroPowerBehavior = zeroPowerBehavior;
    }

    public ZeroPowerBehavior getZeroPowerBehavior() {
        return zeroPowerBehavior;
    }

    public void setPowerFloat() {
    }

    public boolean getPowerFloat() {
        return false;
    }

    public void setTargetPosition(int position) {
    }

    public int getTargetPosition() {
        return 0;
    }

    public boolean isBusy() {
        return false;
    }

    public int getCurrentPosition() {
        return 0;
    }

    public void setMode(RunMode mode) {
        this.runMode = mode;
    }

    public RunMode getMode() {
        return runMode;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public Manufacturer getManufacturer() {
        return null;
    }

    public String getDeviceName() {
        return null;
    }

    public String getConnectionInfo() {
        return null;
    }

    public int getVersion() {
        return 0;
    }

    public void resetDeviceConfigurationForOpMode() {

    }

    public void close() {

    }
}
