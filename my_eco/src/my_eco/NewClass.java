/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_eco;

/**
 *
 * @author maibenben
 */
public enum NewClass {
    jikewei("jikewei");
    String nameString;
    private NewClass(String name){
        this.nameString=name;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }
    

}
