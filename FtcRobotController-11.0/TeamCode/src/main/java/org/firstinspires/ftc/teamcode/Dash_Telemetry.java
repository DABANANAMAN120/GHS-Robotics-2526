package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.Path;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class Dash_Telemetry extends BlocksOpModeCompanion {
    public static TelemetryPacket packet = new TelemetryPacket();
    public static FtcDashboard dashboard = FtcDashboard.getInstance();
    @ExportToBlocks()
    public static void Init_Telemetry (){
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        packet.fieldOverlay();
//                .setFill("blue")
//                .fillRect(-20, -20, 40, 40);
    }

    @ExportToBlocks()
    public static void Add_Number (String Label, Number Data){
        packet.put(Label, Data);
    }

    @ExportToBlocks()
    public static void Add_Text(String Label, String Data){
        packet.put(Label, Data);
    }

    @ExportToBlocks()
    public static void Send_Packet () {
        dashboard.sendTelemetryPacket(packet);
    }





    private static final double DEFAULT_RESOLUTION = 2.0; // distance units; presumed inches
    private static final double ROBOT_RADIUS = 9; // in

    @ExportToBlocks()
    public static void drawPoseHistory(Canvas canvas, List<Pose2d> poseHistory) {
        double[] xPoints = new double[poseHistory.size()];
        double[] yPoints = new double[poseHistory.size()];
        for (int i = 0; i < poseHistory.size(); i++) {
            Pose2d pose = poseHistory.get(i);
            xPoints[i] = pose.getX();
            yPoints[i] = pose.getY();
        }
        canvas.strokePolyline(xPoints, yPoints);
    }

    @ExportToBlocks()
    public static void drawSampledPath(Path path) {
        int samples = (int) Math.ceil(path.length() / DEFAULT_RESOLUTION);
        double[] xPoints = new double[samples];
        double[] yPoints = new double[samples];
        double dx = path.length() / (samples - 1);
        for (int i = 0; i < samples; i++) {
            double displacement = i * dx;
            Pose2d pose = path.get(displacement);
            xPoints[i] = pose.getX();
            yPoints[i] = pose.getY();
        }
        packet.fieldOverlay().strokePolyline(xPoints, yPoints);
    }

    @ExportToBlocks
    public static void drawRobot(Pose2d pose) {
        packet.fieldOverlay().strokeCircle(pose.getX(), pose.getY(), ROBOT_RADIUS);
        Vector2d v = pose.headingVec().times(ROBOT_RADIUS);
        double x1 = pose.getX() + v.getX() / 2, y1 = pose.getY() + v.getY() / 2;
        double x2 = pose.getX() + v.getX(), y2 = pose.getY() + v.getY();
        packet.fieldOverlay().strokeLine(x1, y1, x2, y2);
    }


}
