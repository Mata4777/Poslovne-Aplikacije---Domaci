package rs.ac.fink.racunarska_oprema.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.data.Login;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;
import rs.ac.fink.racunarska_oprema.service.KorisnikService;

@Path("korisnik")
public class KorisnikRest {
    
    private final KorisnikService korisnikService = KorisnikService.getInstance();
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik getKorisnikById(@PathParam("username") String username) throws OpremaException {
        return korisnikService.findKorisnik(username);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addKorisnik(Korisnik korisnik) throws OpremaException{
            korisnikService.addNewKorisnik(korisnik);
            return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKorisnikStanje(Korisnik korisnik) throws OpremaException{
            korisnikService.updateStanje(korisnik);
            return Response.ok().build();
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response KorisnikLogin(Login login) throws OpremaException {
    boolean isAuthenticated = korisnikService.login(login.getUsername(), login.getPassword());
    if (isAuthenticated) {
        return Response.ok("Login successfull").build();
    } else {
        return Response.status(Response.Status.UNAUTHORIZED).entity("Incorrect login username or password.").build();
    }
    }
}
