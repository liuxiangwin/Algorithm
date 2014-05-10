
package com.liuxiangwin.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for meter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="meter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adjustTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="machineId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meter", propOrder = {
    "adjustTime",
    "machineId",
    "meterName"
})
public class Meter {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar adjustTime;
    protected String machineId;
    protected String meterName;

    /**
     * Gets the value of the adjustTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAdjustTime() {
        return adjustTime;
    }

    /**
     * Sets the value of the adjustTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAdjustTime(XMLGregorianCalendar value) {
        this.adjustTime = value;
    }

    /**
     * Gets the value of the machineId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachineId() {
        return machineId;
    }

    /**
     * Sets the value of the machineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachineId(String value) {
        this.machineId = value;
    }

    /**
     * Gets the value of the meterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterName() {
        return meterName;
    }

    /**
     * Sets the value of the meterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterName(String value) {
        this.meterName = value;
    }

}
