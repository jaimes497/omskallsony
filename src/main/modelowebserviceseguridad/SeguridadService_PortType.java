/**
 * SeguridadService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package modelowebserviceseguridad;

public interface SeguridadService_PortType extends java.rmi.Remote {
    public java.lang.String autenticacionAutorizacionLdap(java.lang.String usuario, java.lang.String clave) throws java.rmi.RemoteException;
    public modelowebserviceseguridad.Menu[] listadoMenusPerfil(java.lang.String perfil) throws java.rmi.RemoteException;
}
