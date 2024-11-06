package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig = 0;

	public Blogg() {

		innleggtabell = new Innlegg[20]; 
	}

	public Blogg(int lengde) {

		innleggtabell = new Innlegg[lengde]; 
	}

	public int getAntall() {

		return nesteledig;
	}
	
	public Innlegg[] getSamling() {

		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for(int i = 0; i < nesteledig; i++)
		{
			if(innleggtabell[i].erLik(innlegg))
			{
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		for(Innlegg localInnlegg : innleggtabell)
		{
			if(localInnlegg != null)
				if(localInnlegg.erLik(innlegg))
					return true;
		}
		return false;
	}

	public boolean ledigPlass() {
		
		return nesteledig < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if(nesteledig != 0)
			if(!ledigPlass() || finnes(innlegg))
				return false;
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}
	
	public String toString() {

		String toString = nesteledig + "\n";
		for(int i = 0; i < nesteledig; i++)
			toString += innleggtabell[i].toString();
		return toString;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] temp = new Innlegg[innleggtabell.length * 2];
		for(int i = 0; i < nesteledig; i++)
			temp[i] = innleggtabell[i];
		innleggtabell = temp;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		if(nesteledig != 0)
		{
			if(finnes(innlegg))
				return false;
			
			if(!ledigPlass())
				utvid();
		}
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		if(nesteledig == 0)
			return false;
		
		int index = finnInnlegg(innlegg);
		
		if(index == -1)
			return false;
		
		nesteledig--;
		innleggtabell[index] = null;
		for(int i = index; i < nesteledig; i++)
			innleggtabell[i] = innleggtabell[i+1];
		return true;
	}
	
	public int[] search(String keyword) {
		
		int[] ids = new int[nesteledig];
		int index = 0;
		for(Innlegg innlegg : innleggtabell)
		{
			if(innlegg.getTekst().contains(keyword))
			{
				ids[index] = innlegg.getId();
				index++;
			}
		}
		return ids;

	}
}