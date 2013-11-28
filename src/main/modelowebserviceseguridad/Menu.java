/**
 * Menu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package modelowebserviceseguridad;

public class Menu  implements java.io.Serializable {
    private int id;

    private java.lang.String display;

    private java.lang.String action;

    private java.lang.String status;

    private java.lang.String descripcion;

    private int orden;

    private modelowebserviceseguridad.Menu[] listadoMenus;

    public Menu() {
    }

    public Menu(
           int id,
           java.lang.String display,
           java.lang.String action,
           java.lang.String status,
           java.lang.String descripcion,
           int orden,
           modelowebserviceseguridad.Menu[] listadoMenus) {
           this.id = id;
           this.display = display;
           this.action = action;
           this.status = status;
           this.descripcion = descripcion;
           this.orden = orden;
           this.listadoMenus = listadoMenus;
    }


    /**
     * Gets the id value for this Menu.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Menu.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the display value for this Menu.
     * 
     * @return display
     */
    public java.lang.String getDisplay() {
        return display;
    }


    /**
     * Sets the display value for this Menu.
     * 
     * @param display
     */
    public void setDisplay(java.lang.String display) {
        this.display = display;
    }


    /**
     * Gets the action value for this Menu.
     * 
     * @return action
     */
    public java.lang.String getAction() {
        return action;
    }


    /**
     * Sets the action value for this Menu.
     * 
     * @param action
     */
    public void setAction(java.lang.String action) {
        this.action = action;
    }


    /**
     * Gets the status value for this Menu.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Menu.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the descripcion value for this Menu.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Menu.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the orden value for this Menu.
     * 
     * @return orden
     */
    public int getOrden() {
        return orden;
    }


    /**
     * Sets the orden value for this Menu.
     * 
     * @param orden
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }


    /**
     * Gets the listadoMenus value for this Menu.
     * 
     * @return listadoMenus
     */
    public modelowebserviceseguridad.Menu[] getListadoMenus() {
        return listadoMenus;
    }


    /**
     * Sets the listadoMenus value for this Menu.
     * 
     * @param listadoMenus
     */
    public void setListadoMenus(modelowebserviceseguridad.Menu[] listadoMenus) {
        this.listadoMenus = listadoMenus;
    }

    public modelowebserviceseguridad.Menu getListadoMenus(int i) {
        return this.listadoMenus[i];
    }

    public void setListadoMenus(int i, modelowebserviceseguridad.Menu _value) {
        this.listadoMenus[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Menu)) return false;
        Menu other = (Menu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.display==null && other.getDisplay()==null) || 
             (this.display!=null &&
              this.display.equals(other.getDisplay()))) &&
            ((this.action==null && other.getAction()==null) || 
             (this.action!=null &&
              this.action.equals(other.getAction()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.orden == other.getOrden() &&
            ((this.listadoMenus==null && other.getListadoMenus()==null) || 
             (this.listadoMenus!=null &&
              java.util.Arrays.equals(this.listadoMenus, other.getListadoMenus())));
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
        _hashCode += getId();
        if (getDisplay() != null) {
            _hashCode += getDisplay().hashCode();
        }
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getOrden();
        if (getListadoMenus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListadoMenus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListadoMenus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Menu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://modelowebserviceseguridad", "menu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("display");
        elemField.setXmlName(new javax.xml.namespace.QName("", "display"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("action");
        elemField.setXmlName(new javax.xml.namespace.QName("", "action"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orden");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listadoMenus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listadoMenus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://modelowebserviceseguridad", "menu"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
