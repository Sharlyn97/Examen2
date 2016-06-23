/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Moon
 */
public class MetodosUsuario {
    
    Usuario principal;
    
    public MetodosUsuario()
    {}
    
    public void crear(String cedula, String nombre, int edad, String prioridad, int numCita, String fecha, Usuario siguiente)
    {
        if(principal==null)
        {
         principal=new Usuario( cedula,  nombre,  edad,  prioridad, numCita, fecha,  null);   
        }
        else
        {
            if(prioridad.equals("Normal"))
            {
                agregarAlFinal(cedula,  nombre,  edad,  prioridad, numCita, fecha,  siguiente);
            }
            else
            {
                Usuario temporal=new Usuario(cedula,  nombre,  edad,  prioridad, numCita, fecha,  null);
                temporal.setSiguiente(principal);
                principal=temporal;
            }
        }      
    }
    public void agregarAlFinal(String cedula, String nombre, int edad, String prioridad, int numCita,String fecha, Usuario principal)
    {
        Usuario temporal=devolverUltimoCliente();
        temporal.setSiguiente(new Usuario(cedula,  nombre,  edad,  prioridad, numCita, fecha,  null));
    }
    public Usuario devolverUltimoCliente()
    {
        Usuario temporal = principal;
        while(temporal.getSiguiente()!=null){
            temporal=temporal.getSiguiente();
        }
            return temporal;
    }
    
    public String imprimir()//Metodo para imprimir la información de la lista de nodos
    {
        String valores="";
        Usuario temporal=principal;

            while( temporal.getSiguiente()!=null)
            {
                if(temporal.getPrioridad().equals("Normal"))
                {
                    //System.out.println("prioridad: "+temporal.getPrioridad());
                    valores+=temporal.getNombre()+" Ficha: A"+temporal.getNumeroCita()+"\n";
                    //System.out.println(temporal.getNombre()+"Ficha: A"+temporal.getNumeroCita()+"\n");
                    temporal=temporal.getSiguiente();
                }
                else
                {
                        //System.out.println("prioridad: "+temporal.getPrioridad());
                        valores+=temporal.getNombre()+" Ficha: B"+temporal.getNumeroCita()+"\n";
                        //System.out.println(temporal.getNombre()+"Ficha: B"+temporal.getNumeroCita()+"\n");
                        temporal=temporal.getSiguiente();
                    
                }
            }
            
            if(temporal.getPrioridad().equals("Normal"))
            {
                valores+=temporal.getNombre()+" Ficha: A"+temporal.getNumeroCita()+"\n";
            }
            else
            {
                valores+=temporal.getNombre()+" Ficha: B"+temporal.getNumeroCita()+"\n";   
            }

        return valores;
    }
    
    public void ordenarMayorAMenor()//Lista lis, Comparar c) 
   {
        Usuario temporal, temporal2;
        temporal2 = principal;//datoB=1
        String auxNombre, auxPrioridad, auxCedula;
        int auxCita, auxEdad;
        while (temporal2 != null) {
            temporal = temporal2.getSiguiente();//datoA=2
            while (temporal != null) 
            {
               int dato1=temporal.getEdad();//1
               int dato2=temporal2.getEdad();//2
               
                if (dato1 > dato2) //datoA es mayor a dato2? 2>1
                {
                    auxNombre =temporal.getNombre();//2
                    auxCita=temporal.getNumeroCita();
                    auxEdad=temporal.getEdad();
                    auxPrioridad=temporal.getPrioridad();
                    auxCedula=temporal.getCedula();
                    
                    temporal.setNombre(temporal2.getNombre());//datoA=2
                    temporal.setNumeroCita(temporal2.getNumeroCita());
                    temporal.setEdad(temporal2.getEdad());
                    temporal.setPrioridad(temporal2.getPrioridad());
                    temporal.setCedula(temporal2.getCedula());
                    
                    temporal2.setNombre(auxNombre);
                    temporal2.setNumeroCita(auxCita);
                    temporal2.setEdad(auxEdad);
                    temporal2.setPrioridad(auxPrioridad);
                    temporal2.setCedula(auxCedula);
                }
                temporal = temporal.getSiguiente();//datoA=3
            }
            temporal2 = temporal2.getSiguiente();//2=3
        }
    }
    
