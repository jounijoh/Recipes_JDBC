package program;

import java.util.List;
import java.util.Scanner;

import database.ReseptiDao;
import database.ReseptiJdbcDao;
import model.Resepti;

public class FindByIdOhjelma {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
	
		
		System.out.println("Reseptit: ");
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		//luodaan lista resepteistä, joka tulostetaan
		
		List<Resepti> reseptit = reseptidao.findAll();
		
		for (Resepti resepti : reseptit) {
			System.out.print("Id: " + resepti.getId());
			System.out.print(", Nimi: " + resepti.getNimi());
			System.out.print(", Kuvaus: " + resepti.getKuvaus());
			System.out.print(", Ainekset " + resepti.getAinekset());
			System.out.print(", Valmistusaika: " + resepti.getValmistusaika());
			System.out.println(", Ohjeet: " + resepti.getOhjeet());
		}
		
		
		System.out.println("Millä id:llä haetaan?");
		
		
		int haettavaId = input.nextInt();
		input.nextLine();
		
		Resepti haetturesepti = reseptidao.findById(haettavaId);
		
		System.out.println(haetturesepti);
		
	
		//KOKEILLAAN RESEPTIHAKUA ERI HAKUSANOILLA
		System.out.println("Millä haetaan reseptiä: Nimi, Ainekset, Valmistusaika?");
		String haettava = input.nextLine();
	
		
		System.out.println("Hakusana: ");
		String hakusana = input.nextLine();
		
		List<Resepti> loydetytreseptit = reseptidao.reseptiSearch(haettava, hakusana);
		for (Resepti resepti : loydetytreseptit) {
			System.out.println(resepti);
		}
		
	
		
		
		
		/*
		 * 
		System.out.println("Muutetaan dadareseptin kuvausta: ");
		String uusiNimi ="nimdadai";
		String uusiKuvaus = "kuvadadus";
		String uusiAinekset = "ainedadadkset";
		String uusiValmistusaika = "valmistdadaadausaika";
		String uusiOhjeet = "wakwak";
		
		
		
		Resepti resepti = new Resepti(haettavaId, uusiNimi, uusiKuvaus, uusiAinekset, uusiValmistusaika, uusiOhjeet);
	
		System.out.println(resepti);
		
		//päivitetään
		boolean updateOk = false;
		updateOk = reseptidao.updateResepti(resepti);
		System.out.println(updateOk);
		if (updateOk) {
			System.out.println("update ok");
			
		}else {
			String virheviesti = "Reseptin lisääminen tietokantaan ei onnistunut.";
			System.out.println(virheviesti);
			}*/
	}
	
}
