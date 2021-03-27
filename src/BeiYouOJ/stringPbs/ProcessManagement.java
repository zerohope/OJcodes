package stringPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProcessManagement {
	public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));
    //存放进程
    Map<Integer,List<Integer>> mp=new HashMap<Integer, List<Integer>>();
	 int tms=sc.nextInt();
	 for(int i=0;i<tms;i++) {
		//建立初始进程
		mp.put(0, new ArrayList<Integer>());
		//记录操作数
		int ops=sc.nextInt();
		//吸收换行回车
		sc.nextLine();
		while(ops>0) {
		//读取指令，进去操作
      processOpt(mp,sc.nextLine());
		ops--;
		 }
		//清理进程集合，准备下一轮
	   mp.clear();
	 }
	sc.close();
	}
	
public static void processOpt(Map<Integer,List<Integer>> mp, String od) {
	    //根据空格拆分指令
		String[] ops=od.split(" ");
	   //若要求创建进程
		if(ops[0].equals("FORK")) {
			int father=Integer.parseInt(ops[1]);
			int son=Integer.parseInt(ops[2]);
			//若存在父进程，则直接向父进程添加子进程
			if(mp.containsKey(father)){
			mp.get(father).add(son);
			}else {
				//否则创建父进程并添加子进程
				List<Integer> sonList=new ArrayList<Integer>();
				sonList.add(son);
				mp.put(father,sonList);			
			}
			//创建子进程
			mp.put(son, new ArrayList<Integer>());
		} else if(ops[0].equals("KILL")) {
			int key=Integer.valueOf(ops[1]);
			//若存在待杀进程则杀掉
			if(mp.containsKey(key)&&key>0) {
				KillPro(mp,key);
			}
		}else if(ops[0].equals("QUERY")) {
		if(mp.containsKey(Integer.parseInt(ops[1]))) {
			System.out.println("Yes");
			}else {
			System.out.println("No");
			}
		}
		}
		
	
public static void KillPro(Map<Integer,List<Integer>> mp, int key) {

	//保存待杀进程的子进程
	List<Integer> son=mp.get(key);
	//删除要杀的进程
	mp.remove(key);
	//遍历子进程，都杀掉
	if(son.size()>0) {
      for(int i=0;i<son.size();i++) {
    	 if(mp.containsKey(son.get(i))) {
    	  KillPro(mp,son.get(i));
    	  }
      }
   } 
}

}
