package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;
import servidorDeAlertas.sop_corba.*;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.*;

public class ClienteDeObjetos {
  //*** Atributo estático ***
  static GestionPacientes ref;

  public static void main(String args[]){
    String nombre="";
    String apellido="";
    String aux="";
    int edad;
    int numHabitacion;
    
      try{
        // crea e inicia el ORB
	      ORB orb = ORB.init(args, null);

        // obtiene la base del naming context
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        // usa NamingContextExt en lugar de NamingContext.Esto es 
        // parte del Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // *** Resuelve la referencia del objeto en el N_S ***
        String name = "objPaciente";
        ref = GestionPacientesHelper.narrow(ncRef.resolve_str(name));
        System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
        
        boolean salir = false;
        int userOpcion = 0;

        while(!salir){          
          userOpcion = menu();
          switch (userOpcion) {
            case 1:
              Scanner input = new Scanner(System.in);
              BooleanHolder resp = new BooleanHolder();
              System.out.print("Ingrese el nombre: ");
              nombre = input.nextLine();
              System.out.print("Ingrese el apellido: ");
              apellido = input.nextLine();
              System.out.print("Ingrese la edad: ");
              aux = input.nextLine();
              edad = Integer.parseInt(aux);
              System.out.print("Ingrese la numHabitacion: ");
              aux = input.nextLine();
              numHabitacion = Integer.parseInt(aux);
              pacienteDTO pacDTO = new pacienteDTO(nombre, apellido, numHabitacion, edad);
              System.out.println("Creado el pacienteDTO");
              ref.registrarPaciente(pacDTO, resp);
              System.out.println("retornando de registrarPaciente()...");
              if (resp.value) {
                System.out.println("El paciente ha sido registrado");
              } else {
                System.out.println("El paciente no pudo ser registrado");
              }
              break; 
            case 2:
              Scanner input1 = new Scanner(System.in);
              pacienteDTOHolder pac = new pacienteDTOHolder();
              System.out.print("Ingrese el numero de habitacion: ");
              aux = input1.nextLine();
              numHabitacion=Integer.parseInt(aux);
              boolean consulta = ref.buscarPaciente(numHabitacion, pac);
              if (consulta) {
                nombre = pac.value.nombre;
                apellido = pac.value.apellido;
                edad = pac.value.edad;
                numHabitacion=pac.value.numeroHabitacion;
                
                System.out.println("Datos del paciente");
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Numero Habitacion: " + numHabitacion);
              } else {
                System.out.println("Paciente no encontrado");
              }
              break;
            case 3:
              salir = true;
              break;
            default:
                System.out.println("Solo hay 3 opciones disponibles");
              break;
          }
        }
        

    } catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
      }
  }

  public static int menu() {
    int opcion;
    Scanner input = new Scanner(System.in);

    System.out.println("====== MENU ======");
    System.out.println("-------------------------\n");
    System.out.println("1. Registrar paciente");
    System.out.println("2. Consultar paciente");
    System.out.println("3. Salir");
    System.out.print("Opcion: ");
    opcion = input.nextInt();
    return opcion;    
  }
}

