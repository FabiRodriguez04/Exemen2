/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiodecaso2;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class HabitaHotel {

    private String[][] habitaciones;

    public HabitaHotel() {
        habitaciones = new String[4][4];
        Habitacioness();
    }

    private void Habitacioness() {
        ///Numero de habitacion
        habitaciones[0] = new String[]{"L", "O", "O", "S"};
        habitaciones[1] = new String[]{"O", "L", "L", "L"};
        habitaciones[2] = new String[]{"S", "S", "L", "S"};
        habitaciones[3] = new String[]{"L", "L", "O", "L"};
    }

    public void MostrarHabitaciones() {
        String imprimirHabitaciones = "A continuación se mostrarán las habitaciones del Hotel\n"
                + "Habitaciones:\n" + mostrar(habitaciones);
        JOptionPane.showMessageDialog(null, imprimirHabitaciones);
    }

    private String mostrar(String[][] habi) {
        String mostrarhabi = "";
        for (int i = 0; i < habi.length; i++) {
            for (int j = 0; j < habi[i].length; j++) {
                mostrarhabi = mostrarhabi + "| " + habi[i][j] + " ";
            }
            mostrarhabi = mostrarhabi + "|\n";
        }
        return mostrarhabi;
    }

    public void ReservarHabitacion() {
        boolean continuar = true;

        while (continuar) {
            int habi = Integer.parseInt(JOptionPane.showInputDialog("Desea reservar una habitacion?(1= Si 2= No)"));
            if (habi < 1 || habi > 2) {
                JOptionPane.showMessageDialog(null, "Número de nivel incorrecto. Intente nuevamente.");
                continue;
            }

            String[][] HabitacionSeleccionada = null;
            if (habi == 1) {
                HabitacionSeleccionada = habitaciones;
            } else {
                JOptionPane.showMessageDialog(null, "Gracias!");
            }
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila en la que desea reservar la habitacion")) - 1;
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna en la que desea reservar la habitacion")) - 1;

            // Verificar si la fila y columna están dentro del rango del nivel seleccionado
            if (fila < 0 || fila >= HabitacionSeleccionada.length || columna < 0 || columna >= HabitacionSeleccionada[0].length) {
                JOptionPane.showMessageDialog(null, "Fila o columna fuera de rango. Intente nuevamente.");
                continue;
            }
            
           String estado = HabitacionSeleccionada[fila][columna];
            if (estado.equals("O")) {
                HabitacionSeleccionada[fila][columna] = "L"; // para reservar el espacio
                JOptionPane.showMessageDialog(null, "Reserva exitosa");
            } else if (estado.equals("O") || estado.equals("S")) {
                JOptionPane.showMessageDialog(null, "No se puede reservar en este espacio");
            } else {
                JOptionPane.showMessageDialog(null, "El espacio seleccionado no está disponible");
            }


        }

    }

}



