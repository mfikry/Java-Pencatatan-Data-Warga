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
public class StatusPenduduk extends Status {
    Penduduk penduduk;
    
    public StatusPenduduk (int kodestat, String status_perkawinan, String hubungan_keluarga,String kewarganegaraan, String dokumen_imigrasi,String nama_ayah, String nama_ibu, Penduduk penduduk){
        super(kodestat, status_perkawinan,hubungan_keluarga,kewarganegaraan,dokumen_imigrasi,nama_ayah,nama_ibu);
        this.penduduk = penduduk;
    }
    public StatusPenduduk (String status_perkawinan, String hubungan_keluarga,String kewarganegaraan, String dokumen_imigrasi,String nama_ayah, String nama_ibu, Penduduk penduduk){
        super(status_perkawinan,hubungan_keluarga,kewarganegaraan,dokumen_imigrasi,nama_ayah,nama_ibu);
        this.penduduk = penduduk;
    }
    public StatusPenduduk(Penduduk penduduk, int kodestat){
        super(kodestat);
        this.penduduk = penduduk;    
    }
    public Penduduk getPenduduk(){
        return penduduk;
    }
    public void setPenduduk(Penduduk penduduk){
        this.penduduk = penduduk;
    }
}
