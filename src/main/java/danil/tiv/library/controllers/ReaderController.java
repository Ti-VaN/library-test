package danil.tiv.library.controllers;

import java.util.List;

import com.google.inject.Inject;

import danil.tiv.library.servicies.ReaderService;
import danil.tiv.library.store.entities.ReadersEntity;
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

@Path("/readers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReaderController {

    private final ReaderService readerService;

    @Inject
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GET
    public List<ReadersEntity> getAllReaders() {
        return readerService.findAllReaders();
    }

    @GET
    @Path("/{id}")
    public Response getReaderById(@PathParam("id") int id) {
    	ReadersEntity reader = readerService.getReaderById(id);
        if (reader != null) {
            return Response.ok(reader).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addReader(ReadersEntity reader) {
        readerService.addReader(reader);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateReader(@PathParam("id") int id, ReadersEntity reader) {
        reader.setReaderId(id); 
        readerService.updateReader(reader);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReader(@PathParam("id") int id) {
        readerService.deleteReaderById(id);
        return Response.noContent().build();
    }
}