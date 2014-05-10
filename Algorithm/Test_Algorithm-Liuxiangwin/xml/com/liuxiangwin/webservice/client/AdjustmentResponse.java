
package com.liuxiangwin.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for adjustmentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adjustmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adjustResult" type="{http://service.webservice.liuxiangwin.com/}meter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adjustmentResponse", propOrder = {
    "adjustResult"
})
public class AdjustmentResponse {

    protected Meter adjustResult;

    /**
     * Gets the value of the adjustResult property.
     * 
     * @return
     *     possible object is
     *     {@link Meter }
     *     
     */
    public Meter getAdjustResult() {
        return adjustResult;
    }

    /**
     * Sets the value of the adjustResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meter }
     *     
     */
    public void setAdjustResult(Meter value) {
        this.adjustResult = value;
    }

}
