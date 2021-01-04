/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author jtexpo
 */
@Path("SAVEBOARDWS")
public class SaveSudokuBoardWS {
    
    @EJB
    private SudokuService sService;
    
    @POST
    @Consumes("application/json")
    public Response create(SaveBoard sb){   
        sService.insert(sb);
        return null;
    }
    
}
