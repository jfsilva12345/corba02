package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/GestionPersonalPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from s_gestion_usuarios.idl
* martes 15 de febrero de 2022 10:52:48 AM COT
*/

public class GestionPersonalPOATie extends GestionPersonalPOA
{

  // Constructors

  public GestionPersonalPOATie ( s_gestion_usuarios.sop_corba.GestionPersonalOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPersonalPOATie ( s_gestion_usuarios.sop_corba.GestionPersonalOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public s_gestion_usuarios.sop_corba.GestionPersonalOperations _delegate() {
      return this._impl;
  }
  public void _delegate (s_gestion_usuarios.sop_corba.GestionPersonalOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void registrarPersonal (s_gestion_usuarios.sop_corba.GestionPersonalPackage.personalDTO objPersonal, org.omg.CORBA.BooleanHolder res)
  {
    _impl.registrarPersonal(objPersonal, res);
  } // registrarPersonal

  public boolean consultarPersonal (int id, s_gestion_usuarios.sop_corba.GestionPersonalPackage.personalDTOHolder objPersonal)
  {
    return _impl.consultarPersonal(id, objPersonal);
  } // consultarPersonal

  public int abrirSesion (s_gestion_usuarios.sop_corba.GestionPersonalPackage.CredencialDTO objCredencial)
  {
    return _impl.abrirSesion(objCredencial);
  } // abrirSesion

  private s_gestion_usuarios.sop_corba.GestionPersonalOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPersonalPOATie