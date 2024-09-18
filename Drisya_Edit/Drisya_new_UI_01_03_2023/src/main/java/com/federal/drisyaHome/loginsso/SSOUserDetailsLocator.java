/**
 * SSOUserDetailsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.federal.drisyaHome.loginsso;

public class SSOUserDetailsLocator extends org.apache.axis.client.Service implements com.federal.drisyaHome.loginsso.SSOUserDetails {

    public SSOUserDetailsLocator() {
    }


    public SSOUserDetailsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SSOUserDetailsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SSOUserDetailsSoap
    private java.lang.String SSOUserDetailsSoap_address = "http://10.250.7.210/SSO/SSOUserDetails.asmx";

    public java.lang.String getSSOUserDetailsSoapAddress() {
        return SSOUserDetailsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SSOUserDetailsSoapWSDDServiceName = "SSOUserDetailsSoap";

    public java.lang.String getSSOUserDetailsSoapWSDDServiceName() {
        return SSOUserDetailsSoapWSDDServiceName;
    }

    public void setSSOUserDetailsSoapWSDDServiceName(java.lang.String name) {
        SSOUserDetailsSoapWSDDServiceName = name;
    }

    public com.federal.drisyaHome.loginsso.SSOUserDetailsSoap getSSOUserDetailsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SSOUserDetailsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSSOUserDetailsSoap(endpoint);
    }

    public com.federal.drisyaHome.loginsso.SSOUserDetailsSoap getSSOUserDetailsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.federal.drisyaHome.loginsso.SSOUserDetailsSoapStub _stub = new com.federal.drisyaHome.loginsso.SSOUserDetailsSoapStub(portAddress, this);
            _stub.setPortName(getSSOUserDetailsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSSOUserDetailsSoapEndpointAddress(java.lang.String address) {
        SSOUserDetailsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.federal.drisyaHome.loginsso.SSOUserDetailsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.federal.drisyaHome.loginsso.SSOUserDetailsSoapStub _stub = new com.federal.drisyaHome.loginsso.SSOUserDetailsSoapStub(new java.net.URL(SSOUserDetailsSoap_address), this);
                _stub.setPortName(getSSOUserDetailsSoapWSDDServiceName());
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
        if ("SSOUserDetailsSoap".equals(inputPortName)) {
            return getSSOUserDetailsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SSOUserDetails");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "SSOUserDetailsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SSOUserDetailsSoap".equals(portName)) {
            setSSOUserDetailsSoapEndpointAddress(address);
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
