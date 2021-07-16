import math
K=int(input())
d=1
for i in range(K):
    key, value = list(map(int, input().strip().split()))
    if key==1:
        d+=value
    elif key==2:
        d*=value
    else:
        d=math.ceil(d/value)
print(d)    
