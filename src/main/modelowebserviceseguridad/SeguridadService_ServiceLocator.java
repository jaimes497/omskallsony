/**
 * SeguridadService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package modelowebserviceseguridad;

public class SeguridadService_ServiceLocator extends org.apache.axis.client.Service implements modelowebserviceseguridad.SeguridadService_Service {

    public SeguridadService_ServiceLocator() {
    }


    public SeguridadService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SeguridadService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for seguridadServicePort
    private java.lang.String seguridadServicePort_address = "http://192.168.1.30:8089/componentservice-war/seguridadService";

    public java.lang.String getseguridadServicePortAddress() {
        return seguridadServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String seguridadServicePortWSDDServiceName = "seguridadServicePort";

    public java.lang.String getseguridadServicePortWSDDServiceName() {
        return seguridadServicePortWSDDServiceName;
    }

    public void setseguridadServicePortWSDDServiceName(java.lang.String name) {
        seguridadServicePortWSDDServiceName = name;
    }

    public modelowebserviceseguridad.SeguridadService_PortType getseguridadServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(seguridadServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getseguridadServicePort(endpoint);
    }

    public modelowebserviceseguridad.SeguridadService_PortType getseguridadServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            modelowebserviceseguridad.SeguridadServiceBindingStub _stub = new modelowebserviceseguridad.SeguridadServiceBindingStub(portAddress, this);
            _stub.setPortName(getseguridadServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setseguridadServicePortEndpointAddress(java.lang.String address) {
        seguridadServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (modelowebserviceseguridad.SeguridadService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                modelowebserviceseguridad.SeguridadServiceBindingStub _stub = new modelowebserviceseguridad.SeguridadServiceBindingStub(new java.net.URL(seguridadServicePort_address), this);
                _stub.setPortName(getseguridadServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("seguridadServicePort".equals(inputPortName)) {
            return getseguridadServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://modelowebserviceseguridad", "seguridadService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://modelowebserviceseguridad", "seguridadServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("seguridadServicePort".equals(portName)) {
            setseguridadServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
