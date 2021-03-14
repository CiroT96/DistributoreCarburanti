import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Classe Gestione File
public class GestioneFile 
{
	@SuppressWarnings("resource")
	public String LetturaDati(String f) throws IOException
	{
		    FileReader reader  = new FileReader(f);
		    Scanner in = new Scanner(reader);
		    String line;
		    line = in.nextLine();
			return line;   
	}
	
	@SuppressWarnings("resource")
	public void ScritturaDati(String f,String v ) throws IOException
	{
		FileWriter w = new FileWriter(f);
		w.write(v);
		w.flush();
	}
}
