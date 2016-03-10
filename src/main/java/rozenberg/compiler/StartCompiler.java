package rozenberg.compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartCompiler {
	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("assemblyLanguage.txt"));
			// reader = new BufferedReader(new InputStreamReader(System.in));
			Compiler compiler = new Compiler(reader);
			System.out.println(compiler.run().toString());
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
