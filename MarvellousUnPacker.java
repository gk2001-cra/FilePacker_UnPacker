import java.util.*;
import java.io.*;

public class Unpacker
{
	private String PacName;
	
	public Unpacker(String A)
	{
		this.PacName = A;
	}
	
	public void UnpackingActivity()
	{
		
		try
		{
			System.out.println("------------------------------------------------------------------");
			System.out.println("--------------------Marvellous Packer Unpacker--------------------");
			System.out.println("------------------------------------------------------------------");
			System.out.println("-------------------------UnPacking Activity-------------------------");
			System.out.println("------------------------------------------------------------------");
			
			String Header = null;
			File fobjnew = null;
			int FileSize = 0, iRet = 0, iCountFile = 0;
			
			File fobj = new File(PacName);
			
			// If packed is not present
			if(!fobj.exists())
			{
				System.out.println("Unable to access packed file");
				return;
			}
			
			System.out.println("Packed file is opened");
			
			FileInputStream fiobj = new FileInputStream(fobj);
			
			// Buffer to read the header
			byte HeaderBuffer[] = new byte[100];
			
			// Scan the packed file to extract the file from it
			while((iRet = fiobj.read(HeaderBuffer,0,100)) != -1)
			{		
				// Convert byte array to string
				Header = new String(HeaderBuffer);
						
				Header = Header.trim();
			
				// Tokanize the header into two parts
				String Tokens[] = Header.split(" ");
			
				fobjnew = new File(Tokens[0]);
				
				//Create new file to extract
				fobjnew.createNewFile();
				
				FileSize = Integer.parseInt(Tokens[1]);
			
				// Create new buffer to store files data
				byte Buffer[] = new byte[FileSize];
			
				FileOutputStream foobj = new FileOutputStream(fobjnew);
			
				// Read the data from packed file
				fiobj.read(Buffer,0,FileSize);
				
				// Write the data into extracted file
				foobj.write(Buffer,0,FileSize);
				
				System.out.println("File unpacked with name : "+Tokens[0]+" having size "+FileSize);
				
				iCountFile++;
				
				foobj.close();
				
			}// End of while
			
			System.out.println("-------------------------------------------------------------------");
			System.out.println("------------------------Stastical Report---------------------------");
			System.out.println("-------------------------------------------------------------------");
			
			System.out.println("Total number of files unpacked : "+iCountFile);
			
			System.out.println("-------------------------------------------------------------------");
			System.out.println("---------------Thank you for using our application-----------------");
			System.out.println("-------------------------------------------------------------------");
			
			fiobj.close();
		}
		catch(Exception eobj)
		{}	
		
	}// End of function
	
}

class MarvellousUnpacker 
{
	public static void main(String A[])
	{
		try
		{
			Scanner sobj = new Scanner(System.in);

			System.out.println("Enter the name of file which contains packed data : ");
			String PacName = sobj.nextLine();
			
			Unpacker mobj = new Unpacker(PacName);
			mobj.UnpackingActivity();
		}
		catch(Exception eobj)
		{}
		
	}// End of main
}// End of Class