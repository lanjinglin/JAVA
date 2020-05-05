package Part2;

import java.io.*;
import java.util.*;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入要处理的文件名:");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		
		String newstr = "王山";
		
		System.out.println("本程序的任务是:\n1.将“ "+ path+" ” 中姓名“李善” 改为 “王山” 。\n"
				+ "2.在“ " + path +" ” 中原有信息之后继续添加学生信息。");
		try {
			RandomAccessFile raf = new RandomAccessFile(path,"rw");
			long lastPoint = 0;
			String line;
			while((line = raf.readLine()) != null)
			{
				final long currentPoint = raf.getFilePointer();
				
				//直接用readLine()方法读中文显示出来的是乱码，需要转换成中文;
				byte[] b = line.getBytes("ISO-8859-1");
				String s = new String(b);
				//System.out.println(s);
				if(s.charAt(0) == '李' && s.charAt(1) == '善')
				{
					//定位到要改的位置
					raf.seek(lastPoint);
					raf.write(newstr.getBytes());
				}
				lastPoint = currentPoint;
			}
			System.out.println("文件 “ "+ path+" ” 中的姓名 “ 李善 ” 已经改为“ 王山 ”，请查阅！");
			System.out.println("请继续向文件 “ " + path + " ” 中添加新的学生信息,以finish结束:");
			String msg = scan.nextLine();
			while(!msg.equals("finish"))
			{
				raf.write(msg.getBytes());
				raf.write((int)'\r');
				raf.write((int)'\n');
				msg = scan.nextLine();
			}
			System.out.println("输入的学生信息已经写入文件 “ " +path+" ” 中");
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
