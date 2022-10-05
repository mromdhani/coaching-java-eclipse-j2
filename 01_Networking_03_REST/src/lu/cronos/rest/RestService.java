package lu.cronos.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
  
@Path("/message")
public class RestService
{
    @GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2";
    }
}