/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosUsuario;
import Vista.FRM_VentanaCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Moon
 */
public class Controlador_FRM_VentanaCitas implements ActionListener{
 
    FRM_VentanaCitas ventana;
    MetodosUsuario metodos;
    
    public boolean registrarse=false;
    public  Controlador_FRM_VentanaCitas(FRM_VentanaCitas ventana)
    {
        this.ventana=ventana;
        metodos=new MetodosUsuario();
        ventana.generarNumeroCita(registrarse);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("Registrar"))
        {
            String[] arreglo=ventana.devolverInformacion();
            metodos.crear(arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]),arreglo[3],Integer.parseInt(arreglo[4]), arreglo[5], null);
            registrarse=true;
            ventana.generarNumeroCita(registrarse);
            ventana.imprimir(metodos.imprimir()); 
            ventana.limpiarVentana();
        }
        if(e.getActionCommand().equals("Siguiente"))
        {
           metodos.eliminar(metodos.fichaAEliminar());
           ventana.imprimir(metodos.imprimir()); 
        }
        if(e.getActionCommand().equals("Cancelar"))
        {
           metodos.eliminarConCedula(ventana.devolverCedula());
           ventana.imprimir(metodos.imprimir()); 
        }
        if(e.getActionCommand().equals("Modificar"))
        {
           metodos.modificarInformacion(ventana.devolverCedula(), ventana.devolverNombre(), ventana.devolverEdad(), ventana.devolverPrioridad(), ventana.devolverFecha());
           ventana.imprimir(metodos.imprimir()); 
           //ventana.limpiarVentana();
        }
        if(e.getActionCommand().equals("Reportes"))
        {
            System.out.println("rep");
        }
        if(e.getActionCommand().equals("Mayor a menor"))
        {
            metodos.ordenarMayorAMenor();
            ventana.imprimir(metodos.imprimir()); 
            ventana.limpiarVentana();
        }
        if(e.getActionCommand().equals("Menor a mayor"))
        {
            metodos.ordenarMenorAMayor();
            ventana.imprimir(metodos.imprimir()); 
            ventana.limpiarVentana();
        }
    }
    
}
