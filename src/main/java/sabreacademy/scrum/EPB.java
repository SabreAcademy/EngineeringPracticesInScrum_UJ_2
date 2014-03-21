package sabreacademy.scrum;

import java.util.Scanner;


class Reader {
	static Scanner scan = null;

	Reader() {
		if (scan == null) {
			if( System.console() != null)
				scan = new Scanner(System.console().reader());
		}
	}

	public boolean hasNext() {
		return scan.hasNext();
	}

	public String next() {
		return scan.next();
	}

	public boolean isInitialized() {
		try {
			return scan != null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

class Writer {
	public void print(String s) {
		System.out.print(s);
	}
	
	public void println(String x) {
		System.out.println(x);
	}
}

public class EPB {

	public static void main(String[] args) {

		Writer writer = new Writer();

		try {
			writeMenu(writer);			
			showPrompt(writer);
			
			Reader reader = new Reader();
			checkReader(reader);
			while (reader.hasNext()) {
				String str = readImput(reader);
				performAction(writer, str);
			}
		} catch (Exception ex) {
			logException(ex);
		}
	}

	private static void checkReader(Reader reader) throws Exception {
		boolean isInitialized = !reader.isInitialized();
		if (isInitialized)
			throw new Exception("");
	}

	private static void logException(Exception ex) {
		ex.printStackTrace();
	}

	private static void performAction(Writer writer, String str) {
		writer.println(str);
	}

	private static String readImput(Reader reader) {
		return reader.next();
	}

	private static void showPrompt(Writer writer) {
		writer.print("ePB> ");
	}

	private static void writeMenu(Writer writer) {
		writer.println("Menu: ");
		writer.println("\teXit");
		writer.println("\tAdd item");
		writer.println("\tChange item");
		writer.println("\tRemove item");
		writer.println( "\tHelp item");
	}
}
