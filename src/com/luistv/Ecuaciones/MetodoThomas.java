/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luistv.Ecuaciones;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author luistv
 */
public class MetodoThomas {

    public MetodoThomas() {
    }
    
    public void Thomas(int n1) {
        String leer;
        Scanner entrada = new Scanner(System.in);
        int i, j, k, h, n;
        double band, suma;
        double m[][];
        double u[][];
        double l[][];
        double r[];
        double z[];
        double x[];
        double a[];
        double b[];
        double c[];

        n = n1;
        m = new double[n][n];
        u = new double[n][n];
        l = new double[n][n];
        r = new double[n];
        x = new double[n];
        z = new double[n];
        a = new double[n];
        b = new double[n];
        c = new double[n - 1];
        for (i = 0; i <= n - 1; i++) {
            k = i + 1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + " del vestor de soluciones");
            r[i] = Double.parseDouble(leer);
            for (j = 0; j <= n - 1; j++) {
                h = j + 1;
                u[i][j] = 0;
                leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + h + " de la matriz de coeficientes");
                m[i][j] = Double.parseDouble(leer);
                if (i == j) {
                    l[i][j] = 1;
                } else {
                    l[i][j] = 0;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (i == 0) {
                b[i] = m[i][i];
                a[i] = 0;
                u[i][i] = b[i];
            } else {
                c[i - 1] = m[i - 1][i];
                a[i] = (m[i][i - 1]) / (b[i - 1]);
                b[i] = m[i][i] - ((a[i]) * (c[i - 1]));
                l[i][i - 1] = a[i];
                u[i][i] = b[i];
                u[i - 1][i] = c[i - 1];
            }
        }
        for (i = 0; i < n; i++) {
            k = i + 1;
            for (j = 0; j < n; j++) {
                h = j + 1;
                JOptionPane.showMessageDialog(null,"El elemento " + k + h + " de la matriz L es " + l[i][j]);
                JOptionPane.showMessageDialog(null,"El elemento " + k + h + " de la matriz U es " + u[i][j]);
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
            for (j = i; j < n;
                    j++) {
                if (i == j) {
                    suma = suma / u[i][j];
                } else {
                    suma = suma - ((x[j] * u[i][j]) / u[i][i]);
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
