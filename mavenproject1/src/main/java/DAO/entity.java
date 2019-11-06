/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
*
* @author pedago
*/
public class entity {

private String code;
private double taux;

public entity(String code, double taux) {
this.code = code;
this.taux = taux;
}

/**
* Get the value of code
*
* @return the value of code
*/
public String getCode() {
return code;
}

/**
* Get the value of taux
*
* @return the value of taux
*/
public double getTaux() {
return taux;
}

}