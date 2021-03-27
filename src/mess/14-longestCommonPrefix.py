
'''
遇到问题
没有考虑空集
没有考虑循环结束全匹配
循环写反
strs=[]
strs=["a"]
'''

strs=["abca","aba","aaab"]
end=0
sw=0
flag=len(strs[0])
for s in strs:
 if(len(s)<flag):
     flag=len(s)
for j in range(flag):     
 for i in range(len(strs)-1):
  if(strs[i][j]!=strs[i+1][j]):
    end=j
    sw=1
    break
 if(sw==1):
  break
print(sw,end)
if(sw==0 and end==0):
 end=flag
print(strs[0][0:end])