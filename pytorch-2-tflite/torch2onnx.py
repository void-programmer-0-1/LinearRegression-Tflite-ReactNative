
import torch
from model import NeuralNetwork


def main():
  pytorch_model = NeuralNetwork()
  pytorch_model.load_state_dict(torch.load("./weights/linear_regression.pt"))
  pytorch_model.eval()
  dummy_input = torch.zeros(1,1)
  torch.onnx.export(pytorch_model,dummy_input,"./weights/linear_regression.onnx",
                   input_names=["input"],output_names=["output"],
                   opset_version=13,verbose=True)


if __name__ == '__main__':
  main()










