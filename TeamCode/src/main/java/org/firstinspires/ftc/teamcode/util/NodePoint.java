package org.firstinspires.ftc.teamcode.util;
import org.firstinspires.ftc.teamcode.util.Vector2D;
import java.util.ArrayList;
public class NodePoint {
    private double orientation;
    private double velocity;
    private Vector2D node;

    public NodePoint(Vector2D nodePos, double Aorientation) {
        node = nodePos;
        orientation = Aorientation;
    }

    public Vector2D getVector() {
        return node;
    }

    public double getOrientation() { return orientation; }




}
