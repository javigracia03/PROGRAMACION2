/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.servidor;

import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class GestorParticipantes {

    private ArrayList<ParticipanteProxy> losParticipantes;


    public GestorParticipantes() {
        this.losParticipantes = new ArrayList<ParticipanteProxy>();

    }//()
    
    private synchronized ParticipanteProxy buscaParticipante(String nick){
        for (int i=0; i<= losParticipantes.size()-1;i++){
            if(losParticipantes.get(i).getNick().equals(nick)){
                return losParticipantes.get(i);
            }//if
        }//for
            
        return null;

    }//()

    public synchronized boolean estaConectado(String nick){
        
        if (this.buscaParticipante(nick)!=null){
            return true;
        }//if
        return false;
    }//()

    public synchronized void anyadeParticipante(ParticipanteProxy p) throws NickEnUsoException{
        if(estaConectado(p.getNick())){
            throw new NickEnUsoException("El nick seleccionado ya esta en uso");
        } else{

            losParticipantes.add(p);
        }

    }//()

    public synchronized void eliminaParticipante(ParticipanteProxy p){
        for (int i=0; i<= this.losParticipantes.size()-1; i++){
            if(this.losParticipantes.get(i).getNick().equals(p.getNick())==true){
                this.losParticipantes.remove(i);
            }//if
        }//for    

    }//()

    public synchronized void difundeMensaje(String s){
        
        for (ParticipanteProxy p : losParticipantes){
            p.entregaMensaje(s);

        }//

    }//()

    public synchronized String listaParticipantes(){

        StringBuilder sb = new StringBuilder();
        
        for (ParticipanteProxy p : losParticipantes){
            sb.append(p.getNick()).append(" ");

        }//
        return sb.toString();
    }//()
}
