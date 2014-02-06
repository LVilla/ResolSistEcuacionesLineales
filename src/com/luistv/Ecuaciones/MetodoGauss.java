/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luistv.Ecuaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author luistv
 */
public class MetodoGauss {

    public MetodoGauss() {
    }
    
    public void MetodoGauss(int n1){
       String leer;
        // TODO code application logic here
        
        int i, j, s, k, h, n;
        double d , yx;
        double m [] [];
        double r [];
        double x [];
        
        n = n1;
        m = new double [n] [n];
        r = new double [n];
        x= new double [n];
        for(i=0;i<=n-1;i++){
            k=i+1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento "+k+" del vector de soluciones");
            r[i]= Double.parseDouble(leer);
            x[i]=0;
            for(j=0;j<=n-1;j++){
                h=j+1;
                leer= JOptionPane.showInputDialog("Ingrese el elemento "+k+h+" de la matriz de coeficientes");
                m[i][j]= Double.parseDouble(leer);
            }
        }
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                if(i==j){
                    d = m[i][j];
                    for(s=0;s<n;s++){
                        m[i][s]=((m[i][s])/d);
                    } r[i]=((r[i])/d);
                }
                else{
                    d = m[j][i];
                    for(s=0;s<n;s++){
                        m[j][s]=m[j][s]-(d*m[i][s]);
                    } r[j]=r[j]-(d*r[i]);
                }
            }
        }  for(i=n-1;i>=0;i--){
            double y=r[i];
            for(j=n-1;j>=i;j--){
                y=x[j]*m[i][j];
            }
            x[i]=y;
        }
        for(i=0;i<n;i++){
            k=i+1;
            JOptionPane.showMessageDialog(null,"EL valor de la incognita x "+k+" es "+x[i]);
        }
    }
}
