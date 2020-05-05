package Part1;

import java.io.*;

import java.util.*;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入第一个文件的路径和文件名:");
			String path1 = scan.nextLine();
			System.out.println("请输入第二个文件的路径和文件名:");
			String path2 = scan.nextLine();
			System.out.println("第一个文件存放学生的姓名，数学成绩和计算机成绩，各项之间用空格隔开:");
			System.out.println("请输入第一个文件的内容,以finish结束:");
			//为第一个文件创建写对象
			File f1 = new File(path1);
			try {
				FileWriter out1 = new FileWriter(f1);
				String str = scan.nextLine();
				while(!str.equals("finish"))
				{
					out1.write(str);
					out1.write((int)'\r');
                    out1.write((int)'\n');
                    str = scan.nextLine();
				}
				
				scan.close();
				out1.close();
				//为第一个文件创建读对象
				FileReader inOne = new FileReader(f1);
				BufferedReader in = new BufferedReader(inOne);
				
				//为第二个文件创建写对象
				File f2 = new File(path2);
				FileWriter out2 = new FileWriter(f2);
				String tempStr = null;
				while((tempStr = in.readLine()) != null)
				{
					if(tempStr.charAt(0) == '张')
					{
						out2.write(tempStr);
						out2.write((int)'\r');
						out2.write((int)'\n');
						System.out.println(tempStr);
					}
				}
				in.close();
				inOne.close();
				out2.close();
			}catch(IOException ioe) {
				System.out.println("输入输出有错误");
			}
	}
}
