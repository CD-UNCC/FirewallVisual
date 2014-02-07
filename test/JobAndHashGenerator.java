import java.util.*;
import java.io.*;

public class JobAndHashGenerator{
	public static void main(String args[]) throws IOException{
		File jobFile = new File("Jobs.txt");
		File hashFile = new File("Bad_Hashes.txt");
		
		jobGenerator(jobFile);
		hashGenerator(hashFile);
	}

	public static void jobGenerator(File file){
		try{

			Random rand = new Random();	
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			int randomHash;
			int randomPort;
			for (int i = 0; i < 200; i++){
				randomHash = rand.nextInt(2234) + 3214;
				randomPort = rand.nextInt(65535);

				if (i < 199)
					output.write(i + 1 + " " + randomPort + " " + randomHash + "\r\n");
				else
					output.write(i + 1 + " " + randomPort + " " + randomHash);	
				//output.newLine();	
			}
			output.close();
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}

		public static void hashGenerator(File file){
		try{

			Random rand = new Random();	
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			int randomHash;
			for (int i = 0; i < 100; i++){
				randomHash = rand.nextInt(2234) + 3214;

				output.write(randomHash + "\r\n");
			}
			output.close();
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}
}