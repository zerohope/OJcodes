import torch

# a=torch.tensor([[1.,2.,3.],[4.,5.,6.]])
# print(torch.softmax(a,dim=1))
# c = torch.Tensor([[[1,2,3], [4,5,6]], [[7,8,9], [10,11,12]]])    # shape (2,2,3)
# print( torch.softmax(c, dim=2))
print(torch.softmax(torch.tensor([[1.,8.,10.]]), dim=1).max(1)) 
# print(1e-4)