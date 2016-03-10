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
			String hex;
			switch (instr[0]) {
			case "LD":
				builder.append("0");
				hex = (convertToHex(instr[1]));
				if (hex.length() == 1) {
					builder.append("0" + hex);
				} else {
					builder.append(hex);
				}
				break;
			case "ST":
				builder.append("1");
				hex = (convertToHex(instr[1]));
				if (hex.length() == 1) {
					builder.append("0" + hex);
				} else {
					builder.append(hex);
				}
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
				hex = (convertToHex(instr[1]));
				if (hex.length() == 1) {
					builder.append("0" + hex);
				} else {
					builder.append(hex);
				}
				break;
			case "BR":
				builder.append("7");
				hex = (convertToHex(instr[1]));
				if (hex.length() == 1) {
					builder.append("0" + hex);
				} else {
					builder.append(hex);
				}
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

	public String convertToHex(String line) {
		return Integer.toString(Integer.parseInt(line), 16).toUpperCase();
	}
}