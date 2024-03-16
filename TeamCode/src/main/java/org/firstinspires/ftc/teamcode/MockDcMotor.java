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
    private RunMode runMode = RunMode.RUN_WITHOUT_ENCODER;
    private String deviceName = null;
    private Telemetry telemetry = null;
    Telemetry.Item telemetry_zeroPowerBehavior = null;
    Telemetry.Item telemetry_direction = null;
    Telemetry.Item telemetry_power = null;
    Telemetry.Item telemetry_runMode = null;

    public MockDcMotor(Telemetry telemetry, String deviceName) {
        this.deviceName = deviceName;
        telemetry_zeroPowerBehavior = telemetry.addData(this.getDeviceName() + "_zeroPowerBehavior", this.zeroPowerBehavior.toString());
        telemetry_direction = telemetry.addData(this.getDeviceName() + "_direction", this.direction.toString());
        telemetry_power = telemetry.addData(this.getDeviceName() + "_power", this.power);
        telemetry_runMode = telemetry.addData(this.getDeviceName() + "_runMode", this.runMode.toString());
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
        if(telemetry_zeroPowerBehavior != null) {
            telemetry_zeroPowerBehavior.setValue(this.zeroPowerBehavior.toString());
            telemetry.update();
        }
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
        if(telemetry_runMode != null){
            telemetry_runMode.setValue(this.runMode.name());
            telemetry.update();
        }

    }

    public RunMode getMode() {
        return runMode;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        if(telemetry_direction != null) {
            telemetry_direction.setValue(this.direction.toString());
            telemetry.update();
        }
    }
    public Direction getDirection() {
        return direction;
    }

    public void setPower(double power) {
        this.power = power;
        if(telemetry_power != null) {
            telemetry_power.setValue(this.power);
        }
    }

    public double getPower() {
        return power;
    }

    public Manufacturer getManufacturer() {
        return null;
    }

    public String getDeviceName() {
        return deviceName;
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
