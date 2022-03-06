
import onnx
from onnx_tf.backend import prepare

onnx_model = onnx.load("./weights/linear_regression.onnx")  
tf_rep = prepare(onnx_model)  # prepare tf representation
tf_rep.export_graph("./weights/linear_regression/")  # export the model (SavedModel format)




