package mess;

public class TestExample {
    boolean loginSucceed=true,isAdmin,isUser,isGuest;

     void systemAccess(){
        if(loginSucceed){
            if(isAdmin){
                browse();
                comment();
                authorityManagement();
            }else if(isUser){
                browse();
                comment();
            }else if(isGuest){
                browse();
            }
        }else{
            loginFailed();
        }
    }



  void loginFailed(){};
  void browse(){};

  void comment(){};

  void authorityManagement(){};








}
