package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Resepti;

public class ReseptiJdbcDao implements ReseptiDao {
	//funktio kaikkien reseptien hakemiseen ja listaamiseen 
	public List<Resepti> findAll() {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		ResultSet rs = null;
		List<Resepti> reseptit = new ArrayList<Resepti>();
		Resepti resepti = null;

		try {
			dbyhteys = Database.getDBCconnection();
			sqllause = dbyhteys
					.prepareStatement("SELECT id, nimi, kuvaus, ainekset, valmistusaika, ohjeet FROM resepti;");
			rs = sqllause.executeQuery();

			while (rs.next()) {
				resepti = createReseptiObjectFromRow(rs);
				reseptit.add(resepti);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Database.closeDBConnection(rs, sqllause, dbyhteys);
		}
		return reseptit;
	}
	//apufunktio, joka luo Resepti-olion sqlitestää haetusta tulostaulusta
	private Resepti createReseptiObjectFromRow(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String nimi = rs.getString("nimi");
			String kuvaus = rs.getString("kuvaus");
			String ainekset = rs.getString("ainekset");
			String valmistusaika = rs.getString("valmistusaika");
			String ohjeet = rs.getString("ohjeet");

			return new Resepti(id, nimi, kuvaus, ainekset, valmistusaika, ohjeet);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Reseptin lisäys
	public boolean addResepti(Resepti resepti) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		boolean lisaysOk = false;

		try {
			dbyhteys = Database.getDBCconnection();
			String sqlInsert = "INSERT INTO resepti (nimi, kuvaus, ainekset, valmistusaika, ohjeet) VALUES (?, ?, ?, ?, ?)";

			sqllause = dbyhteys.prepareStatement(sqlInsert);
			sqllause.setString(1, resepti.getNimi());
			sqllause.setString(2, resepti.getKuvaus());
			sqllause.setString(3, resepti.getAinekset());
			sqllause.setString(4, resepti.getValmistusaika());
			sqllause.setString(5, resepti.getOhjeet());

			int rowAffected = sqllause.executeUpdate();
			if (rowAffected == 1)
				lisaysOk = true;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqllause, dbyhteys);
		}
		return lisaysOk;

	}
	//reseptin poisto
	public boolean remove(int reseptiID) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		boolean poistoOk = false;

		try {
			dbyhteys = Database.getDBCconnection();
			String sql = "DELETE FROM resepti WHERE id = ?";
			sqllause = dbyhteys.prepareStatement(sql);
			sqllause.setInt(1, reseptiID);
			int rowAffected = sqllause.executeUpdate();
			if (rowAffected == 1)
				poistoOk = true;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqllause, dbyhteys);
		}

		return poistoOk;
	}

	public Resepti findById(int reseptiID) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		ResultSet rs = null;
		Resepti resepti = null;

		try {
			dbyhteys = Database.getDBCconnection();
			String sql = "SELECT id, nimi, kuvaus, ainekset, valmistusaika, ohjeet FROM resepti WHERE id = ?";
			sqllause = dbyhteys.prepareStatement(sql);
			sqllause.setInt(1, reseptiID);

			rs = sqllause.executeQuery();

			resepti = createReseptiObjectFromRow(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Database.closeDBConnection(rs, sqllause, dbyhteys);
		}

		return resepti;

	}

	public boolean updateKuvausById(int reseptiId, String syote) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		boolean updateOk = false;

		try {
			dbyhteys = Database.getDBCconnection();
			String sql = "UPDATE resepti SET kuvaus = ? WHERE id = ?";
			sqllause = dbyhteys.prepareStatement(sql);

			sqllause.setString(1, syote);
			sqllause.setInt(2, reseptiId);

			int rowAffected = sqllause.executeUpdate();
			if (rowAffected == 1)
				updateOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return updateOk;
	}

	public boolean updateResepti(Resepti resepti) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		boolean updateOk = false;

		try {
			dbyhteys = Database.getDBCconnection();
			String sql = "UPDATE resepti SET nimi = ?, kuvaus = ?, ainekset = ?, valmistusaika = ?, ohjeet = ?"
					+ "WHERE id = ?";
			sqllause = dbyhteys.prepareStatement(sql);

			sqllause.setString(1, resepti.getNimi());
			sqllause.setString(2, resepti.getKuvaus());
			sqllause.setString(3, resepti.getAinekset());
			sqllause.setString(4, resepti.getValmistusaika());
			sqllause.setString(5, resepti.getOhjeet());
			sqllause.setInt(6, resepti.getId());

			int rowAffected = sqllause.executeUpdate();
			if (rowAffected == 1)
				updateOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqllause, dbyhteys);
		}

		return updateOk;
	}

	public boolean update(int reseptiId, String sarake, String syote) {
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		boolean updateOk = false;
		
		try {
			dbyhteys = Database.getDBCconnection();
			String sql = "UPDATE resepti SET ? = ? WHERE id = ?";
			sqllause = dbyhteys.prepareStatement(sql);
			
			
			sqllause.setString(1, syote);
			sqllause.setString(2, sarake);
			sqllause.setInt(3, reseptiId);
			
			int rowAffected = sqllause.executeUpdate();
			if (rowAffected == 1) updateOk = true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqllause, dbyhteys);
		}
		
		return updateOk;
	}

	/// Reseptin haku /toimii hyvin nimellä tai aineksilla 
	public List<Resepti> reseptiSearch(String haettava, String hakusana) {
		//luodaan muuttujat
		Connection dbyhteys = null;
		PreparedStatement sqllause = null;
		ResultSet rs = null;
		List<Resepti> reseptit = new ArrayList<Resepti>();
		Resepti resepti = null;
		String sql = "";
		try {
			//yhteys sqliteen
			dbyhteys = Database.getDBCconnection();
			
			
			//luodaan lause sqlkyselyä varten
		
			//merkkien takia hakusana täytyyy luoda tarkemmin 
			String sqlhakusana = "%"+hakusana+"%";
			sql = "SELECT id, nimi, kuvaus, ainekset, valmistusaika, ohjeet FROM resepti  WHERE "+haettava+" LIKE ?;";
			sqllause = dbyhteys.prepareStatement(sql);	
			sqllause.setString(1, sqlhakusana);
		
			
			rs = sqllause.executeQuery();
			
			
			//tehdäään löydetyistä reseptiistä resepti olio ja lisätään ne listaan joka palautetaan 
			while(rs.next()) {
				resepti = createReseptiObjectFromRow(rs);
				reseptit.add(resepti);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			Database.closeDBConnection(rs, sqllause, dbyhteys);
		}
		return reseptit;
	}
	

	
}


