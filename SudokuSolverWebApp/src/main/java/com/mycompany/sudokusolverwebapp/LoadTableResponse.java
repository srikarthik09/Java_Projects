/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtexpo
 */
@XmlRootElement()
public class LoadTableResponse {
    private int loadNumber;
    private boolean loadNames;

    public int getLoadNumber() {
        return loadNumber;
    }

    public void setLoadNumber(int loadNumber) {
        this.loadNumber = loadNumber;
    }

    public boolean isLoadNames() {
        return loadNames;
    }

    public void setLoadNames(boolean loadNames) {
        this.loadNames = loadNames;
    }
    
    
}
