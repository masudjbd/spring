/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05_1;

import javax.persistence.Entity;

 
@Entity
public class CD extends Product{

    private String artist;
    public CD() {
    }

    public CD(String artist,String productname) {
        this.artist = artist;
        this.setName(productname);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
}
