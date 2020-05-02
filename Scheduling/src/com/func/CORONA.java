package com.func;


import java.util.LinkedList;

import com.pro.Process;
public class CORONA extends Scheduling {
	int INFECTED = 5;
	public CORONA (int processorNum) {super(processorNum);}
	LinkedList<Process> waitQ2 = new LinkedList<Process>();
	public Process[] doScheduling() {
		
		int index=0;
		int isolation = 0;
		Process[] rePro = new Process[15];
		printProcessInfo();	//프로세스 정보 출력. 디버깅용
		if( processorNum  == 4)
			isolation = 2;
		else if(processorNum == 2 || processorNum == 3)
			isolation = 1;
		for (int time = 0; !isEnd(); time++) {
			setWaitQ(time);	//매 시간단위마다 도착한 프로세스를 대기큐에 넣어줍니다.
			if(isolation !=0) 
				for(int i = 0; i < waitQ.size(); i++) 
					if(waitQ.get(i).getBurTime() < INFECTED ) {
						waitQ2.add(waitQ.get(i));
						waitQ.remove(i);
					}
			for(int i=0;i<processorNum;i++) {	//프로세서의 개수만큼 반복
				if(checkRemain(time,i)) {		//프로세스가 끝났는지 검사합니다.
					rePro[index++]=processor[i];
					processor[i] = null;
				}
				if(processor[i]==null) {		//프로세서가 비어있을경우
						if((isolation !=0 && i < isolation)&&!waitQ.isEmpty())
							processor[i] = waitQ.pop();	//대기큐에서 프로세스를 가져옵니다.
						else if((isolation !=0 && i >= isolation)&&!waitQ2.isEmpty())
							processor[i] = waitQ2.pop();	//대기큐에서 프로세스를 가져옵니다.
						else if(isolation == 0 && !waitQ.isEmpty())
							processor[i] = waitQ.pop();
					}
				
				else processor[i].reduRemainTime();	//프로세서가 사용되고있으면 remain time을 감소시킵니다.
			}
	
			System.out.println(time);
		}
		return rePro;
	}
	
}