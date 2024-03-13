package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MockDcMotor implements DcMotor {
    private ZeroPowerBehavior zeroPowerBehavior = ZeroPowerBehavior.FLOAT;
    private Direction direction = Direction.FORWARD;
    private double power = 0;
    private RunMode runMode = null;
    private Telemetry telemetry = null;

    public MockDcMotor(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public MockDcMotor() {

    }

    public MotorConfigurationType getMotorType() {
        return null;
    }

    @Override
    public void setMotorType(MotorConfigurationType motorConfigurationType) {
    }

    public DcMotorController getController() {
        return null;
    }

    public int getPortNumber() {
        return 0;
    }

    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        this.zeroPowerBehavior = zeroPowerBehavior;
        if(telemetry != null)
            telemetry.addData(this.getDeviceName() + "_zeroPowerBehavior", this.zeroPowerBehavior.toString());
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
        if(telemetry != null)
            telemetry.addData(this.getDeviceName() + "_runMode", this.runMode.toString());
    }

    public RunMode getMode() {
        return runMode;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        if(telemetry != null)
            telemetry.addData(this.getDeviceName() + "_direction", this.direction.toString());
    }
    public Direction getDirection() {
        return direction;
    }

    public void setPower(double power) {

        this.power = power;
        if(telemetry != null)
            telemetry.addData(this.getDeviceName() + "_power", this.power);
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
