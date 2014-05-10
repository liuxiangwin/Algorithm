
package com.liuxiangwin.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liuxiangwin.webservice.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EntryResponse_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "entryResponse");
    private final static QName _Entry_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "entry");
    private final static QName _Search_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "search");
    private final static QName _Adjustment_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "adjustment");
    private final static QName _SearchResponse_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "searchResponse");
    private final static QName _AdjustmentResponse_QNAME = new QName("http://service.webservice.liuxiangwin.com/", "adjustmentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liuxiangwin.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Meter }
     * 
     */
    public Meter createMeter() {
        return new Meter();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link EntryResponse }
     * 
     */
    public EntryResponse createEntryResponse() {
        return new EntryResponse();
    }

    /**
     * Create an instance of {@link Entry }
     * 
     */
    public Entry createEntry() {
        return new Entry();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link Adjustment }
     * 
     */
    public Adjustment createAdjustment() {
        return new Adjustment();
    }

    /**
     * Create an instance of {@link AdjustmentResponse }
     * 
     */
    public AdjustmentResponse createAdjustmentResponse() {
        return new AdjustmentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "entryResponse")
    public JAXBElement<EntryResponse> createEntryResponse(EntryResponse value) {
        return new JAXBElement<EntryResponse>(_EntryResponse_QNAME, EntryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "entry")
    public JAXBElement<Entry> createEntry(Entry value) {
        return new JAXBElement<Entry>(_Entry_QNAME, Entry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Adjustment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "adjustment")
    public JAXBElement<Adjustment> createAdjustment(Adjustment value) {
        return new JAXBElement<Adjustment>(_Adjustment_QNAME, Adjustment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdjustmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.liuxiangwin.com/", name = "adjustmentResponse")
    public JAXBElement<AdjustmentResponse> createAdjustmentResponse(AdjustmentResponse value) {
        return new JAXBElement<AdjustmentResponse>(_AdjustmentResponse_QNAME, AdjustmentResponse.class, null, value);
    }

}
