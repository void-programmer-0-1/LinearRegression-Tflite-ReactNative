package com.tflearnregression;


import android.widget.Toast;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tflearnregression.ml.LinearRegression;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class LinearRegressionModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

    public LinearRegressionModule(ReactApplicationContext context){
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void show(String msg){
        Toast.makeText(getReactApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void linearRegression(String input){

        try {
            float tensorInput = Float.parseFloat(input);

            LinearRegression model = LinearRegression.newInstance(reactContext);

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 1}, DataType.FLOAT32);

            // (4 * 1 * 1) 4 for float datatype && 1 * 1 for row and col
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * 1 * 1);
            byteBuffer.order(ByteOrder.nativeOrder());
            byteBuffer.putFloat(tensorInput);

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            LinearRegression.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] predictions = outputFeature0.getFloatArray();
            this.show(String.valueOf(predictions[0]));

            // Releases model resources if no longer used.
            model.close();

        } catch (IOException e) {
            // TODO Handle the exception
            return;
        }

    }

    @NonNull
    @Override
    public String getName() {
        return "LinearRegressionModule";
    }
}
