/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.util.List;
import interfaces.PendudukInterface;
import models.Penduduk;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fikry
 */
public class PendudukFIX implements PendudukInterface{

    @Override
    public boolean insert(Penduduk p){
        String sql = "INSERT INTO tPenduduk values(?, ?, ?, ?,?, ?, ?,?, ?, ?, ?)";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, p.getnik());
            statement.setString(3, p.getnamapen());
            statement.setString(4, p.getjenis_kelamin());
            statement.setString(5, p.gettempat_lahir());
            statement.setString(6, p.gettanggal_lahir());
            statement.setString(7, p.getagama());
            statement.setString(8, p.getpendidikan());
            statement.setString(9, p.getjenis_pekerjaan());
            statement.setString(10, p.getalamat());
            statement.setString(11, p.getjenis_penduduk());
            
            int row = statement.executeUpdate();
            if(row > 0){
                return true;
            }
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Penduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }

    @Override
    public boolean update(Penduduk p) {
        String sql = "UPDATE tPenduduk SET namapen =?,jenis_kelamin =?,tempat_lahir=?,tanggal_lahir=?,agama=?,pendidikan=?,jenis_pekerjaan=?,alamat=?,jenis_penduduk=? WHERE nik=?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setString(1, p.getnamapen());
            statement.setString(2, p.getjenis_kelamin());
            statement.setString(3, p.gettempat_lahir());
            statement.setString(4, p.gettanggal_lahir());
            statement.setString(5, p.getagama());
            statement.setString(6, p.getpendidikan());
            statement.setString(7, p.getjenis_pekerjaan());
            statement.setString(8, p.getalamat());
            statement.setString(9, p.getjenis_penduduk());
            statement.setString(10, p.getnik());
            
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Penduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }

    @Override
    public boolean delete(Penduduk p) {
    String sql = "DELETE FROM tPenduduk WHERE nik =?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setString(1, p.getnik());
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(Penduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;    }

    @Override
    public List<Penduduk> getAllPenduduk() {
        List<Penduduk> penduduks = new ArrayList<Penduduk>();
        String sql = "SELECT * FROM tpenduduk";
        try{
            if(Koneksi.bukaKoneksi() == null){
                return null;
            }else{
                PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement (sql);
                ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    Penduduk p = new Penduduk(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7),
                                            rs.getString(8),
                                            rs.getString(9),
                                            rs.getString(10),
                                            rs.getString(11));
                    penduduks.add(p);
                }
                statement.close();
                }
            }catch(Exception e){
                    Logger.getLogger(Penduduk.class.getName()).log(Level.SEVERE,null,e);
                    }
            return penduduks;
        
    }

    @Override
    public Penduduk getByID(String nik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByName(String namapen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByJK(String jenis_kelamin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByTML(String tempat_lahir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByTGL(String tanggal_lahir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByAG(String agama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByPEN(String pendidikan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByJenPk(String jenis_pekerjaan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByAL(String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penduduk> getByJenPn(String jenis_penduduk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