    public void ordenarMenorAMayor()//Lista lis, Comparar c) 
   {
        Usuario temporal, temporal2;
        temporal2 = principal;//datoB=1
        String auxNombre, auxPrioridad, auxCedula;
        int auxCita, auxEdad;
        while (temporal2 != null) {
            temporal = temporal2.getSiguiente();//datoA=2
            while (temporal != null) 
            {
               int dato1=temporal.getEdad();//1
               int dato2=temporal2.getEdad();//2
               
                if (dato1 < dato2) //datoA es mayor a dato2? 2>1
                {
                    auxNombre =temporal.getNombre();//2
                    auxCita=temporal.getNumeroCita();
                    auxEdad=temporal.getEdad();
                    auxPrioridad=temporal.getPrioridad();
                    auxCedula=temporal.getCedula();
                    
                    temporal.setNombre(temporal2.getNombre());//datoA=2
                    temporal.setNumeroCita(temporal2.getNumeroCita());
                    temporal.setEdad(temporal2.getEdad());
                    temporal.setPrioridad(temporal2.getPrioridad());
                    temporal.setCedula(temporal2.getCedula());
                    
                    temporal2.setNombre(auxNombre);
                    temporal2.setNumeroCita(auxCita);
                    temporal2.setEdad(auxEdad);
                    temporal2.setPrioridad(auxPrioridad);
                    temporal2.setCedula(auxCedula);
                }
                temporal = temporal.getSiguiente();//datoA=3
            }
            temporal2 = temporal2.getSiguiente();//2=3
        }
    }
    
    public void eliminar(int NumeroCita)
    {
        Usuario auxiliar=principal;
        boolean haEliminado=false;
        if(auxiliar.getNumeroCita()==NumeroCita)
        {
            principal=principal.getSiguiente();
            haEliminado=true;
        }
        else
        {
            auxiliar=devolverUltimoNodo();
            if(auxiliar.getNumeroCita()==NumeroCita)
            {
                auxiliar=devolverAntepenultimoNodo();
                auxiliar.siguiente=null;
                haEliminado=true;
            }
        }
        if(!haEliminado)
        {
            Usuario temporal;
            auxiliar=devolverNodoAnterior(NumeroCita);
            temporal=auxiliar.getSiguiente().getSiguiente();
            auxiliar.siguiente=temporal;
        }
    }
    
    public Usuario devolverAntepenultimoNodo()
    {
        Usuario auxiliar=principal;
        while(auxiliar.getSiguiente().getSiguiente()!=null)
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
 
    public Usuario devolverNodoAnterior(int cita)
    {
        Usuario auxiliar=principal;
        while(auxiliar.getSiguiente().getNumeroCita()!=cita)
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    
    public Usuario devolverUltimoNodo()
    {
        Usuario auxiliar=principal;
        while(auxiliar.getSiguiente()!=null)
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    
   public int fichaAEliminar()
   {
       int valor=0;
       Usuario temporal=principal;
       
       if(temporal.getSiguiente()!=null)
       {
           valor=temporal.getNumeroCita();
       }
     return valor;  
   }
   
    public void eliminarConCedula(String Cedula)
    {
        Usuario auxiliar=principal;
        boolean haEliminado=false;
        if(auxiliar.getCedula().equals(Cedula))
        {
            principal=principal.getSiguiente();
            haEliminado=true;
        }
        else
        {
            auxiliar=devolverUltimoNodo();
            if(auxiliar.getCedula().equals(Cedula))
            {
                auxiliar=devolverAntepenultimoNodo();
                auxiliar.siguiente=null;
                haEliminado=true;
            }
        }
        if(!haEliminado)
        {
            Usuario temporal;
            auxiliar=devolverNodoAnteriorCedula(Cedula);
            temporal=auxiliar.getSiguiente().getSiguiente();
            auxiliar.siguiente=temporal;
        }
    }
    
    public Usuario devolverNodoAnteriorCedula(String cedula)
    {
        Usuario auxiliar=principal;
        while(auxiliar.getSiguiente().getCedula().equals(cedula))
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    
    public void modificarInformacion(String cedula, String nombre, int edad, String prioridad, String fecha)
    {
        Usuario auxiliar=principal;
        boolean encontroCed=false;
       boolean haModificado=false;

       
       while(auxiliar.getSiguiente()!=null){
            auxiliar=auxiliar.getSiguiente();
            if(auxiliar.getCedula().equals(cedula))
            {
                encontroCed=true;
            }
        }
       if(encontroCed==true)
       {
        auxiliar.setNombre(nombre);
        auxiliar.setEdad(edad);
        auxiliar.setPrioridad(prioridad);
        auxiliar.setFechaCita(fecha);
       }
       else
       {
           auxiliar=devolverUltimoNodo();
          if(auxiliar.getCedula().equals(cedula))
            {
                auxiliar.setNombre(nombre);
                auxiliar.setEdad(edad);
                auxiliar.setPrioridad(prioridad);
                auxiliar.setFechaCita(fecha);
            }
          else
          {
              
               auxiliar.setNombre(nombre);
                auxiliar.setEdad(edad);
                auxiliar.setPrioridad(prioridad);
                auxiliar.setFechaCita(fecha);
              //JOptionPane.showMessageDialog(null,"No existe esta cédula");
          }
       }   
        
    }    
}    
    

