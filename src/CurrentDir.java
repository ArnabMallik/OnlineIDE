import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class CurrentDir
{
public static void main (String[] args) throws IOException
{

FileReader f=new FileReader("C:\\Users\\Abhishek\\workspace\\OnlineIDE\\src\\CurrentDir.java");
BufferedReader b=new BufferedReader(f);
String s;
while((s=b.readLine())!=null)
System.out.println(s);
f.close();
b.close();
}
}