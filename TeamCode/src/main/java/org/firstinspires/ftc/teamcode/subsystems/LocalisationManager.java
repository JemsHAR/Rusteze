package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class LocalisationManager {

    private static AprilTagProcessor aprilTag;
    private static VisionPortal visionPortal;

    static HashMap<Integer, Vector2D> aprilTags = new HashMap<Integer, Vector2D>()
    {{
        put(0,new Vector2D(180,180,true));
    }};


    public LocalisationManager(WebcamName Camera) { // e.g., camera may be hardwareMap.get(WebcamName.class, "Webcam 1")
        aprilTags.put(1,new Vector2D(43,100,true));
        aprilTags.put(2,new Vector2D(22,103,true));
        aprilTags.put(3,new Vector2D(234,30,true));

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

                double m = detection.ftcPose.range;
                double d = adjustedYaw - detection.ftcPose.bearing;

                Vector2D currentVec = new Vector2D(m,d,false);
                currentVec.add(aprilTagVec);

                return currentVec;


            } else {
                return new Vector2D(0,0,false);
            }
        }   // end for() loop

        return new Vector2D(0,0,false);
    }

}
