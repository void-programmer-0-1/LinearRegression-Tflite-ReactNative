
import numpy as np
import tensorflow as tf


interpreter = tf.lite.Interpreter(model_path="./weights/linear_regression.tflite")
interpreter.allocate_tensors()

input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()

input_shape = input_details[0]["shape"]
input_tensor = np.array([[3120]],dtype=np.float32)

interpreter.set_tensor(input_details[0]["index"],input_tensor)

interpreter.invoke()

output_data = interpreter.get_tensor(output_details[0]["index"]).item()
print(output_data)