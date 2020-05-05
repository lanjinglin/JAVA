/*
 * �����ö������������ʵ�ֵ�
 * 
 * */
package Part1;

import java.io.*;
import java.util.*;

class Student implements Serializable
{
	String name;
	double computer;
	double math;
	public Student(String name,double math,double computer)
	{
		this.name = name;
		this.math = math;
		this.computer = computer;
	}

}

public class TestObjectStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("�������һ���ļ���·�����ļ���:");
			String path1 = scan.nextLine();
			System.out.println("������ڶ����ļ���·�����ļ���:");
			String path2 = scan.nextLine();
			System.out.println("��һ���ļ����ѧ������������ѧ�ɼ��ͼ�����ɼ�������֮���ÿո����:");
			//Ϊ��һ���ļ���������д��
			FileOutputStream fos1 = new FileOutputStream(path1);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		
			System.out.println("�������һ���ļ�������,��finish����:");
			String str = scan.next();
			while(!str.equals("finish"))
			{
				double math = scan.nextDouble();
				double com = scan.nextDouble();
				Student stu = new Student(str,math,com);
				oos1.writeObject(stu);
                str = scan.nextLine();//���ջس�
                str = scan.next();
			}
			oos1.writeObject(null);
			
			//�ȹرն�����,�ٹر��ļ���
			scan.close();
			oos1.close();
			fos1.close();
			
			System.out.println("��Щѧ����Ϣ�Ѿ�д���һ���ļ�");
			
			//Ϊ��һ���ļ��������󣬶�ȡ
			FileInputStream fis1 = new FileInputStream(path1);
			ObjectInputStream ois = new ObjectInputStream(fis1);
			
			//Ϊ�ڶ����ļ���������д��
			FileOutputStream fos2 = new FileOutputStream(path2);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			
			Student stu2 = (Student)ois.readObject();
			
			while(stu2 != null)
			{
				if(stu2.name.charAt(0) == '��')
				{
					oos2.writeObject(stu2);
					System.out.println(stu2.name+" "+stu2.math+" "+stu2.computer);
				}
				stu2 = (Student)ois.readObject();
			}
			
			ois.close();
			fis1.close();
			oos2.close();
			fos2.close();
			
		}catch(IOException e) {
			System.out.println("�����������");
		}catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
	}
}
