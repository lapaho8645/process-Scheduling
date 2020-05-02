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
		printProcessInfo();	//���μ��� ���� ���. ������
		if( processorNum  == 4)
			isolation = 2;
		else if(processorNum == 2 || processorNum == 3)
			isolation = 1;
		for (int time = 0; !isEnd(); time++) {
			setWaitQ(time);	//�� �ð��������� ������ ���μ����� ���ť�� �־��ݴϴ�.
			if(isolation !=0) 
				for(int i = 0; i < waitQ.size(); i++) 
					if(waitQ.get(i).getBurTime() < INFECTED ) {
						waitQ2.add(waitQ.get(i));
						waitQ.remove(i);
					}
			for(int i=0;i<processorNum;i++) {	//���μ����� ������ŭ �ݺ�
				if(checkRemain(time,i)) {		//���μ����� �������� �˻��մϴ�.
					rePro[index++]=processor[i];
					processor[i] = null;
				}
				if(processor[i]==null) {		//���μ����� ����������
						if((isolation !=0 && i < isolation)&&!waitQ.isEmpty())
							processor[i] = waitQ.pop();	//���ť���� ���μ����� �����ɴϴ�.
						else if((isolation !=0 && i >= isolation)&&!waitQ2.isEmpty())
							processor[i] = waitQ2.pop();	//���ť���� ���μ����� �����ɴϴ�.
						else if(isolation == 0 && !waitQ.isEmpty())
							processor[i] = waitQ.pop();
					}
				
				else processor[i].reduRemainTime();	//���μ����� ���ǰ������� remain time�� ���ҽ�ŵ�ϴ�.
			}
	
			System.out.println(time);
		}
		return rePro;
	}
	
}