package servidorDeNotificaciones.sop_corba;


/**
* servidorDeNotificaciones/sop_corba/GestionNotificacionesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from notificaciones.idl
* domingo 13 de febrero de 2022 06:56:49 PM COT
*/

public class GestionNotificacionesPOATie extends GestionNotificacionesPOA
{

  // Constructors

  public GestionNotificacionesPOATie ( servidorDeNotificaciones.sop_corba.GestionNotificacionesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionNotificacionesPOATie ( servidorDeNotificaciones.sop_corba.GestionNotificacionesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorDeNotificaciones.sop_corba.GestionNotificacionesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorDeNotificaciones.sop_corba.GestionNotificacionesOperations delegate ) {
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
  public void notificarRegistro (servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO objNotificacion)
  {
    _impl.notificarRegistro(objNotificacion);
  } // notificarRegistro

  private servidorDeNotificaciones.sop_corba.GestionNotificacionesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionNotificacionesPOATie
