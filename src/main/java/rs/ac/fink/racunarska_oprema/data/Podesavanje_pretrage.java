/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.data;


public class Podesavanje_pretrage {
    private int podesavanje_pretrage_id=-1;
    private int donja_granica_obima_cene;
    private int gornja_granica_obima_cene;
    private String vrsta_opreme;
    private String kljucna_rec;

    public Podesavanje_pretrage() {
    }

    public Podesavanje_pretrage(int donja_granica_obima_cene, int gornja_granica_obima_cene, String vrsta_opreme, String kljucna_rec) {
        this.donja_granica_obima_cene = donja_granica_obima_cene;
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
        this.vrsta_opreme = vrsta_opreme;
        this.kljucna_rec = kljucna_rec;
    }
    
    public Podesavanje_pretrage(int podesavanje_pretrage_id, int donja_granica_obima_cene, int gornja_granica_obima_cene, String vrsta_opreme, String kljucna_rec) {
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
        this.donja_granica_obima_cene = donja_granica_obima_cene;
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
        this.vrsta_opreme = vrsta_opreme;
        this.kljucna_rec = kljucna_rec;
    }

    public int getPodesavanje_pretrage_id() {
        return podesavanje_pretrage_id;
    }

    public void setPodesavanje_pretrage_id(int podesavanje_pretrage_id) {
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
    }

    public int getDonja_granica_obima_cene() {
        return donja_granica_obima_cene;
    }

    public void setDonja_granica_obima_cene(int donja_granica_obima_cene) {
        this.donja_granica_obima_cene = donja_granica_obima_cene;
    }

    public int getGornja_granica_obima_cene() {
        return gornja_granica_obima_cene;
    }

    public void setGornja_granica_obima_cene(int gornja_granica_obima_cene) {
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
    }

    public String getVrsta_opreme() {
        return vrsta_opreme;
    }

    public void setVrsta_opreme(String vrsta_opreme) {
        this.vrsta_opreme = vrsta_opreme;
    }

    public String getKljucna_rec() {
        return kljucna_rec;
    }

    public void setKljucna_rec(String kljucna_rec) {
        this.kljucna_rec = kljucna_rec;
    }

    @Override
    public String toString() {
        return "Podesavanje_pretrage{" + "podesavanje_pretrage_id=" + podesavanje_pretrage_id + ", donja_granica_obima_cene=" + donja_granica_obima_cene + ", gornja_granica_obima_cene=" + gornja_granica_obima_cene + ", vrsta_opreme=" + vrsta_opreme + ", kljucna_rec=" + kljucna_rec + '}';
    }
    
    
}
