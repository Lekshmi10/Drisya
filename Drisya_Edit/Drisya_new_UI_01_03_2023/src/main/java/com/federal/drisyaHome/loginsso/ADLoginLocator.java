/**
 * ADLoginLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.federal.drisyaHome.loginsso;

public class ADLoginLocator extends org.apache.axis.client.Service implements com.federal.drisyaHome.loginsso.ADLogin {

    public ADLoginLocator() {
    }


    public ADLoginLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ADLoginLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ADLoginSoap
    private java.lang.String ADLoginSoap_address = "http://10.250.7.184/ADManager/ADlogin.asmx";

    public java.lang.String getADLoginSoapAddress() {
        return ADLoginSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ADLoginSoapWSDDServiceName = "ADLoginSoap";

    public java.lang.String getADLoginSoapWSDDServiceName() {
        return ADLoginSoapWSDDServiceName;
    }

    public void setADLoginSoapWSDDServiceName(java.lang.String name) {
        ADLoginSoapWSDDServiceName = name;
    }

    public com.federal.drisyaHome.loginsso.ADLoginSoap getADLoginSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ADLoginSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getADLoginSoap(endpoint);
    }

    public com.federal.drisyaHome.loginsso.ADLoginSoap getADLoginSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.federal.drisyaHome.loginsso.ADLoginSoapStub _stub = new com.federal.drisyaHome.loginsso.ADLoginSoapStub(portAddress, this);
            _stub.setPortName(getADLoginSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setADLoginSoapEndpointAddress(java.lang.String address) {
        ADLoginSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.federal.drisyaHome.loginsso.ADLoginSoap.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.federal.drisyaHome.loginsso.ADLoginSoapStub _stub = new com.federal.drisyaHome.loginsso.ADLoginSoapStub(new java.net.URL(ADLoginSoap_address), this);
                _stub.setPortName(getADLoginSoapWSDDServiceName());
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
        if ("ADLoginSoap".equals(inputPortName)) {
            return getADLoginSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ADLogin");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ADLoginSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ADLoginSoap".equals(portName)) {
            setADLoginSoapEndpointAddress(address);
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
