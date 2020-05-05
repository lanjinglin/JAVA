package Part2;

import java.io.*;
import java.util.*;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ������ļ���:");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		
		String newstr = "��ɽ";
		
		System.out.println("�������������:\n1.���� "+ path+" �� �����������ơ� ��Ϊ ����ɽ�� ��\n"
				+ "2.�ڡ� " + path +" �� ��ԭ����Ϣ֮��������ѧ����Ϣ��");
		try {
			RandomAccessFile raf = new RandomAccessFile(path,"rw");
			long lastPoint = 0;
			String line;
			while((line = raf.readLine()) != null)
			{
				final long currentPoint = raf.getFilePointer();
				
				//ֱ����readLine()������������ʾ�����������룬��Ҫת��������;
				byte[] b = line.getBytes("ISO-8859-1");
				String s = new String(b);
				//System.out.println(s);
				if(s.charAt(0) == '��' && s.charAt(1) == '��')
				{
					//��λ��Ҫ�ĵ�λ��
					raf.seek(lastPoint);
					raf.write(newstr.getBytes());
				}
				lastPoint = currentPoint;
			}
			System.out.println("�ļ� �� "+ path+" �� �е����� �� ���� �� �Ѿ���Ϊ�� ��ɽ ��������ģ�");
			System.out.println("��������ļ� �� " + path + " �� ������µ�ѧ����Ϣ,��finish����:");
			String msg = scan.nextLine();
			while(!msg.equals("finish"))
			{
				raf.write(msg.getBytes());
				raf.write((int)'\r');
				raf.write((int)'\n');
				msg = scan.nextLine();
			}
			System.out.println("�����ѧ����Ϣ�Ѿ�д���ļ� �� " +path+" �� ��");
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
