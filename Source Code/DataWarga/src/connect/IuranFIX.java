/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.util.List;
import interfaces.IuranInterface;
import models.IuranPenduduk;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Penduduk;

/**
 *
 * @author Daffa
 */
public class IuranFIX implements IuranInterface{

    @Override
    public boolean insert(IuranPenduduk i){
        String sql = "INSERT INTO tIuran values (?, ?, ?)";
        try {
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, i.getkode_t());
            statement.setInt(2, i.gettagihan());
            statement.setString(3, i.getPenduduk().getnik());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch(Exception e) {
            Logger.getLogger(IuranPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    
    @Override
    public boolean delete(IuranPenduduk i) {
    String sql = "DELETE FROM tiuran WHERE kode_t =?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, i.getkode_t());
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(IuranPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    @Override
    public boolean update(IuranPenduduk i) {
        String sql = "UPDATE tIuran SET tagihan =? WHERE kode_t=?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, i.gettagihan());
            statement.setInt(2, i.getkode_t());
            
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(IuranPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }

    @Override
    public List<IuranPenduduk> getAllIuran() {
        List<IuranPenduduk> iurans = new ArrayList<IuranPenduduk>();
        String sql = "SELECT * FROM tiuran";
        try{
            if(Koneksi.bukaKoneksi() == null){
                return null;
            }else{
                PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement (sql);
                ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    IuranPenduduk i = new IuranPenduduk(rs.getInt(1),
                                            rs.getInt(2),
                            new Penduduk(rs.getString(3)));
                    iurans.add(i);
                }
                statement.close();
                }
            }catch(Exception e){
                    Logger.getLogger(IuranPenduduk.class.getName()).log(Level.SEVERE,null,e);
                    }
            return iurans;
        
    }

    @Override
    public IuranPenduduk getByID(int kode_t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IuranPenduduk> getByTG(int tagihan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IuranPenduduk> getByNIK(String nik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
