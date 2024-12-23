/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.data;


public class Pretraga {
    private int pretraga_id=-1;
    private Korisnik korisnik;
    private Podesavanje_pretrage podesavanje_pretrage;

    public Pretraga() {
    }
    
    public Pretraga(int pretraga_id, Korisnik korisnik, Podesavanje_pretrage podesavanje_pretrage) {
        this.pretraga_id = pretraga_id;
        this.korisnik = korisnik;
        this.podesavanje_pretrage = podesavanje_pretrage;
    }
    
    public Pretraga(Korisnik korisnik, Podesavanje_pretrage podesavanje_pretrage) {
        this.korisnik = korisnik;
        this.podesavanje_pretrage = podesavanje_pretrage;
    }

    public int getPretraga_id() {
        return pretraga_id;
    }

    public void setPretraga_id(int pretraga_id) {
        this.pretraga_id = pretraga_id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Podesavanje_pretrage getPodesavanje_pretrage() {
        return podesavanje_pretrage;
    }

    public void setPodesavanje_pretrage(Podesavanje_pretrage podesavanje_pretrage) {
        this.podesavanje_pretrage = podesavanje_pretrage;
    }

    @Override
    public String toString() {
        return "Pretraga{" + "pretraga_id=" + pretraga_id + ", korisnik=" + korisnik + ", podesavanje_pretrage=" + podesavanje_pretrage + '}';
    }
    
    
    
    
}
