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
public class Status {
    private int kodestat;
    private String status_perkawinan;
    private String hubungan_keluarga;
    private String kewarganegaraan;
    private String dokumen_imigrasi;
    private String nama_ayah;
    private String nama_ibu;
    private String namapen;
    
    public Status(int kodestat, String status_perkawinan, String hubungan_keluarga,String kewarganegaraan, String dokumen_imigrasi,String nama_ayah, String nama_ibu){
        this.kodestat = kodestat;
        this.status_perkawinan = status_perkawinan;
        this.hubungan_keluarga = hubungan_keluarga;
        this.kewarganegaraan = kewarganegaraan;
        this.dokumen_imigrasi = dokumen_imigrasi;
        this.nama_ayah = nama_ayah;
        this.nama_ibu = nama_ibu;
    }
    public Status(String status_perkawinan, String hubungan_keluarga,String kewarganegaraan, String dokumen_imigrasi,String nama_ayah, String nama_ibu){
        this.status_perkawinan = status_perkawinan;
        this.hubungan_keluarga = hubungan_keluarga;
        this.kewarganegaraan = kewarganegaraan;
        this.dokumen_imigrasi = dokumen_imigrasi;
        this.nama_ayah = nama_ayah;
        this.nama_ibu = nama_ibu;
    }
    public Status(int kodestat){
        this.kodestat = kodestat;
    }
    public int getkodestat(){
        return kodestat;
    }
    public void setkodestat(int kodestat){
        this.kodestat = kodestat;
    }
    public String getstatus_perkawinan(){
        return status_perkawinan;
    }
    public void setstatus_perkawinan(String status_perkawinan){
        this.status_perkawinan = status_perkawinan;
    }
    public String gethubungan_keluarga(){
        return hubungan_keluarga;
    }
    public void sethubungan_keluarga(String hubungan_keluarga){
        this.hubungan_keluarga = hubungan_keluarga;
    }
    public String getkewarganegaraan(){
        return kewarganegaraan;
    }
    public void setkewarganegaraan(String kewarganegaraan){
        this.kewarganegaraan = kewarganegaraan;
    }
    public String getdokumen_imigrasi(){
        return dokumen_imigrasi;
    }
    public void setdokumen_imigrasi(String dokumen_imigrasi){
        this.dokumen_imigrasi = dokumen_imigrasi;
    }
    public String getnama_ayah(){
        return nama_ayah;
    }
    public void setnama_ayah(String nama_ayah){
        this.nama_ayah = nama_ayah;
    }
    public String getnama_ibu(){
        return 	nama_ibu;
    }
    public void setnama_ibu(String nama_ibu){
        this.nama_ibu = nama_ibu;
    }
    public String getnamapen(){
        return 	namapen;
    }
    public void setnamapen(String namapen){
        this.namapen = namapen;
    }

}
