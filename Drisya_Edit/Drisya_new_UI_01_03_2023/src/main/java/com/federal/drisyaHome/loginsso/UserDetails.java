/**
 * UserDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.federal.drisyaHome.loginsso;

public class UserDetails  implements java.io.Serializable {
    private java.lang.String regionalOffice;

    private java.lang.String departmentNumber;

    private java.lang.String displayName;

    private java.lang.String officeType;

    private java.lang.String designation;

    private java.lang.String employeeNumber;

    private java.lang.String grade;

    private java.lang.String isManager;

    private java.lang.String iesRoles;

    private java.lang.String adRoles;

    private java.lang.String validUser;

    public UserDetails() {
    }

    public UserDetails(
           java.lang.String regionalOffice,
           java.lang.String departmentNumber,
           java.lang.String displayName,
           java.lang.String officeType,
           java.lang.String designation,
           java.lang.String employeeNumber,
           java.lang.String grade,
           java.lang.String isManager,
           java.lang.String iesRoles,
           java.lang.String adRoles,
           java.lang.String validUser) {
           this.regionalOffice = regionalOffice;
           this.departmentNumber = departmentNumber;
           this.displayName = displayName;
           this.officeType = officeType;
           this.designation = designation;
           this.employeeNumber = employeeNumber;
           this.grade = grade;
           this.isManager = isManager;
           this.iesRoles = iesRoles;
           this.adRoles = adRoles;
           this.validUser = validUser;
    }


    /**
     * Gets the regionalOffice value for this UserDetails.
     * 
     * @return regionalOffice
     */
    public java.lang.String getRegionalOffice() {
        return regionalOffice;
    }


    /**
     * Sets the regionalOffice value for this UserDetails.
     * 
     * @param regionalOffice
     */
    public void setRegionalOffice(java.lang.String regionalOffice) {
        this.regionalOffice = regionalOffice;
    }


    /**
     * Gets the departmentNumber value for this UserDetails.
     * 
     * @return departmentNumber
     */
    public java.lang.String getDepartmentNumber() {
        return departmentNumber;
    }


    /**
     * Sets the departmentNumber value for this UserDetails.
     * 
     * @param departmentNumber
     */
    public void setDepartmentNumber(java.lang.String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }


    /**
     * Gets the displayName value for this UserDetails.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this UserDetails.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the officeType value for this UserDetails.
     * 
     * @return officeType
     */
    public java.lang.String getOfficeType() {
        return officeType;
    }


    /**
     * Sets the officeType value for this UserDetails.
     * 
     * @param officeType
     */
    public void setOfficeType(java.lang.String officeType) {
        this.officeType = officeType;
    }


    /**
     * Gets the designation value for this UserDetails.
     * 
     * @return designation
     */
    public java.lang.String getDesignation() {
        return designation;
    }


    /**
     * Sets the designation value for this UserDetails.
     * 
     * @param designation
     */
    public void setDesignation(java.lang.String designation) {
        this.designation = designation;
    }


    /**
     * Gets the employeeNumber value for this UserDetails.
     * 
     * @return employeeNumber
     */
    public java.lang.String getEmployeeNumber() {
        return employeeNumber;
    }


    /**
     * Sets the employeeNumber value for this UserDetails.
     * 
     * @param employeeNumber
     */
    public void setEmployeeNumber(java.lang.String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }


    /**
     * Gets the grade value for this UserDetails.
     * 
     * @return grade
     */
    public java.lang.String getGrade() {
        return grade;
    }


    /**
     * Sets the grade value for this UserDetails.
     * 
     * @param grade
     */
    public void setGrade(java.lang.String grade) {
        this.grade = grade;
    }


    /**
     * Gets the isManager value for this UserDetails.
     * 
     * @return isManager
     */
    public java.lang.String getIsManager() {
        return isManager;
    }


    /**
     * Sets the isManager value for this UserDetails.
     * 
     * @param isManager
     */
    public void setIsManager(java.lang.String isManager) {
        this.isManager = isManager;
    }


    /**
     * Gets the iesRoles value for this UserDetails.
     * 
     * @return iesRoles
     */
    public java.lang.String getIesRoles() {
        return iesRoles;
    }


    /**
     * Sets the iesRoles value for this UserDetails.
     * 
     * @param iesRoles
     */
    public void setIesRoles(java.lang.String iesRoles) {
        this.iesRoles = iesRoles;
    }


    /**
     * Gets the adRoles value for this UserDetails.
     * 
     * @return adRoles
     */
    public java.lang.String getAdRoles() {
        return adRoles;
    }


    /**
     * Sets the adRoles value for this UserDetails.
     * 
     * @param adRoles
     */
    public void setAdRoles(java.lang.String adRoles) {
        this.adRoles = adRoles;
    }


    /**
     * Gets the validUser value for this UserDetails.
     * 
     * @return validUser
     */
    public java.lang.String getValidUser() {
        return validUser;
    }


    /**
     * Sets the validUser value for this UserDetails.
     * 
     * @param validUser
     */
    public void setValidUser(java.lang.String validUser) {
        this.validUser = validUser;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserDetails)) return false;
        UserDetails other = (UserDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.regionalOffice==null && other.getRegionalOffice()==null) || 
             (this.regionalOffice!=null &&
              this.regionalOffice.equals(other.getRegionalOffice()))) &&
            ((this.departmentNumber==null && other.getDepartmentNumber()==null) || 
             (this.departmentNumber!=null &&
              this.departmentNumber.equals(other.getDepartmentNumber()))) &&
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.officeType==null && other.getOfficeType()==null) || 
             (this.officeType!=null &&
              this.officeType.equals(other.getOfficeType()))) &&
            ((this.designation==null && other.getDesignation()==null) || 
             (this.designation!=null &&
              this.designation.equals(other.getDesignation()))) &&
            ((this.employeeNumber==null && other.getEmployeeNumber()==null) || 
             (this.employeeNumber!=null &&
              this.employeeNumber.equals(other.getEmployeeNumber()))) &&
            ((this.grade==null && other.getGrade()==null) || 
             (this.grade!=null &&
              this.grade.equals(other.getGrade()))) &&
            ((this.isManager==null && other.getIsManager()==null) || 
             (this.isManager!=null &&
              this.isManager.equals(other.getIsManager()))) &&
            ((this.iesRoles==null && other.getIesRoles()==null) || 
             (this.iesRoles!=null &&
              this.iesRoles.equals(other.getIesRoles()))) &&
            ((this.adRoles==null && other.getAdRoles()==null) || 
             (this.adRoles!=null &&
              this.adRoles.equals(other.getAdRoles()))) &&
            ((this.validUser==null && other.getValidUser()==null) || 
             (this.validUser!=null &&
              this.validUser.equals(other.getValidUser())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRegionalOffice() != null) {
            _hashCode += getRegionalOffice().hashCode();
        }
        if (getDepartmentNumber() != null) {
            _hashCode += getDepartmentNumber().hashCode();
        }
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getOfficeType() != null) {
            _hashCode += getOfficeType().hashCode();
        }
        if (getDesignation() != null) {
            _hashCode += getDesignation().hashCode();
        }
        if (getEmployeeNumber() != null) {
            _hashCode += getEmployeeNumber().hashCode();
        }
        if (getGrade() != null) {
            _hashCode += getGrade().hashCode();
        }
        if (getIsManager() != null) {
            _hashCode += getIsManager().hashCode();
        }
        if (getIesRoles() != null) {
            _hashCode += getIesRoles().hashCode();
        }
        if (getAdRoles() != null) {
            _hashCode += getAdRoles().hashCode();
        }
        if (getValidUser() != null) {
            _hashCode += getValidUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "UserDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionalOffice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "regionalOffice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "departmentNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "displayName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officeType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OfficeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("designation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Designation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "employeeNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Grade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isManager");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "isManager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iesRoles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "iesRoles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adRoles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "adRoles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "validUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
