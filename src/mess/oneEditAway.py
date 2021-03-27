class Solution:
 def oneEditAway(self, first: str, second: str) -> bool:
  def testdelete(long:str, short:str):
   if(short=="" or long==""):
    return True
   j=0
   flag=0
   for i in range(len(long)):
    if(j==len(short)):
     break
    if(long[i]==short[j]):
     j=j+1  
    else:
     flag+=1
    if flag>1:
     return False  
   return True 
  if(len(first)-len(second)>1 or len(first)-len(second)<-1):
    return False
  if(len(first)-len(second)==1):
    return  testdelete(first,second)
  
  if(len(first)-len(second)==-1):
    return  testdelete(second,first)
  flag=0
  for i in range(len(first)):
   if(first[i]!=second[i]):  
      flag+=1
   if(flag>1):
     return False
  return True  

 