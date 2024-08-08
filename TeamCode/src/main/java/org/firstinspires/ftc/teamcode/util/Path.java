package org.firstinspires.ftc.teamcode.util;

import java.util.ArrayList;

public class Path {
    ArrayList<NodePoint> nodePath;



    public void addNode(NodePoint node) {
        nodePath.add(node);
    } //so, there'll be a new instance of path for each path, and they can add nodes
    public void progressQueue() {
        nodePath.remove(0);
    }

    public NodePoint getNode(int current) {
        return nodePath.get(current);
    }

    public ArrayList<NodePoint> getNodes() {
        return nodePath;
    }
}
