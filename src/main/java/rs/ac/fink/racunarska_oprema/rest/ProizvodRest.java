/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rs.ac.fink.racunarska_oprema.data.Proizvod;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;
import rs.ac.fink.racunarska_oprema.service.ProizvodService;

@Path("proizvod")
public class ProizvodRest {
    
    private final ProizvodService proizvodService = ProizvodService.getInstance();
    
    @GET
    @Path("/naziv/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proizvod getProizvodByName(@PathParam("name") String name) throws OpremaException {
        return proizvodService.findProizvodByName(name);
    }
    
    @GET
    @Path("/vrsta/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proizvod getProizvodByVrsta(@PathParam("name") String name) throws OpremaException {
        return proizvodService.findProizvodByVrsta(name);
    }
}
