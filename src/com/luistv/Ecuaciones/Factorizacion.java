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
public class Factorizacion extends Menu{
    public Factorizacion() {
    }

    public void Factorizar(int n1) {

        String leer;
        int i, j, h, k = 0, n = n1, s;

        double c, suma;
        double m[][];
        double l[][];
        double r[];
        double z[];
        double x[];

        m = new double[n][n];
        l = new double[n][n];
        r = new double[n];
        x = new double[n];
        z = new double[n];
        for (i = 0; i <= n - 1; i++) {
            k = i + 1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + " del vector de soluciones.");
            r[i] = Double.parseDouble(leer);
            for (j = 0; j <= n - 1; j++) {
                h = j + 1;
                leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + h + " de la matriz de coeficientes ");
                m[i][j] = Double.parseDouble(leer);
                if (i == j) {
                    l[i][j] = 1;
                } else {
                    l[i][j] = 0;
                }
            }
        }
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                c = (m[j][i]) / m[i][i];
                for (s = 0; s < n; s++) {
                    m[j][s] = m[j][s] - c * m[i][s];
                }
                l[j][i] = c;
            }
        }
        for (i = 0; i < n; i++) {
            suma = r[i];
            for (j = i; j >= 0; j--) {
                if (i == j) {
                    suma = suma / l[i][j];
                } else {
                    suma = suma - ((z[j] * l[i][j]) / l[i][i]);
                }
            }
            z[i] = suma;
        }
        for (i = n - 1; i >= 0; i--) {
            suma = z[i];
            for (j = i; j < n; j++) {
                if (i == j) {
                    suma = suma / m[i][j];
                } else {
                    suma = suma - ((x[j] * m[i][j]) / m[i][i]);
                }
            }
            x[i] = suma;
        }
        for (i = 0; i < n; i++) {
            k = i + 1;
            JOptionPane.showMessageDialog(null,"El valor de la incognita x " + k + " es " + x[i]);


        }
            

    }
}
