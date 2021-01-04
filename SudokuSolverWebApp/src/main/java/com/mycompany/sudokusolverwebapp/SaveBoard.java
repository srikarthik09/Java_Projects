/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtexpo
 */
@XmlRootElement()
public class SaveBoard {
    private List<List<List<Integer>>> board;
    private String author;
    private String name;

    public List<List<List<Integer>>> getBoard() {
        return board;
    }

    public void setBoard(List<List<List<Integer>>> board) {
        this.board = board;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
