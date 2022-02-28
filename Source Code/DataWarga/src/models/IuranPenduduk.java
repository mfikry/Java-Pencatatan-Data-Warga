/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Daffa
 */
public class IuranPenduduk extends Iuran {
    Penduduk penduduk;
    
    public IuranPenduduk(int kode_t, int tagihan, Penduduk penduduk){
        super(kode_t, tagihan);
        this.penduduk = penduduk;
    }
    public IuranPenduduk(int kode_t){
        super(kode_t);
    }
    
    public Penduduk getPenduduk(){
        return penduduk;
    }
    
    public void setPenduduk(Penduduk penduduk){
        this.penduduk = penduduk;
    }
}
