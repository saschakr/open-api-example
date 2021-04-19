package de.example.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.example.ExampleFromJAR;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

  @APIResponses(
      value = {
          @APIResponse(responseCode = "200", name = "OK",
                       content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExampleFromWAR.class)))
      }
      )
  @Operation(description = "example", operationId = "ExampleFromWAR")
  @Tag(name = "example")
  @GET
  @Path("/test")
  public ExampleFromWAR test() {
    return null;
  }


  @APIResponses(
      value = {
          @APIResponse(responseCode = "200", name = "OK",
                       content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExampleFromJAR.class)))
      }
      )
  @Operation(description = "example2", operationId = "ExampleFromJAR")
  @Tag(name = "example")
  @GET
  @Path("/test2")
  public ExampleFromJAR test2() {
    return null;
  }


}
