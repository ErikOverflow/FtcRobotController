package org.firstinspires.ftc.teamcode;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.config.ValueProvider;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.function.Consumer;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.slf4j.helpers.Util;

import java.sql.Array;
import java.util.concurrent.atomic.AtomicReference;

@Config
@Autonomous(name="FtcDashboard ColorMasking", group="Linear")
public class FtcDashboard_ColorMasking extends LinearOpMode {
    public static boolean MASK_TOGGLE = false;
    public static Scalar skinColor_low = new Scalar(100,100,100,0);
    public static Scalar skinColor_high = new Scalar(255,255,255,255);
    //Talk Volatile vs AtomicReference, final to make sure it is only initialized once, etc.
    public static class CameraStreamProcessor implements VisionProcessor, CameraStreamSource{

        Mat peopleMask = new Mat();
        private final AtomicReference<Bitmap> lastFrame = new AtomicReference<>(Bitmap.createBitmap(1,1, Bitmap.Config.RGB_565));
        private final AtomicReference<Bitmap> peopleMaskedFrame = new AtomicReference<>(Bitmap.createBitmap(1,1, Bitmap.Config.RGB_565));

        @Override
        public void getFrameBitmap(Continuation<? extends Consumer<Bitmap>> continuation) {
            continuation.dispatch(bitmapConsumer -> bitmapConsumer.accept(lastFrame.get()));
        }

        public Bitmap getMaskedFrameBitmap(){
            return peopleMaskedFrame.get();
        }
        public Bitmap getLastFrame(){
            return lastFrame.get();
        }

        @Override
        public void init(int width, int height, CameraCalibration cameraCalibration) {
            lastFrame.set(Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565));
        }

        @Override
        public Object processFrame(Mat frame, long captureTimeNanos) {
            Bitmap b = Bitmap.createBitmap(frame.width(), frame.height(), Bitmap.Config.RGB_565);
            Utils.matToBitmap(frame, b);
            lastFrame.set(b);
            Scalar mean = Core.mean(frame);


            Core.inRange(frame, skinColor_low, skinColor_high,peopleMask);
            Bitmap b_peopleMask = Bitmap.createBitmap(frame.width(), frame.height(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(peopleMask, b_peopleMask);
            peopleMaskedFrame.set(b_peopleMask);
            return null;
        }

        @Override
        public void onDrawFrame(Canvas canvas, int i, int i1, float v, float v1, Object o) {

        }
    }
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        final CameraStreamProcessor processor = new CameraStreamProcessor();

        new VisionPortal.Builder().
                addProcessor(processor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .build();
        waitForStart();

        while(opModeIsActive()){
            if(MASK_TOGGLE){
                FtcDashboard.getInstance().sendImage(processor.getMaskedFrameBitmap());
            } else{
                FtcDashboard.getInstance().sendImage(processor.getLastFrame());
            }
            sleep(100);
        }
    }
}
