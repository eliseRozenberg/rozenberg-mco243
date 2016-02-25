package processor;

public class Memory {

	private char[] memory;

	public Memory() {
	}

	public void setMemory(String memory) {
		this.memory = memory.toCharArray();
	}

	public void setContent(int index, char value) {
		memory[index] = value;
	}

	public char getContent(int index) {
		return memory[index];
	}

	public int getLocation(int index) {
		int location = Integer.parseInt(memory[index + 1] + "" + memory[index + 2], 16);
		return location;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			builder.append(memory[i]);
		}
		return builder.toString();
	}

}
