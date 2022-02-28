/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.List;
import java.util.Observable;
import connect.IuranFIX;
import connect.PendudukFIX;
import interfaces.IuranInterface;
import interfaces.PendudukInterface;
import models.IuranPenduduk;
import models.OperasiCRUD;
import models.Penduduk;

/**
 *
 * @author Daffa
 */
public class IuranController extends Observable {
    private IuranInterface fix = new IuranFIX();
    private OperasiCRUD crud;
    public void setFIX (IuranInterface i){
        fix = i;
    }
    public void setDml (IuranPenduduk i, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = fix.insert(i);
                break;
            case UPDATE: hasil = fix.update(i);
                break;
            case DELETE: hasil = fix.delete(i);
                break;
        }
        setChanged();
        if(hasil){
            notifyObservers(i);
        }else{
            notifyObservers();
        }
    }
    public OperasiCRUD getCrudState(){
        return crud;
    }
    public  List<IuranPenduduk>getAllIuran(){
        return fix.getAllIuran();
    }
}
