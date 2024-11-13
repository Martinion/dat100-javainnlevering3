package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		PrintWriter writer;
		
		try {
			// File file = new File(mappe + filnavn);
			writer = new PrintWriter(mappe + filnavn);
			writer.write(samling.toString());
			writer.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	}
}
