package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/GestionNotificacionesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from s_seguimiento_usuarios.idl
* martes 15 de febrero de 2022 10:52:26 AM COT
*/

public class GestionNotificacionesPOATie extends GestionNotificacionesPOA
{

  // Constructors

  public GestionNotificacionesPOATie ( s_seguimiento_usuarios.sop_corba.GestionNotificacionesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionNotificacionesPOATie ( s_seguimiento_usuarios.sop_corba.GestionNotificacionesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public s_seguimiento_usuarios.sop_corba.GestionNotificacionesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (s_seguimiento_usuarios.sop_corba.GestionNotificacionesOperations delegate ) {
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
  public void notificarRegistro (s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTO objNotificacion)
  {
    _impl.notificarRegistro(objNotificacion);
  } // notificarRegistro

  private s_seguimiento_usuarios.sop_corba.GestionNotificacionesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionNotificacionesPOATie