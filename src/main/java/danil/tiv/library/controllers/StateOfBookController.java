package danil.tiv.library.controllers;

import java.util.List;

import com.google.inject.Inject;

import danil.tiv.library.servicies.StateOfBookService;
import danil.tiv.library.store.entities.StateOfBooksEntity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/states")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StateOfBookController {

    private final StateOfBookService stateOfBookService;

    @Inject
    public StateOfBookController(StateOfBookService stateOfBookService) {
        this.stateOfBookService = stateOfBookService;
    }

    @GET
    public List<StateOfBooksEntity> getAllStates() {
        return stateOfBookService.findAllStateOfBook();
    }

    @GET
    @Path("/{id}")
    public Response getStateById(@PathParam("id") int id) {
    	StateOfBooksEntity state = stateOfBookService.getStateOfBookById(id);
        if (state != null) {
            return Response.ok(state).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addState(StateOfBooksEntity stateofbook) {
        stateOfBookService.addStateOfBook(stateofbook);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateState(@PathParam("id") int id, StateOfBooksEntity stateofbook) {
    	stateofbook.setStateOfBooksId(id);
        stateOfBookService.updateStateOfBook(stateofbook);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteState(@PathParam("id") int id) {
        stateOfBookService.deleteStateOfBookById(id);
        return Response.noContent().build();
    }
}
