import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
public class countWord {
	static String outStr;
	
	public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      String com=scan.nextLine();
        //利用正则表达式检查用户命令行输入参数是否正确
        String pattern = "wcPro.exe .+(\\.)txt";
        boolean isMatch = Pattern.matches(pattern, com);
        //表达式正确则跳出循环，否则继续接受用户输入
        if(isMatch){
          count tar=new count(com.replace("wcPro.exe ",""));
          tar.countWord();
          //lty 
          ArrayList<word> resultArray = tar.getWordArray();
          StringBuilder output = new StringBuilder();
          for(int i=0; i<resultArray.size(); i++){
            if(i == resultArray.size()-1)
              output.append(resultArray.get(i).word + " " + resultArray.get(i).num);
            else
              output.append(resultArray.get(i).word + " " + resultArray.get(i).num + "\r\n");
          }
          outStr = output.toString();
          writeFile(outStr);
        }
    }
     //输出结果文件
     public static void writeFile(String content){
        BufferedWriter bw = null;
      try {  
          File file = new File("result.txt");//将要输出的文件所在地址  
          if (!file.exists()) {  
              file.createNewFile();  
          }  
          FileWriter fw = new FileWriter(file.getAbsoluteFile());  
          bw = new BufferedWriter(fw);  
          bw.write(content);  
          bw.close();  
      } catch (IOException e) {  
          e.printStackTrace();  
      }
    }
}
