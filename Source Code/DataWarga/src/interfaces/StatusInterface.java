/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.StatusPenduduk;

/**
 *
 * @author fikry
 */
public interface StatusInterface {
    public boolean insert(StatusPenduduk sp);
    public boolean update(StatusPenduduk sp);
    public boolean delete(StatusPenduduk sp);
    
    public List<StatusPenduduk> getAllStatus();
    public StatusPenduduk getByID(String nik);
    public List<StatusPenduduk> getBySk(String status_perkawinan);
    public List<StatusPenduduk> getByHK(String hubungan_keluarga);
    public List<StatusPenduduk> getByKW(String kewarganegaraan);
    public List<StatusPenduduk> getByDI(String dokumen_imigrasi);
    public List<StatusPenduduk> getByNA(String nama_ayah);
    public List<StatusPenduduk> getByNI(String nama_ibu);
}
