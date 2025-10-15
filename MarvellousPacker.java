import java.util.*;
import java.io.*;

public class Packer
{
	private String PacName;
	private String DirName;
	
	public Packer(String A, String B)
	{
		this.PacName = A;
		this.DirName = B;
	}
	
	public void PackingActivity()
	{
		try
		{
			System.out.println("------------------------------------------------------------------");
			System.out.println("--------------------Marvellous Packer Unpacker--------------------");
			System.out.println("------------------------------------------------------------------");
			System.out.println("-------------------------Packing Activity-------------------------");
			System.out.println("------------------------------------------------------------------");
			
			int i = 0, j = 0, iRet = 0, iCountFile = 0;
			
			File fobj = new File(DirName);
			
			// Check the existance of diractory
			if((fobj.exists()) && (fobj.isDirectory()))
			{
				System.out.println(DirName + "is Sucessfully opened...");
				
				File Packobj = new File(PacName);
			
				// Create a packed file
				boolean bRet = Packobj.createNewFile();
			
				if(bRet == false)
				{
					System.out.println("Unable to create file...");
					return;
				}
					
				System.out.println("Packed file gets sucessfully created with : "+PacName);					
				
				// Retrive all file from diractory
				File Arr[] = fobj.listFiles(); //Arr of files
				
				
				// Packed File Object
				FileOutputStream foobj = new FileOutputStream(Packobj);
				
				// Buffer for read and write activity
				byte Buffer[] = new byte[1024];
				
				String Header = null;
				
				// Directory Traversal
				for(i = 0; i< Arr.length;i++)
				{
					Header = Arr[i].getName() + " " + Arr[i].length();
				
					// Loop to form 100 byte header
					for(j = Header.length(); j < 100;j++)
					{
						Header = Header + " ";
					}
					
					// Write header into packed file
					foobj.write(Header.getBytes());
					
					// Open File From Directory For Reading
					FileInputStream fiobj = new FileInputStream(Arr[i]);
					
					// Write content of file into packed file
					while((iRet = fiobj.read(Buffer)) != -1)
					{
						foobj.write(Buffer,0,iRet);
						System.out.println("File name scanned is : "+Arr[i].getName());
						System.out.println("File size read is : "+iRet);
					}
					
					fiobj.close();
					iCountFile++;
				}
				System.out.println("Packing activity done...");

				System.out.println("-------------------------------------------------------------------");
				System.out.println("------------------------Stastical Report---------------------------");
				System.out.println("-------------------------------------------------------------------");
				
				//To be add
				System.out.println("Total file packed : "+iCountFile);
				
				System.out.println("-------------------------------------------------------------------");
				System.out.println("---------------Thank you for using our application-----------------");
				System.out.println("-------------------------------------------------------------------");
			}
			else
			{
				
				System.out.println("There is no such Directory...");
			}
			
		}// End of try
		catch(Exception eobj)
		{}
		
	}// End of packingActivity function
}// End of Marvellous class

class MarvellousPacker 
{
	public static void main(String A[])
	{
		try
		{
			Scanner sobj = new Scanner(System.in);

			System.out.println("Enter the name for the Paacked File : ");
			String PacName = sobj.nextLine();
			
			System.out.println("Enter the name of Directory for packing : ");
			String DirName = sobj.nextLine();
			
			Packer mobj = new Packer(PacName, DirName);
			mobj.PackingActivity();
		}
		catch(Exception eobj)
		{}
		
	}// End of main
}// End of Class