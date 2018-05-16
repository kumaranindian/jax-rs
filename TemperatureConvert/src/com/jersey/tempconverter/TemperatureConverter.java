package com.jersey.tempconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cts")
public class TemperatureConverter {
	
	@GET
	@Path("/{urlvalue1}/{urlvalue2}")
   // @Produces(MediaType.TEXT_HTML)
	public String sayHello_withparam(@PathParam("urlvalue1") int value,@PathParam("urlvalue2") String unit){		
		float  newvalue=0;
				if(unit.equalsIgnoreCase("c")){
					newvalue=((value * 9) / 5) + 32; // cel2fah
				}else if(unit.equalsIgnoreCase("f")){
					newvalue= (value-32)* 5/9 ; // fah2cel
				}
		return String.valueOf(newvalue);
		
	}

}
