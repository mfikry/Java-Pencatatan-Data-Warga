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
public class Iuran {
    private int kode_t;
    private int tagihan;
    
    public Iuran(int kode_t, int tagihan){
        this.kode_t = kode_t;
        this.tagihan = tagihan;
    }
    
    public Iuran(int kode_t){
        this.kode_t = kode_t;
    }
    
    public void setkode_t(int kode_t){
        this.kode_t = kode_t;
    }
    
    public int getkode_t(){
        return kode_t;
    }
    
    public void settagihan(int tagihan){
        this.tagihan = tagihan;
    }
    
    public int gettagihan(){
        return  tagihan;
    }
}
