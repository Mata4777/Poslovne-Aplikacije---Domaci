/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.data.Kupovina;
import rs.ac.fink.racunarska_oprema.data.Proizvod;
import rs.ac.fink.racunarska_oprema.service.KupovinaService;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;

@Path("kupovina")
public class KupovinaRest {
    
    private final KupovinaService kupovinaService = KupovinaService.getInstance();
        
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kupovina getKupovinaById(@PathParam("id") int id) throws OpremaException {
        return kupovinaService.findKupovina(id);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeKupovina(Kupovina kupovina) throws OpremaException{
            kupovinaService.addKupovina(kupovina.getKorisnik(), kupovina.getProizvod());
            return Response.ok().build();
    }
    
    

}
