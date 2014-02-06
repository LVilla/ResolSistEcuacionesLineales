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
public class MetodoJacobi {

    public MetodoJacobi() {
    }
    
    public void Jacobi(int n1) {
        String leer;
        
        int n, k, i, j, h, banda, siga, mitra;
        double m[][];
        double r[];
        double x[];
        double s[];
        double cont[];
        double error[];
        double suma, l, tol;

        n = n1;
        leer= JOptionPane.showInputDialog("Ingrese la tolerancia");
        tol = Double.parseDouble(leer);
        leer= JOptionPane.showInputDialog("Ingrese el numero maximo de iteraciones");
        mitra = Integer.parseInt(leer);
        m = new double[n][n];
        r = new double[n];
        x = new double[n];
        s = new double[n];
        cont = new double[n];
        error = new double[n];
        for (i = 0; i <= n - 1; i++) {
            k = i + 1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + " del vector de soluciones ");
            r[i] = Double.parseDouble(leer);
            leer= JOptionPane.showInputDialog("Ingrese el valor en el cual quiere comenzar a evaluar x " + k);
            x[i] = Double.parseDouble(leer);
            s[i] = 0;
            for (j = 0; j <= n - 1; j++) {
                h = j + 1;
                leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + h + " de la matriz de Coeficientes ");
                m[i][j] = Double.parseDouble(leer);
            }
        }
        banda = 0;
        for (i = 0; i < n; i++) {
            suma = 0;
            for (j = 0; j < n; j++) {
                if (i != j) {
                    suma = suma + m[i][j];
                }
            }
            cont[i] = suma;
            if (Math.abs(m[i][i]) > cont[i]) {
                banda = banda + 1;
            }
        }
        if (banda == n) {
            siga = n - 1;
            int iter = 0;
            while (siga != n && iter < mitra) {
                iter = iter + 1;
                for (i = 0; i < n; i++) {
                    l = 0;
                    for (j = 0; j < n; j++) {
                        if (i == j) {
                            l = l + r[i] / m[i][j];
                        } else {
                            l = l - ((m[i][j] * x[j]) / m[i][i]);
                        }
                    }
                    s[i] = l;
                }
                for (i = 0; i < n; i++) {
                    error[i] = Math.abs((s[i] - x[i]) / s[i]) * 100;
                }
                for (i = 0; i < n; i++) {
                    x[i] = s[i];
                }
                siga = 0;
                for (i = 0; i < n; i++) {
                    if (error[i] < tol) {
                        siga = siga + 1;
                    }
                }
            }
            h = 0;
            for (i = 0; i < n; i++) {
                h = h + 1;
                JOptionPane.showMessageDialog(null,"El aproximado valor de la incognita x " + h + " es " + s[i]);
            }
            JOptionPane.showMessageDialog(null,"EL numer total de iteraciones de FUE de " + iter);
        } else {
            JOptionPane.showMessageDialog(null,"No se puede solucionar");
        }
    }
}
