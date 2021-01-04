package com.mycompany.sudokusolverwebapp;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jtexpo
 */
@Path("SODUKUSOLVER")
public class SudokuSolverWS {
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(SudokuBoard sb){
        sb.solveBoard();
        return Response.ok(sb.getBoard()).build();
    }
    
}
