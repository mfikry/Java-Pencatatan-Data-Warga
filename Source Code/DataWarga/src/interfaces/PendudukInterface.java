/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Penduduk;
/**
 *
 * @author fikry
 */
public interface PendudukInterface {
    public boolean insert(Penduduk p);
    public boolean update(Penduduk p);
    public boolean delete(Penduduk p);
    
    public List<Penduduk> getAllPenduduk();
    public Penduduk getByID(String nik);
    public List<Penduduk> getByName(String namapen);
    public List<Penduduk> getByJK(String jenis_kelamin);
    public List<Penduduk> getByTML(String tempat_lahir);
    public List<Penduduk> getByTGL(String tanggal_lahir);
    public List<Penduduk> getByAG(String agama);
    public List<Penduduk> getByPEN(String pendidikan);
    public List<Penduduk> getByJenPk(String jenis_pekerjaan);
    public List<Penduduk> getByAL(String alamat);
    public List<Penduduk> getByJenPn(String jenis_penduduk);
}
