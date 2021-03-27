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
    //��Ž���
    Map<Integer,List<Integer>> mp=new HashMap<Integer, List<Integer>>();
	 int tms=sc.nextInt();
	 for(int i=0;i<tms;i++) {
		//������ʼ����
		mp.put(0, new ArrayList<Integer>());
		//��¼������
		int ops=sc.nextInt();
		//���ջ��лس�
		sc.nextLine();
		while(ops>0) {
		//��ȡָ���ȥ����
      processOpt(mp,sc.nextLine());
		ops--;
		 }
		//������̼��ϣ�׼����һ��
	   mp.clear();
	 }
	sc.close();
	}
	
public static void processOpt(Map<Integer,List<Integer>> mp, String od) {
	    //���ݿո���ָ��
		String[] ops=od.split(" ");
	   //��Ҫ�󴴽�����
		if(ops[0].equals("FORK")) {
			int father=Integer.parseInt(ops[1]);
			int son=Integer.parseInt(ops[2]);
			//�����ڸ����̣���ֱ���򸸽�������ӽ���
			if(mp.containsKey(father)){
			mp.get(father).add(son);
			}else {
				//���򴴽������̲�����ӽ���
				List<Integer> sonList=new ArrayList<Integer>();
				sonList.add(son);
				mp.put(father,sonList);			
			}
			//�����ӽ���
			mp.put(son, new ArrayList<Integer>());
		} else if(ops[0].equals("KILL")) {
			int key=Integer.valueOf(ops[1]);
			//�����ڴ�ɱ������ɱ��
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

	//�����ɱ���̵��ӽ���
	List<Integer> son=mp.get(key);
	//ɾ��Ҫɱ�Ľ���
	mp.remove(key);
	//�����ӽ��̣���ɱ��
	if(son.size()>0) {
      for(int i=0;i<son.size();i++) {
    	 if(mp.containsKey(son.get(i))) {
    	  KillPro(mp,son.get(i));
    	  }
      }
   } 
}

}
