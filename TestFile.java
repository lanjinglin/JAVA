package Part1;

import java.io.*;

import java.util.*;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Scanner scan = new Scanner(System.in);
			System.out.println("�������һ���ļ���·�����ļ���:");
			String path1 = scan.nextLine();
			System.out.println("������ڶ����ļ���·�����ļ���:");
			String path2 = scan.nextLine();
			System.out.println("��һ���ļ����ѧ������������ѧ�ɼ��ͼ�����ɼ�������֮���ÿո����:");
			System.out.println("�������һ���ļ�������,��finish����:");
			//Ϊ��һ���ļ�����д����
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
				//Ϊ��һ���ļ�����������
				FileReader inOne = new FileReader(f1);
				BufferedReader in = new BufferedReader(inOne);
				
				//Ϊ�ڶ����ļ�����д����
				File f2 = new File(path2);
				FileWriter out2 = new FileWriter(f2);
				String tempStr = null;
				while((tempStr = in.readLine()) != null)
				{
					if(tempStr.charAt(0) == '��')
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
				System.out.println("��������д���");
			}
	}
}
