package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Klausurvorbereitung {

	public static void writeNames(String filename, ArrayList<String> al) {

		try {
			File f = new File(filename);
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			StringBuilder sb = new StringBuilder();
			String s = null;
			for (String name : al) {
				if (name.length() > 5) {
					sb.append(name);
				}
			}
			s = sb.toString();
			bw.write(s);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void writeNames2(String filename, ArrayList<String> al, Predicate<String> tester) {

		try {
			File f = new File(filename);
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			StringBuilder sb = new StringBuilder();
			String s = null;
//			for (String name : al) {
//				if (tester) {
//					sb.append(name);
//				}
//			}
			s = sb.toString();
			bw.write(s);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {

		String filename = "names.txt";
		ArrayList<String> al = new ArrayList<>();
		al.add("brecht");
		al.add("bardot");

		writeNames(filename, al);
		
		//ungeprueft
		Klausurvorbereitung.writeNames2("names.txt", al, s -> s.length() > 6);

	}
}
