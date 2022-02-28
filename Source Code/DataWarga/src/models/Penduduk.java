/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author fikry
 */
public class Penduduk {
    private int id;
    private String nik;
    private String namapen;
    private String jenis_kelamin;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String agama;
    private String pendidikan;
    private String jenis_pekerjaan;
    private String alamat;
    private String jenis_penduduk;
    
    public Penduduk(String nik, String namapen,String jenis_kelamin, String tempat_lahir,String tanggal_lahir, String agama,String pendidikan, String jenis_pekerjaan,String alamat, String jenis_penduduk){
        this.nik = nik;
        this.namapen = namapen;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.agama = agama;
        this.pendidikan = pendidikan;
        this.jenis_pekerjaan = jenis_pekerjaan;
        this.alamat = alamat;
        this.jenis_penduduk = jenis_penduduk;
    }
    public Penduduk(int id, String nik, String namapen,String jenis_kelamin, String tempat_lahir,String tanggal_lahir, String agama,String pendidikan, String jenis_pekerjaan,String alamat, String jenis_penduduk){
        this.id = id;
        this.nik = nik;
        this.namapen = namapen;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.agama = agama;
        this.pendidikan = pendidikan;
        this.jenis_pekerjaan = jenis_pekerjaan;
        this.alamat = alamat;
        this.jenis_penduduk = jenis_penduduk;
    }
    public Penduduk(String nik){
        this.nik = nik;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public String getnik(){
        return nik;
    }
    public void setnik(String nik){
        this.nik = nik;
    }
    public String getnamapen(){
        return namapen;
    }
    public void setnamapen(String namapen){
        this.namapen = namapen;
    }
    public String getjenis_kelamin(){
        return jenis_kelamin;
    }
    public void setjenis_kelamin(String jenis_kelamin){
        this.jenis_kelamin = jenis_kelamin;
    }
    public String gettempat_lahir(){
        return tempat_lahir;
    }
    public void settempat_lahir(String tempat_lahir){
        this.tempat_lahir = tempat_lahir;
    }
    public String gettanggal_lahir(){
        return tanggal_lahir;
    }
    public void settanggal_lahir(String tanggal_lahir){
        this.tanggal_lahir = tanggal_lahir;
    }
    public String getagama(){
        return agama;
    }
    public void setagama(String agama){
        this.agama = agama;
    }
     public String getpendidikan(){
        return pendidikan;
    }
    public void setpendidikan(String pendidikan){
        this.pendidikan = pendidikan;
    }
     public String getjenis_pekerjaan(){
        return jenis_pekerjaan;
    }
    public void setjenis_pekerjaan(String jenis_pekerjaan){
        this.jenis_pekerjaan = jenis_pekerjaan;
    }
     public String getalamat(){
        return alamat;
    }
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
     public String getjenis_penduduk(){
        return jenis_penduduk;
    }
    public void setjenis_penduduk(String jenis_penduduk){
        this.jenis_penduduk = jenis_penduduk;
    }
    @Override
    public String toString(){
        return this.nik;
//        return this.jenis_kelamin;
//        return this.tempat_lahir;
//        return this.tanggal_lahir;
//        return this.agama;
//        return this.pendidikan;
//        return this.jenis_pekerjaan;
//        return this.alamat;
//        return this.jenis_penduduk;
    }
    
}
