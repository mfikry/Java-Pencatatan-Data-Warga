/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.List;
import java.util.Observable;
import connect.StatusPendudukFix;
import interfaces.StatusInterface;
import models.StatusPenduduk;
import models.OperasiCRUD;
/**
 *
 * @author fikry
 */
public class StatusPendudukController extends Observable{
    private StatusInterface fix = new StatusPendudukFix();
    private OperasiCRUD crud;
    public void setFix(StatusInterface sp){
        fix = sp;
    }
    public void setDml (StatusPenduduk sp, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = fix.insert(sp);
                break;
            case UPDATE: hasil = fix.update(sp);
                break;
            case DELETE: hasil = fix.delete(sp);
                break;
        }
        setChanged();
        if(hasil){
            notifyObservers(sp);
        }else{
            notifyObservers();
        }
    }
    public OperasiCRUD getCrudState(){
        return crud;
    }
    public List<StatusPenduduk>getAllStatus(){
        return fix.getAllStatus();
    }
}
