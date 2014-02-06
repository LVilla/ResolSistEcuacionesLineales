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
public class MetodoGaussJordan {

    public MetodoGaussJordan() {
    }
    
    public void MetodoGaussJordan(int n1) {
        String leer;
       
        int i,j,s,k,h,n,x,y;
        double d,c;
        double m[][];
        double r[];
        n= n1;
        m= new double [n][n];
        r= new double [n];
        for(i=0;i<=n-1;i++){
            k=i+1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento "+k+" del vector de soluciones");
            r[i]= Double.parseDouble(leer);
            for(j=0;j<=n-1;j++){
                h=j+1;
                leer= JOptionPane.showInputDialog("Ingrese el elemento "+k+h+" de la matriz de coeficientes");
                m[i][j]= Double.parseDouble(leer);
        }
        for(i=0;i<=n-1;i++){
            d=m[i][i];
            for(s=0;s<=n-1;s++){
                m[i][s]=((m[i][s])/d);
            }
            r[i]=((r[i])/d);
            for(x=0;x<=n-1;x++){
                if(i!=x){
                    c=m[x][i];
                    for(y=0;y<=n-1;y++){
                        m[x][y]=m[x][y]-c*m[i][y];
                    }
                    r[x]=r[x]-c*r[i];}
                }
            }
            for(i=0;i<=n-1;i++){
                k=i+1;
                JOptionPane.showMessageDialog(null,"El valor de la incognita x "+k+" es "+r[i]);
            }
        }
    }
}
