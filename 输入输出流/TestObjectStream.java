/*
 * 这是用对象输入输出流实现的
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
			System.out.println("请输入第一个文件的路径和文件名:");
			String path1 = scan.nextLine();
			System.out.println("请输入第二个文件的路径和文件名:");
			String path2 = scan.nextLine();
			System.out.println("第一个文件存放学生的姓名，数学成绩和计算机成绩，各项之间用空格隔开:");
			//为第一个文件创建对象，写入
			FileOutputStream fos1 = new FileOutputStream(path1);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		
			System.out.println("请输入第一个文件的内容,以finish结束:");
			String str = scan.next();
			while(!str.equals("finish"))
			{
				double math = scan.nextDouble();
				double com = scan.nextDouble();
				Student stu = new Student(str,math,com);
				oos1.writeObject(stu);
                str = scan.nextLine();//吸收回车
                str = scan.next();
			}
			oos1.writeObject(null);
			
			//先关闭对象流,再关闭文件流
			scan.close();
			oos1.close();
			fos1.close();
			
			System.out.println("这些学生信息已经写入第一个文件");
			
			//为第一个文件创建对象，读取
			FileInputStream fis1 = new FileInputStream(path1);
			ObjectInputStream ois = new ObjectInputStream(fis1);
			
			//为第二个文件创建对象，写入
			FileOutputStream fos2 = new FileOutputStream(path2);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			
			Student stu2 = (Student)ois.readObject();
			
			while(stu2 != null)
			{
				if(stu2.name.charAt(0) == '张')
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
			System.out.println("输入输出错误！");
		}catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
	}
}
