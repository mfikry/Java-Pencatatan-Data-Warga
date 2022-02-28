/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.List;
import java.util.Observable;
import connect.PendudukFIX;
import interfaces.PendudukInterface;
import models.Penduduk;
import models.OperasiCRUD;
/**
 *
 * @author fikry
 */
public class PendudukController extends Observable{
    private PendudukInterface fix = new PendudukFIX();
    private OperasiCRUD crud;
    public void setFIX (PendudukInterface p){
        fix = p;
    }
    public void setDml (Penduduk p, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = fix.insert(p);
                break;
            case UPDATE: hasil = fix.update(p);
                break;
            case DELETE: hasil = fix.delete(p);
                break;
        }
        setChanged();
        if(hasil){
            notifyObservers(p);
        }else{
            notifyObservers();
        }
    }
    public OperasiCRUD getCrudState(){
        return crud;
    }
    public  List<Penduduk>getAllPenduduk(){
        return fix.getAllPenduduk();
    }
}
