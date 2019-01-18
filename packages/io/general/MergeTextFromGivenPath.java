import java.io.*;

class DisplayTextFiles {
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("mergedText.txt");
		BufferedReader br; // Declaring a variable of BufferedReader data type so that it can be used inside loop to read every .txt files listed there.
		String path = "C:/users/arjun/Desktop"; // This is pre-specified path, you can change it.
		String line; // This will get the lines on text files.
		File[] filesFromPath = (new File(path)).listFiles();

		// This block will print all the .txt files in Desktop or any specified path. To specify a new path; edit the path above.
		for (File fileFromPath : filesFromPath) {
			if (fileFromPath.getName().endsWith(".txt")) { // First getName() will return the file name into string and endsWith() checks the file extension like REGEX.
				System.out.println(fileFromPath.getName()); // Prints all .txt files in Desktop.
			}
		}

		for(File fileFromPath:filesFromPath){
			if (fileFromPath.getName().endsWith(".txt")) { 
				pw.write("From "+fileFromPath.getName()+"\n"); // This will write the text
				br = new BufferedReader(new FileReader(fileFromPath));
				line = br.readLine(); // Reads a line from specified file and returns string.
				while(line != null){ // Loop executes until the line-read is not null.
					pw.write(line); // Writes each lines into the PrintWriter variable.
					br.readLine(); 
				}
				pw.write("\n");
			}
		}
		pw.flush();
		pw.close();
	}
}