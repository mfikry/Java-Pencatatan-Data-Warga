/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.IuranPenduduk;

/**
 *
 * @author Daffa
 */
public interface IuranInterface {
    public boolean insert(IuranPenduduk i);
    public boolean delete(IuranPenduduk i);
    public boolean update(IuranPenduduk i);
    
    public List<IuranPenduduk> getAllIuran();
    public IuranPenduduk getByID(int kode_t);
    public List<IuranPenduduk> getByTG(int tagihan);
    public List<IuranPenduduk> getByNIK(String nik);
}
