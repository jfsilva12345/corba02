package servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage;

/**
* servidorDeNotificaciones/sop_corba/GestionNotificacionesPackage/ClsMensajeNotificacionDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from notificaciones.idl
* domingo 13 de febrero de 2022 06:56:49 PM COT
*/

public final class ClsMensajeNotificacionDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value = null;

  public ClsMensajeNotificacionDTOHolder ()
  {
  }

  public ClsMensajeNotificacionDTOHolder (servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorDeNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.type ();
  }

}
