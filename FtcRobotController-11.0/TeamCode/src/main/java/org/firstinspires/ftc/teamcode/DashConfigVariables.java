package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;

@Config
public class DashConfigVariables extends BlocksOpModeCompanion {
    int Int1 = 0;
    int Int2 = 0;
    int Int3 = 0;
    int Int4 = 0;
    int Int5 = 0;

    @ExportToBlocks()
    public int ConfigInt1() {
        return Int1;
    }

    @ExportToBlocks()
    public int ConfigInt2() {
        return Int2;
    }

    @ExportToBlocks()
    public int ConfigInt3() {
        return Int3;
    }

    @ExportToBlocks()
    public int ConfigInt4() {
        return Int4;
    }

    @ExportToBlocks()
    public int ConfigInt5() {
        return Int5;
    }


    String String1 = "";
    String String2 = "";
    String String3 = "";
    String String4 = "";
    String String5 = "";

    @ExportToBlocks()
    public String ConfigString1() {return String1;}
    @ExportToBlocks()
    public String ConfigString2() {return String2;}
    @ExportToBlocks()
    public String ConfigString3() {return String3;}
    @ExportToBlocks()
    public String ConfigString4() {return String4;}
    @ExportToBlocks()
    public String ConfigString5() {return String5;}

}
