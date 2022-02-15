package s_seguimiento_usuarios.servidor;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import s_seguimiento_usuarios.sop_corba.*;

public class ServidorDeObjetos {

  public static void main(String args[]) {
    try{
      // crea e iniciia el ORB
      ORB orb = ORB.init(args, null);

      // obtiene la referencia del rootpoa & activate el POAManager
      POA rootpoa = 
      POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      //*** crea el servant y lo registra con el ORB ***
      GestionNotificacionesImpl convref = new GestionNotificacionesImpl();
      //convref.setORB(orb); 
      //*** crea un tie, con el servant como delegado***
      GestionNotificacionesPOATie gntie= new GestionNotificacionesPOATie(convref);
      
      //*** Obtener la referencia para el tie
      GestionNotificaciones reftie=gntie._this(orb);
	  
      // obtiene la base del contexto de nombrado
      org.omg.CORBA.Object objref =
          orb.resolve_initial_references("NameService");
      // Usa NamingContextExt el cual es parte de la especificacion 
      // Naming Service (INS).
      NamingContextExt ncref = NamingContextExtHelper.narrow(objref);
      System.out.println("Realizar binding de objNotificaciones ...");
      // *** Realiza el binding de la referencia de objeto en el N_S ***
      String name = "objNotificaciones";
      NameComponent path[] = ncref.to_name( name );
      ncref.rebind(path, reftie);

      System.out.println("El Servidor GestionPacientes esta listo y esperando ...");

      // esperan por las invocaciones desde los clientes
      orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Servidor: Saliendo ...");
	
  }
}
