package com.nt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/plan")
public class PlanResource {

    @GET
    @Produces("text/plan")
    publi String getPlanName(@QueryParam("PlanNo") int planNo){
        return "Plan No : "+planNo;
    }
}
