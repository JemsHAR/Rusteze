package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.teamcode.util.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class LocalisationManager {

    private double lastMag;
    private double lastDir;

    private static AprilTagProcessor aprilTag;
    private static VisionPortal visionPortal;


    public static Vector2D adjustedvecnum;

    public static Vector2D apriltagvec;

    public static double poseBearing;
    public static Vector2D currentrobvec;

    public static HashMap<Integer, Vector2D> aprilTags = new HashMap<Integer, Vector2D>();


//    {{
//        put(0,new Vector2D(180,180,true));
//    }};


    public LocalisationManager(WebcamName Camera) { // e.g., camera may be h ardwareMap.get(WebcamName.class, "Webcam 1")
        aprilTags.put(1,new Vector2D(163,30,true));
        aprilTags.put(2,new Vector2D(178,30,true));
        aprilTags.put(3,new Vector2D(193,30,true));

        aprilTag = new AprilTagProcessor.Builder().build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        builder.setCamera(Camera);

        // initialise vision portal
        builder.addProcessor(aprilTag);

        visionPortal = builder.build();


    }

    public Vector2D processAprilTags(double adjustedYaw) {
        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if ((detection.metadata != null) && aprilTags.containsKey(detection.id)) {

                Vector2D aprilTagVec = aprilTags.get(detection.id); // april tag one
                apriltagvec = aprilTagVec;
                double m = Util.toCM(detection.ftcPose.range);
                double d = adjustedYaw - detection.ftcPose.bearing;

                lastMag = m;
                lastDir = d;


                Vector2D currentVec = new Vector2D(m,d,false);
                currentVec = currentVec.mul(new Vector2D(1, -1, true));                currentrobvec = currentVec;
                Vector2D adjustedVec = aprilTagVec.sub(currentVec);

                adjustedvecnum = adjustedVec;

                return adjustedVec;

            }
        }   // end for() loop

        return new Vector2D(0,0,false);
    }

    public String getDebug() {
        String debugMessage;

        debugMessage = "Last FTC Range: " + lastMag + " . Last FTC Dir " + lastDir + ". Last FTC Bearing: " + poseBearing;

        return debugMessage;
    }

}
