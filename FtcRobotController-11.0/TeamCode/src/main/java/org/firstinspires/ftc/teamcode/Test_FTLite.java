/*
package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class Test_FTLite extends BlocksOpModeCompanion {

    // 👇 Holds the Interpreter statically
    private static Interpreter tflite;

    // 👇 Call this once before OpMode starts (in INIT loop or init phase)
    @ExportToBlocks()
    public static void loadModel(HardwareMap hardwareMap) {
        if (tflite != null) return; // already loaded

        try {
            Context context = hardwareMap.appContext;
            MappedByteBuffer modelBuffer = loadModelFile(context, "model.tflite");
            tflite = new Interpreter(modelBuffer);
        } catch (IOException e) {
            // You can’t use telemetry here. Store errors in a static string if needed.
            e.printStackTrace();
        }
    }

    // 👇 Run the model from a MyBlock
    @ExportToBlocks()
    public static float runModel(float input0, float input1, float input2) {
        if (tflite == null) return -1;

        float[][] input = new float[1][3];  // Adjust size to match model input
        input[0][0] = input0;
        input[0][1] = input1;
        input[0][2] = input2;

        float[][] output = new float[1][1]; // Adjust to your model output shape
        tflite.run(input, output);

        return output[0][0];
    }

    // 👇 Helper method to read from assets
    private static MappedByteBuffer loadModelFile(Context context, String modelFileName) throws IOException {
        AssetFileDescriptor fileDescriptor = context.getAssets().openFd(modelFileName);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
}

*/
