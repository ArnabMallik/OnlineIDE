package dao;

public class EditorFile {
	
	public static int id;
	
	public static String filepath;
	
	public static String filename;
	
	public static int count=0;
	
	public static void setid(int number) {
		
		id=number;
		
		filepath=Path.savepath+"\\temporary\\"+id;
	}
	
	public static int getid()
	{
		
		return id;
	}
	

	
public static void setpath(String filename) {
		
	
		if(!filepath.substring(filepath.lastIndexOf("\\")+1).equals(filename))
			
		filepath=filepath+"\\"+filename;
		
		
	
	
}
	
	public static String getpath()
	{
		
		return filepath;
	}
	

}
