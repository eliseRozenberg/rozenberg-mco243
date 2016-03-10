package rozenberg.compiler;

import java.io.BufferedReader;
import java.io.IOException;

public class Compiler {

	private BufferedReader reader;
	private StringBuilder builder;

	public Compiler(BufferedReader reader) {
		this.reader = reader;
		this.builder = new StringBuilder();

	}

	public String run() throws IOException {

		String line;
		while ((line = reader.readLine()) != null) {
			String[] instr = new String[2];
			instr = line.split(" ");
			switch (instr[0]) {
			case "LD":
				builder.append("0");
				convertToHex(instr[1]);
				break;
			case "ST":
				builder.append("1");
				convertToHex(instr[1]);
				break;
			case "SWP":
				builder.append("2");
				break;
			case "ADD":
				builder.append("3");
				break;
			case "INC":
				builder.append("4");
				break;
			case "DEC":
				builder.append("5");
				break;
			case "BZ":
				builder.append("6");
				convertToHex(instr[1]);
				break;
			case "BR":
				builder.append("7");
				convertToHex(instr[1]);
				break;
			case "STP":
				builder.append("8");
				break;
			case "DATA":
				builder.append(instr[1]);
				break;
			}
		}
		return builder.toString();
	}

	public void convertToHex(String line) {
		String hex = Integer.toString(Integer.parseInt(line), 16).toUpperCase();
		if (hex.length() == 1) {
			builder.append("0" + hex);
		} else {
			builder.append(hex);
		}
	}
}