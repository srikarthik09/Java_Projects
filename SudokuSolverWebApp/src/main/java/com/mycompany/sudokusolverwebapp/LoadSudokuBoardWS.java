/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author jtexpo
 */
@Path("LOADSUDOKUBOARDWS")
public class LoadSudokuBoardWS {
    
    @EJB
    private SudokuService sService;
    
    @GET
    @Produces("application/json")
    public Response create(){
        return Response.ok(sService.getNames()).build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response Create(LoadBoardResponse lbr){   
        return Response.ok(sService.getBoard(lbr.getId())).build();
    }
    
}
