package s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage;

/**
* s_seguimiento_usuarios/sop_corba/GestionNotificacionesPackage/NotificacionDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from s_seguimiento_usuarios.idl
* martes 15 de febrero de 2022 10:52:26 AM COT
*/

public final class NotificacionDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTO value = null;

  public NotificacionDTOHolder ()
  {
  }

  public NotificacionDTOHolder (s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return s_seguimiento_usuarios.sop_corba.GestionNotificacionesPackage.NotificacionDTOHelper.type ();
  }

}
