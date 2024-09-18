/**
 * BPMWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.federal.drisyaHome.loginsso;

public class BPMWebServiceLocator extends org.apache.axis.client.Service implements com.federal.drisyaHome.loginsso.BPMWebService {

    public BPMWebServiceLocator() {
    }


    public BPMWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BPMWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BPMWebServiceSoap
    private java.lang.String BPMWebServiceSoap_address = "http://10.250.7.184/ADManager/BPMWebService.asmx";

    public java.lang.String getBPMWebServiceSoapAddress() {
        return BPMWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BPMWebServiceSoapWSDDServiceName = "BPMWebServiceSoap";

    public java.lang.String getBPMWebServiceSoapWSDDServiceName() {
        return BPMWebServiceSoapWSDDServiceName;
    }

    public void setBPMWebServiceSoapWSDDServiceName(java.lang.String name) {
        BPMWebServiceSoapWSDDServiceName = name;
    }

    public com.federal.drisyaHome.loginsso.BPMWebServiceSoap getBPMWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BPMWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBPMWebServiceSoap(endpoint);
    }

    public com.federal.drisyaHome.loginsso.BPMWebServiceSoap getBPMWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.federal.drisyaHome.loginsso.BPMWebServiceSoapStub _stub = new com.federal.drisyaHome.loginsso.BPMWebServiceSoapStub(portAddress, this);
            _stub.setPortName(getBPMWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBPMWebServiceSoapEndpointAddress(java.lang.String address) {
        BPMWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.federal.drisyaHome.loginsso.BPMWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.federal.drisyaHome.loginsso.BPMWebServiceSoapStub _stub = new com.federal.drisyaHome.loginsso.BPMWebServiceSoapStub(new java.net.URL(BPMWebServiceSoap_address), this);
                _stub.setPortName(getBPMWebServiceSoapWSDDServiceName());
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
        if ("BPMWebServiceSoap".equals(inputPortName)) {
            return getBPMWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "BPMWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BPMWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BPMWebServiceSoap".equals(portName)) {
            setBPMWebServiceSoapEndpointAddress(address);
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
