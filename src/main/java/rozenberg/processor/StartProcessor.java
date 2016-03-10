package rozenberg.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartProcessor {
	public static void main(String[] args) {
		Processor processor = new Processor();
		try {
			// BufferedReader reader = new BufferedReader(new FileReader("mach.in"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					// true when 8 is first instruction of new line
					// finished executing program
					if (processor.executeLine(line)) {
						System.exit(0);
					}
				} catch (InvalidInstructionException e) {
					e.printStackTrace();
					// when line doesn't have a stopping point (8)- error in
					// file
				}
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
