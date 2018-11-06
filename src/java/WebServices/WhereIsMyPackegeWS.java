/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Beans.Usuario;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * REST Web Service
 *
 * @author gomes
 */
@Path("usuarios")
public class WhereIsMyPackegeWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WhereIsMyPackegeWS
     */
    public WhereIsMyPackegeWS() {
    }

    /**
     * Retrieves representation of an instance of WebServices.WhereIsMyPackegeWS
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("Application/json")
//    public Response obter() throws SQLException {
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Usuario usuario = new Usuario();
//        List<Usuario> listUsuario = new ArrayList<Usuario>();
//        listUsuario = usuarioDAO.buscarTodosUsuarios();
//        GenericEntity<List<Usuario>> lista = new GenericEntity<List<Usuario>>(listUsuario) {
//        };
//        return Response.ok().entity(lista).build();
//    }

    @POST
    @Path("/login")
   // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario login(@FormParam("usuario") String usuario, @FormParam("senha") String senha){
        Usuario u = new Usuario();
        UsuarioDAO uDAO = new UsuarioDAO();
        u = uDAO.lerUsuario(usuario, senha);
        return u;
    }

    /**
     * PUT method for updating or creating an instance of WhereIsMyPackegeWS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
