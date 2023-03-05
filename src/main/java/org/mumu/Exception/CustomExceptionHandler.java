package org.mumu.Exception;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {

    @ConfigProperty(name = "app-muhyi.custom.error.msg.notfound")
    String notFound;

    @Override
    public Response toResponse(CustomException e) {
        if (e.getMessage().equalsIgnoreCase(notFound)) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ErrorMessage(e.getMessage(), false))
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(new ErrorMessage(e.getMessage(), false))
                    .build();
        }
    }
}
