package modelowebserviceseguridad;

public class SeguridadServiceProxy implements modelowebserviceseguridad.SeguridadService_PortType {
  private String _endpoint = null;
  private modelowebserviceseguridad.SeguridadService_PortType seguridadService_PortType = null;
  
  public SeguridadServiceProxy() {
    _initSeguridadServiceProxy();
  }
  
  public SeguridadServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSeguridadServiceProxy();
  }
  
  private void _initSeguridadServiceProxy() {
    try {
      seguridadService_PortType = (new modelowebserviceseguridad.SeguridadService_ServiceLocator()).getseguridadServicePort();
      if (seguridadService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)seguridadService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)seguridadService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (seguridadService_PortType != null)
      ((javax.xml.rpc.Stub)seguridadService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public modelowebserviceseguridad.SeguridadService_PortType getSeguridadService_PortType() {
    if (seguridadService_PortType == null)
      _initSeguridadServiceProxy();
    return seguridadService_PortType;
  }
  
  public java.lang.String autenticacionAutorizacionLdap(java.lang.String usuario, java.lang.String clave) throws java.rmi.RemoteException{
    if (seguridadService_PortType == null)
      _initSeguridadServiceProxy();
    return seguridadService_PortType.autenticacionAutorizacionLdap(usuario, clave);
  }
  
  public modelowebserviceseguridad.Menu[] listadoMenusPerfil(java.lang.String perfil) throws java.rmi.RemoteException{
    if (seguridadService_PortType == null)
      _initSeguridadServiceProxy();
    return seguridadService_PortType.listadoMenusPerfil(perfil);
  }
  
  
}