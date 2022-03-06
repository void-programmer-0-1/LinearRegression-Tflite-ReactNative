
import tensorflow as tf

converter = tf.lite.TFLiteConverter.from_saved_model("./weights/linear_regression/")
tflite_model = converter.convert()

with open("./weights/linear_regression.tflite","wb") as f:
    f.write(tflite_model)

