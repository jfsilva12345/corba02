package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import s_gestion_usuarios.sop_corba.*;
import cliente.Utilidades.*;
import s_gestion_usuarios.sop_corba.GestionPersonalPackage.*;
import java.rmi.RemoteException;


public class ClienteDeObjetos {

    static GestionPersonalOperations refPersonal;
   
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            // obtiene la base del naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // usa NamingContextExt en lugar de NamingContext.Esto es 
            // parte del Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
    
            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objPaciente";
            refPersonal = GestionPersonalHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + refPersonal);
                        
            // int rta = 0;
            // do {
            //     rta = menu();
                
            //     switch(rta){
            //         case 1:
            //             opcion1();
            //         break;                        
            //         case 2:
            //             opcion2();
            //         break;
            //         case 3:
            //             opcion3();
            //         break;
            //     }
                
            // }while(rta != 4);

            MenuPrincipal();
            

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
   
    private static void MenuPrincipal()
    {
        int opcion = 0;
        do{
            System.out.println("==Menu Inicio==");
            System.out.println("1. Abrir Sesion");			
            System.out.println("2. Salir");

            opcion = UtilidadesConsola.leerEntero();

             switch(opcion)
            {
                case 1:
                        System.out.println("Ingrese el usuario");
                        String varCrUsuario = UtilidadesConsola.leerCadena();
                        System.out.println("Ingrese la clave");
                        String varCrClave = UtilidadesConsola.leerCadena();
                        CredencialDTO objCredencial = new CredencialDTO(varCrUsuario,varCrClave);
                        System.out.println(objCredencial);
                        int sesion = -1;
                        System.out.println(sesion);
                        System.out.println(refPersonal.abrirSesion(objCredencial));
                        sesion = refPersonal.abrirSesion(objCredencial);

                        switch(sesion){
                            case 0:
                                OpcionAdmin();
                                break;
                            case 1:
                                OpcionPaf();
                                break;
                            case 2:
                                OpcionSecre();
                                break;
                            case -1:
                                System.out.println("El personal"+objCredencial.usuario+"No esta autorizado para ingresar al sistema");
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                break;

                case 2:
                        System.out.println("Salir...");
                break;
                
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcion != 2);
        
    }

    private static void OpcionAdmin(){
        int opcionAdmin=0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Registrar personal");			
            System.out.println("2. Consultar personal");
            System.out.println("3. Salir");

            opcionAdmin = UtilidadesConsola.leerEntero();

            switch(opcionAdmin)
            {
                case 1:
                        Opcion1();
                        break;
                case 2:
                        Opcion2();
                        break;	
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionAdmin != 3);
    }


    private static void OpcionPaf(){
         int opcionPaf=0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Valorar PAF");			
            System.out.println("2. Registrar Asistencia");
            System.out.println("3. Salir");

            opcionPaf = UtilidadesConsola.leerEntero();

            switch(opcionPaf)
            {
                case 1:
                        System.out.println("por implementar");
                        break;
                case 2:
                        System.out.println("por implementar");
                        break;	
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionPaf != 3);
    }

     private static void OpcionSecre(){
         int opcionSecre = 0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Registrar usuario");			
            System.out.println("2. Consultar usuario");
            System.out.println("3. Salir");

            opcionSecre = UtilidadesConsola.leerEntero();

            switch(opcionSecre)
            {
                case 1:
                        System.out.println("por implementar");
                        break;
                case 2:
                        System.out.println("por implementar");
                        break;	
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcionSecre != 3);
    }

    private static void Opcion1() 
    {
        System.out.println("==Registro del Cliente==");
        boolean bandera=false;
        int opcionTI = 0;
        String varTipoIdentificacion="";

            System.out.println("==TIPO DE IDENTIFICACION==");
            System.out.println("1. Cedula de Ciudadania");			
            System.out.println("2. Tarjeta de Identidad");
            System.out.println("3. Pasaporte");
            


            opcionTI = UtilidadesConsola.leerEntero();

            if(opcionTI==1){
                varTipoIdentificacion="CC";
            }else if(opcionTI==2){
                varTipoIdentificacion="TI";
            }else if(opcionTI==3){
                varTipoIdentificacion="PP";
            }else{
                bandera=true;
            }


        System.out.println("Ingrese el numero de identificacion");
        int varId = UtilidadesConsola.leerEntero();
        if (varId < 0){
            bandera = true;
        }

        System.out.println("Ingrese el nombre completo ");
        String varNombres = UtilidadesConsola.leerCadena();

        System.out.println("Ingrese la ocupacion del nuevo usuario ");
        String varOcupacion="";

            System.out.println("==TIPO DE OCUPACION==");
            System.out.println("1. Secretaria");			
            System.out.println("2. Profesional de acondicionamiento fisico");
            

            opcionTI = UtilidadesConsola.leerEntero();


            if(opcionTI==1){
                varOcupacion="Secretaria";
            }else if(opcionTI==2){
                varOcupacion="Personal de acondicionamiento fisico";
            }else{
                bandera=true;
            }



      

        System.out.println("Ingrese el usuario ");
        String varUsuario = UtilidadesConsola.leerCadena();

        if (varUsuario.length()<8){
            bandera=true;
        }


        System.out.println("Ingrese la contraseña ");
        String varClave = UtilidadesConsola.leerCadena();

        if (varClave.length()<8){
            bandera=true;
        }
        if(!bandera){

            personalDTO objUsuario= new personalDTO(varTipoIdentificacion, varId, varNombres,varOcupacion,varUsuario,varClave);

            BooleanHolder resp=new BooleanHolder();
            refPersonal.registrarPersonal(objUsuario,resp);//invocación al método remoto
            if(resp.value)
                    System.out.println("Registro realizado satisfactoriamente...");
            else
                    System.out.println("no se pudo realizar el registro...");


        }else{
            System.out.println("datos erroneos");
        }
    }

    private static void Opcion2()
    {	
        int id = -1;
        System.out.println("========================");
        System.out.println("==Consulta de personal==");
        System.out.println("========================");

        System.out.println("Digite el id del personal a buscar");

        id = UtilidadesConsola.leerEntero();

        personalDTOHolder personal  = new personalDTOHolder();
        boolean valor = true;
        valor = refPersonal.consultarPersonal(id, personal);
        System.out.println(valor);

        if (valor) {
            System.out.println(personal.value.tipo_id);
            System.out.println(personal.value.id);
            System.out.println(personal.value.usuario);
            System.out.println(personal.value.nombreCompleto);
            System.out.println(personal.value.ocupacion);
        }else{
            System.out.println("Usuario NO encontrado");

        }
    }
    

}