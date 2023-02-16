package database;

import java.util.List;

import model.Resepti;

public interface ReseptiDao {
	
	public List<Resepti> findAll();
	public boolean addResepti(Resepti resepti);
	public boolean remove(int reseptiID);
	public Resepti findById(int reseptiID);
	public List<Resepti> reseptiSearch(String haettava, String hakusana);
	public boolean update(int id, String sarake, String syote);
	public boolean updateKuvausById(int reseptiId, String syote);
	public boolean updateResepti(Resepti resepti);
	//public List<Resepti> reseptiSearchNimella(String hakusana);
}
