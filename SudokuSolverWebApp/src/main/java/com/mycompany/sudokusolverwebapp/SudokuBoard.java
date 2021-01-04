package com.mycompany.sudokusolverwebapp;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jtexpo
 */
@XmlRootElement()
public class SudokuBoard {
    private List<List<List<Integer>>> board;

    public List<List<List<Integer>>> getBoard() {
        return board;
    }

    public void setBoard(List<List<List<Integer>>> board) {
        this.board = board;
    }
    
    private List<Integer> simplePick(int quad, int tile){
        int sp_hor_quad = 3*(quad / 3);
        int sp_hor_tile;
        int sp_vert_quad = quad % 3;
        int sp_vert_tile;

        if (board.get(quad).get(tile).size() == 1){
            return board.get(quad).get(tile);
        }
        
        for (int t = 0; t < 9; t++){
            if (t == tile){
                continue;
            }
            if (board.get(quad).get(t).size() == 1){
                board.get(quad).get(tile).remove(board.get(quad).get(t).get(0));
            }
        }
        
        for (int q = 0; q < 3; q++, sp_hor_quad++,sp_vert_quad+=3){
            
            sp_hor_tile = 3*(tile / 3);
            for (int h = 0; h < 3; h++, sp_hor_tile++){
                if ((sp_hor_quad == quad)&&(sp_hor_tile == tile)){
                    continue;
                }
                if (board.get(sp_hor_quad).get(sp_hor_tile).size() == 1){
                    board.get(quad).get(tile).remove(board.get(sp_hor_quad).get(sp_hor_tile).get(0));
                }
            }
            
            sp_vert_tile = tile % 3;
            for (int v = 0; v < 3; v++, sp_vert_tile+=3){
                if ((sp_vert_quad == quad)&&(sp_vert_tile == tile)){
                    continue;
                }
                if (board.get(sp_vert_quad).get(sp_vert_tile).size() == 1){
                    board.get(quad).get(tile).remove(board.get(sp_vert_quad).get(sp_vert_tile).get(0));
                }
            }
        }
        
        return board.get(quad).get(tile);
    }
    
    private boolean checkSolved(){
        for (int q = 0; q < 9; q++){
            for (int t = 0; t < 9; t++){
                if (board.get(q).get(t).size() > 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean boardsAreEqual(List<List<List<Integer>>> oldboard){
        for (int q = 0; q < 9; q++){
            for(int t = 0; t < 9; t++){
                if (oldboard.get(q).get(t).size() != board.get(q).get(t).size()){
                    return false;
                }
            }
        }
        return true;
    }
    
    private List<Integer> guessPick(){
        int smallestListSize = 9;
        List<Integer> qnt = new ArrayList<Integer>();
        for (int q = 0; q < 9; q++){
            for (int t = 0; t < 9; t++){
                if ((board.get(q).get(t).size() < smallestListSize)&&
                    (board.get(q).get(t).size() != 1)){
                    smallestListSize = board.get(q).get(t).size();
                }
            }
        }
        
        for (int q = 0; q < 9; q++){
            for (int t = 0; t < 9; t++){
                if (board.get(q).get(t).size() == smallestListSize){
                    qnt.add(q);
                    qnt.add(t);
                    return qnt;
                }
            }
        }
        
        return null;
    }
    
    private boolean emptyTileInBoard(){
        for (int q = 0; q < 9; q++){
            for (int t = 0; t < 9; t++){
                if (board.get(q).get(t).isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void solveBoard(){
        boolean isSolved = false;
        int quadrent = 0;
        int tile = 0;
        int holdnum = 0;
        
        List<Integer> qnt = new ArrayList<Integer>(){};
        
        List<List<List<List<Integer>>>> backupboards = new ArrayList<List<List<List<Integer>>>>(){};
        List<List<List<Integer>>> oldboard = new ArrayList<List<List<Integer>>>(){};
        
        for (int q = 0; q < 9; q++){
            oldboard.add(new ArrayList<>());
            for(int t = 0; t < 9; t++){
                oldboard.get(q).add(new ArrayList<>());
                for (int g = 0; g < board.get(q).get(t).size(); g++){
                    oldboard.get(q).get(t).add(board.get(q).get(t).get(g));
                }
            }
        }
                
        while (!isSolved){
            for (quadrent = 0; quadrent < 9; quadrent++){
                for(tile = 0; tile < 9; tile++){
                    board.get(quadrent).set(tile,simplePick(quadrent,tile));
                }
            }
            if (boardsAreEqual(oldboard)){
                backupboards.add(new ArrayList<>());
                for (int q = 0; q < 9; q++){
                    backupboards.get(backupboards.size()-1).add(new ArrayList<>());
                    for(int t = 0; t < 9; t++){
                        backupboards.get(backupboards.size()-1).get(q).add(new ArrayList<>());
                        for (int g = 0; g < board.get(q).get(t).size(); g++){
                            backupboards.get(backupboards.size()-1).get(q).get(t).add(board.get(q).get(t).get(g));
                        }
                    }
                }
                qnt = guessPick();
                backupboards.get(backupboards.size()-1).get(qnt.get(0)).get(qnt.get(1)).remove(0);
                holdnum = board.get(qnt.get(0)).get(qnt.get(1)).get(0);
                board.get(qnt.get(0)).get(qnt.get(1)).clear();
                board.get(qnt.get(0)).get(qnt.get(1)).add(holdnum);
            }else{
                oldboard.clear();
                for (int q = 0; q < 9; q++){
                    oldboard.add(new ArrayList<>());
                    for(int t = 0; t < 9; t++){
                        oldboard.get(q).add(new ArrayList<>());
                        for (int g = 0; g < board.get(q).get(t).size(); g++){
                            oldboard.get(q).get(t).add(board.get(q).get(t).get(g));
                        }
                    }
                }
            }   
            if (emptyTileInBoard()){
                board.clear();
                for(int q = 0; q < 9; q++){
                    board.add(new ArrayList<>());
                    for(int t = 0; t < 9; t++){
                        board.get(q).add(new ArrayList<>());
                        for (int g = 0; g < backupboards.get(0).get(q).get(t).size(); g++){
                            board.get(q).get(t).add(backupboards.get(0).get(q).get(t).get(g));
                        }
                    }
                }
                backupboards.remove(0);
                oldboard.clear();
                for (int q = 0; q < 9; q++){
                    oldboard.add(new ArrayList<>());
                    for(int t = 0; t < 9; t++){
                        oldboard.get(q).add(new ArrayList<>());
                        for (int g = 0; g < board.get(q).get(t).size(); g++){
                            oldboard.get(q).get(t).add(board.get(q).get(t).get(g));
                        }
                    }
                }
            }
            
            isSolved = checkSolved();
        } 
    }
    
}
