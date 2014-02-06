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
public class FactorizacionCholesky {

    public FactorizacionCholesky() {
    }
    
    public void FactorizacionCholesky(int n1) {
        String leer;

       
        int i, j, s, k, h = 0, n;
        double band, suma;
        double m[][];
        double l[][];
        double lt[][];
        double r[];
        double z[];
        double x[];
        double a[];
        double b[];
        double c[];

        n = n1;
        m = new double[n][n];
        l = new double[n][n];
        lt = new double[n][n];
        r = new double[n];
        x = new double[n];
        z = new double[n];
        a = new double[n];
        b = new double[n];
        c = new double[n - 1];
        for (i = 0; i <= n - 1; i++) {
            k = i + 1;
            leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + " del vector de soluciones");
            r[i] = Double.parseDouble(leer);
            for (j = 0; j <= n - 1; j++) {
                h = j + 1;
                leer= JOptionPane.showInputDialog("Ingrese el elemento " + k + h + " de la matriz de coeficientes");
                m[i][j] = Double.parseDouble(leer);
                if (i == j) {
                    l[i][j] = 1;
                } else {
                    l[i][j] = 0;
                }
            }
            k = 0;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (m[i][j] != m[j][i]) {
                        k = 1;
                        h = 0;
                        for (i = 0; i < n; i++) {
                            for (j = 0; j < n; j++) {
                                if (m[i][j] < 0) {
                                    h = 1;
                                }
                            }
                        }
                        if (k == 0 && h == 0) {
                            l[0][0] = Math.sqrt(m[0][0]);
                        }
                        for (i = 0; i < n; i++) {
                            for (j = 0; j <= i; j++) {
                                if (i == j) {
                                    suma = 0;
                                    for (s = 0; s <= i - 1; s++) {
                                        suma = suma + Math.pow(l[i][s], 2);
                                    }
                                    l[i][i] = Math.sqrt(m[i][i] - suma);
                                } else {
                                    suma = 0;
                                    for (s = 0; s <= j - 1; s++) {
                                        suma = suma + (l[j][s]) * (l[i][s]);
                                    }
                                    l[i][j] = (m[i][j] - suma) / l[j][j];
                                }
                            }
                        }
                        for (i = 0; i < n; i++) {
                            k = i + 1;
                            for (j = 0; j < n; j++) {
                                h = j + 1;
                                JOptionPane.showMessageDialog(null,"El valor de la incognita x " + k + h + " es " + l[i][j]);
                            }
                        }
                        for (i = 0; i < n; i++) {
                            for (j = 0; j < n; j++) {
                                a[j] = l[i][j];
                            }
                            for (j = 0; j < n; j++) {
                                lt[j][i] = a[j];
                            }
                        }
                        for (i = 0; i < n; i++) {
                            k = i + 1;
                            for (j = 0; j < n; j++) {
                                h = j + 1;
                                JOptionPane.showMessageDialog(null,"El valor de la incognita lt " + k + h + " es " + lt[i][j]);
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
                                    suma = suma / lt[i][j];
                                } else {
                                    suma = suma - ((x[j] * lt[i][j]) / lt[i][i]);
                                }
                            }
                            x[i] = suma;
                        }
                        for (i = 0; i < n; i++) {
                            k = i + 1;
                            JOptionPane.showMessageDialog(null,"El valor de la incognita x " + k + " es " + x[i]);
                        }
                    } else {
                        if (k == 1 && h == 1) {
                           JOptionPane.showMessageDialog(null,"La matriz es asimetrica y no esta definida positivamente");
                        } else {
                            if (k == 1) {
                                JOptionPane.showMessageDialog(null,"La matriz es asimetrica");
                            } else {
                                JOptionPane.showMessageDialog(null,"La matriz no esta definida positivamente");
                            }
                        }
                    }
                }
            }
        }
    }

}
