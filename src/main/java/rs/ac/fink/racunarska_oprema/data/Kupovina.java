/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.data;

public class Kupovina {
    private int kupovina_id=-1;
    private Korisnik korisnik;
    private Proizvod proizvod;

    public Kupovina() {
    }
    
    public Kupovina(int kupovina_id, Korisnik korisnik, Proizvod proizvod) {
        this.kupovina_id = kupovina_id;
        this.korisnik = korisnik;
        this.proizvod = proizvod;
    }
    
    public Kupovina(Korisnik korisnik, Proizvod proizvod) {
        this.korisnik = korisnik;
        this.proizvod = proizvod;
    }

    public int getKupovina_id() {
        return kupovina_id;
    }

    public void setKupovina_id(int kupovina_id) {
        this.kupovina_id = kupovina_id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return "Kupovina{" + "kupovina_id=" + kupovina_id + ", korisnik=" + korisnik + ", proizvod=" + proizvod + '}';
    }
    
    
}
