/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jtexpo
 */
@Stateless
public class SudokuService {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(SaveBoard sb){   
        SQLSudokuBoard sqlsb = new SQLSudokuBoard();
        sqlsb.ConvertArrayToIndiVals(sb.getBoard());
        sqlsb.setAuthor(sb.getAuthor());
        sqlsb.setName(sb.getName());
        em.persist(sqlsb);
    }
    
    public List<NameResponse> getNames(){
        TypedQuery<SQLSudokuBoard> query = em.createQuery("SELECT s FROM SQLSudokuBoard s", SQLSudokuBoard.class);
        List<SQLSudokuBoard> allBoards = query.getResultList();
        List<NameResponse> listOfNames = new ArrayList<>();
        
        for (int i = 0; i < allBoards.size(); i++){
            listOfNames.add(new NameResponse());
            listOfNames.get(i).setAuthor(allBoards.get(i).getAuthor());
            listOfNames.get(i).setName(allBoards.get(i).getName());
        }
        
        return listOfNames;
    }
    
    public List<List<List<Integer>>> getBoard(int boardInt){
        TypedQuery<SQLSudokuBoard> query = em.createQuery("SELECT s FROM SQLSudokuBoard s", SQLSudokuBoard.class);
        List<List<List<Integer>>> board = query.getResultList().get(boardInt).IndiValsToArray();
        return board;
    }
    
}
