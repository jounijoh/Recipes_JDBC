package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import database.ReseptiDao;
import database.ReseptiJdbcDao;



class ReseptiTesti {

	@Test
	void testLisääJaHaeAinekset() {
		String ainekset = "Tomaattia, kurkku ja muuta";
		Resepti resepti = new Resepti();
		resepti.setAinekset(ainekset);
		String odotetutAinekset = "Tomaattia, kurkku ja muuta";
		String tapahtuneetAinekset = resepti.getAinekset();
		
		assertEquals(odotetutAinekset, tapahtuneetAinekset);
	}

	@Test
	void lisääJaHaeValmistusaikaReseptilleTest() {
		String valmistusaika = " 01 h 20 min";
		Resepti resepti = new Resepti(); 
		resepti.setValmistusaika(valmistusaika);
		String odotettuValmistusaika = "01h20min";
		String tapahtunutValmistusaika = resepti.getValmistusaika();
		System.out.println(tapahtunutValmistusaika);
		assertEquals(odotettuValmistusaika, tapahtunutValmistusaika);
	}
	
	
	@Test
	void lisaaReseptiTietokantaanHaeJaPoistaSeTest() {
		
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		Resepti resepti = new Resepti("testi", "testi", "testi", "testi", "testi");
		reseptidao.addResepti(resepti);
		
		//haetaan lisätty resepti
		List<Resepti> haetutReseptit = reseptidao.reseptiSearch("nimi", "test");
		Resepti odotettuResepti = resepti;
		Resepti haettuResepti = haetutReseptit.get(0);
		
		assertEquals(haettuResepti, odotettuResepti);
		int id =haettuResepti.getId();
		
		boolean poistoOk = reseptidao.remove(id);
		boolean haluttuTulos = true;
		
		assertEquals(poistoOk, haluttuTulos);
		
	}

	
	
	
	
}
