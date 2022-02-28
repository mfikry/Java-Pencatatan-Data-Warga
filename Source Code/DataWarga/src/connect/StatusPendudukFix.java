/*
 * To change this license header, choose License Headesp in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.util.List;
import interfaces.StatusInterface;
import models.StatusPenduduk;
import models.Penduduk;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fikry
 */
public class StatusPendudukFix implements StatusInterface {
    
    @Override
    public boolean insert(StatusPenduduk sp){
        String sql = "INSERT INTO tStatus values (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, sp.getPenduduk().getnik());
            statement.setString(3, sp.getstatus_perkawinan());
            statement.setString(4, sp.gethubungan_keluarga());
            statement.setString(5, sp.getkewarganegaraan());
            statement.setString(6, sp.getdokumen_imigrasi());
            statement.setString(7, sp.getnama_ayah());
            statement.setString(8, sp.getnama_ibu());
            
            int row = statement.executeUpdate();
            if(row > 0){
                return true;
            }
            statement.close();
        }catch(Exception e){
            Logger.getLogger(StatusPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    @Override
    public boolean update(StatusPenduduk sp){
        String sql = "UPDATE tStatus SET nik =?,status_perkawinan =?,hubungan_keluarga =?,kewarganegaraan =?,dokumen_imigrasi =?,nama_ayah =?,nama_ibu =? WHERE kodestat=?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setString(1, sp.getPenduduk().getnik());
            statement.setString(2, sp.getstatus_perkawinan());
            statement.setString(3, sp.gethubungan_keluarga());
            statement.setString(4, sp.getkewarganegaraan());
            statement.setString(5, sp.getdokumen_imigrasi());
            statement.setString(6, sp.getnama_ayah());
            statement.setString(7, sp.getnama_ibu());
            statement.setInt(8, sp.getkodestat());
            
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(StatusPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    
   @Override
    public boolean delete(StatusPenduduk sp) {
    String sql = "DELETE FROM tStatus WHERE kodestat =?";
        try{
            PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement(sql);
            statement.setInt(1, sp.getkodestat());
            int row = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            Logger.getLogger(StatusPenduduk.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    public List<StatusPenduduk> getAllStatus(){
        List<StatusPenduduk> sps = new ArrayList<StatusPenduduk>();
        String sql = "SELECT * FROM tstatus inner join tpenduduk on tpenduduk.nik = tstatus.nik";
        try{
            if(Koneksi.bukaKoneksi() == null){
                return null;
            }else{
                PreparedStatement statement = Koneksi.bukaKoneksi().prepareStatement (sql);
                ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    StatusPenduduk sp = new StatusPenduduk(
                                            rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7),
                                            new Penduduk (rs.getString(8))
                    );
                    sps.add(sp);
                }
                statement.close();
                }
            }catch(Exception e){
                    Logger.getLogger(StatusPenduduk.class.getName()).log(Level.SEVERE,null,e);
                    }
            return sps;       
    }
    public StatusPenduduk getByID(String nik){
        return null;
    }
    public List<StatusPenduduk> getBySk(String status_perkawinan){
        return null;
    }
    public List<StatusPenduduk> getByHK(String hubungan_keluarga){
        return null;
    }
    public List<StatusPenduduk> getByKW(String kewarganegaraan){
        return null;
    }
    public List<StatusPenduduk> getByDI(String dokumen_imigrasi){
        return null;
    }
    public List<StatusPenduduk> getByNA(String nama_ayah){
        return null;
    }
    public List<StatusPenduduk> getByNI(String nama_ibu){
        return null;
    }
   
}
