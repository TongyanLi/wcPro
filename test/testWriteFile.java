import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;


public class testWriteFile {
	public String getStr(){
		try {
	        File file = new File("result.txt");//定义一个file对象，用来初始化FileReader
	        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
	        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
	        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
	        String s = "";        
				while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
				    sb.append(s + "\r\n");//将读取的字符串添加换行符后累加存放在缓存中
				}				
				bReader.close();
			s = sb.toString();			
			return s;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void testWayWriteFile0() {
		countWord.writeFile("");
		String actStr = getStr();
		assertEquals("",actStr);
	}
	
	@Test
	public void testWayWriteFile1() {
		countWord.writeFile("abcdefg 199");
		String actStr = getStr();
		assertNotEquals("abcdefg 199",actStr);
	}
	
	@Test
	public void testWayWriteFile2() {
		countWord.writeFile("abcdefg 199\r\nabcdefg 188");
		String actStr = getStr();
		assertNotEquals("abcdefg 199\r\nabcdefg 188",actStr);
	}
	
	@Test
	public void testWayWriteFile3() {
		countWord.writeFile("abcdefg 199\r\n");
		String actStr = getStr();
		assertEquals("abcdefg 199\r\n",actStr);
	}
	
	@Test
	public void testWayWriteFile4() {
		countWord.writeFile("abcdefg 199\r\nabcdefg 188\r\n");
		String actStr = getStr();
		assertEquals("abcdefg 199\r\nabcdefg 188\r\n",actStr);
	}
	
	@Test
	public void testWayWriteFile5() {
		countWord.writeFile("abcdefg 199\r\nabcdefg 188abcdefg 177\r\n");
		String actStr = getStr();
		assertEquals("abcdefg 199\r\nabcdefg 188abcdefg 177\r\n",actStr);
	}
	
	@Test
	public void testWayWriteFile6() {
		String testStr = "";
		for(int i=0; i<100; i++){
			testStr = testStr + "abc" + i + " " + i + "\r\n";
		}
		countWord.writeFile(testStr);
		String actStr = getStr();
		assertEquals(testStr,actStr);
	}
	
	@Test
	public void testWayWriteFile7() {
		String testStr = "";
		for(int i=0; i<100; i++){
			testStr = testStr + "abc" + i + " " + i + "\r\n\r\n";
		}
		countWord.writeFile(testStr);
		String actStr = getStr();
		assertEquals(testStr,actStr);
	}
	
	@Test
	public void testWayWriteFile8() {
		countWord.writeFile("\r\n");
		String actStr = getStr();
		assertEquals("\r\n",actStr);
	}
	
	@Test
	public void testWayWriteFile9() {
		String testStr = "";
		for(int i=0; i<100; i++){
			testStr = testStr + "abc" + i + " " + i + "\n";
		}
		countWord.writeFile(testStr);
		String actStr = getStr();
		assertNotEquals(testStr,actStr);
	}	
}
