package com.example.helloworld.soap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GreetingResponse", propOrder = {"mensaje", "timestamp"})
@XmlRootElement(name = "GreetingResponse", namespace = "http://example.com/helloworld/soap")
public class GreetingResponse {

    @XmlElement(required = true)
    private String mensaje;

    @XmlElement(required = true)
    private String timestamp;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
