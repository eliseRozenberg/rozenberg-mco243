package rozenberg.processor;

public class Processor {
	private Memory memory;
	private char accumA, accumB, code;
	private int index;

	public Processor() {
		memory = new Memory();
	}

	// return true if no lines left to execute
	public boolean executeLine(String line) throws InvalidInstructionException {
		memory.setMemory(line);
		if (memory.getContent(0) == '8') {
			return true;
		}
		accumA = '0';
		accumB = '0';
		for (index = 0; index < 256; index++) {
			code = memory.getContent(index);
			processCode();
			if (code == '8') {// so code will continue reading
				return false;
			}
		}
		throw new InvalidInstructionException();
		// if reaches the end of the file and not told to stop (8)
	}

	public void processCode() {
		switch (code) {
		case '0':// LD
			accumA = memory.getContent(memory.getLocation(index));
			index += 2;// increment to skip location
			break;
		case '1':// ST
			memory.setContent(memory.getLocation(index), accumA);
			index += 2;// increment to skip location
			break;
		case '2':// SWP
			char temp = accumA;
			accumA = accumB;
			accumB = temp;
			break;
		case '3':// ADD
			int valueA = Integer.parseInt(accumA + "", 16);
			int valueB = Integer.parseInt(accumB + "", 16);
			String valueStr = Integer.toString((valueA + valueB), 16).toUpperCase();
			if (valueStr.length() == 2) {
				accumA = valueStr.charAt(1);
				accumB = valueStr.charAt(0);
			} else {
				accumA = valueStr.charAt(0);
				accumB = '0';
			}
			break;
		case '4':// INC
			if (accumA == 'F') {
				accumA = '0';
			} else {
				int value = Integer.parseInt(String.valueOf(accumA), 16) + 1;
				accumA = Integer.toString(value, 16).toUpperCase().charAt(0);
			}
			break;
		case '5':// DEC
			if (accumA == '0') {
				accumA = 'F';
			} else {
				int value = Integer.parseInt(String.valueOf(accumA), 16) - 1;
				accumA = Integer.toString(value, 16).toUpperCase().charAt(0);
			}
			break;
		case '6':// BZ
			if (accumA == '0') {
				index = memory.getLocation(index);
				index--;
			} else {
				index += 2; // increment to skip location
			}
			break;
		case '7':// BR
			index = memory.getLocation(index);
			index--;
			break;
		case '8':
			System.out.println(memory.toString());
			break;
		}
		return;
	}
}
