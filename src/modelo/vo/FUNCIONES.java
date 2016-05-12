/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author Abelson
 */
public class FUNCIONES {
    
    static Double REDONDEAR(double valor,double decimales){
        return Math.round(valor*Math.pow(10,decimales))/Math.pow(10,decimales);
         
    }
    
}
