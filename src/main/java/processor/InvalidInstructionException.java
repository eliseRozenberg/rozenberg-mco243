package processor;

public class InvalidInstructionException extends Exception {
	public InvalidInstructionException() {
		super("Instruction must end with 8");
	}

}
