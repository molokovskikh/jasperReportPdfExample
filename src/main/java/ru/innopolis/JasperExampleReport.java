package ru.innopolis;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import static ru.innopolis.JasperReportGeneartor.generateJasperReportPdf;

@Path("/jasperreport")
public class JasperExampleReport {

    @Context
    ServletContext servletContext;

    @GET
    @Path("/echo")
    public Response getEcho(@QueryParam("message") String message) {
        return Response.ok(message).build();
    }

    @GET
    @Path("/pdf")
    @Produces("application/pdf")
    public Response getPdf() {
	StreamingOutput report = out -> generateJasperReportPdf(out, servletContext);
	return Response.ok(report)
		.header("Content-Disposition","attachment; filename=jasperReportExample.pdf")
		.build();
    }



}
