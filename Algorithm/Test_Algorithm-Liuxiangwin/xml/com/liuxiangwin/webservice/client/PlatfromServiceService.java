
package com.liuxiangwin.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "PlatfromServiceService", targetNamespace = "http://service.webservice.liuxiangwin.com/", wsdlLocation = "http://localhost:8999/liuxiangwin?wsdl")
public class PlatfromServiceService
    extends Service
{

    private final static URL PLATFROMSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.liuxiangwin.webservice.client.PlatfromServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.liuxiangwin.webservice.client.PlatfromServiceService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8999/liuxiangwin?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8999/liuxiangwin?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        PLATFROMSERVICESERVICE_WSDL_LOCATION = url;
    }

    public PlatfromServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PlatfromServiceService() {
        super(PLATFROMSERVICESERVICE_WSDL_LOCATION, new QName("http://service.webservice.liuxiangwin.com/", "PlatfromServiceService"));
    }

    /**
     * 
     * @return
     *     returns IService
     */
    @WebEndpoint(name = "PlatfromServicePort")
    public IService getPlatfromServicePort() {
        return super.getPort(new QName("http://service.webservice.liuxiangwin.com/", "PlatfromServicePort"), IService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IService
     */
    @WebEndpoint(name = "PlatfromServicePort")
    public IService getPlatfromServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.webservice.liuxiangwin.com/", "PlatfromServicePort"), IService.class, features);
    }

}