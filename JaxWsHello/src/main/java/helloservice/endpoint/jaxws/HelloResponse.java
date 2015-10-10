
package helloservice.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "HelloResponse", namespace = "http://endpoint.helloservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HelloResponse", namespace = "http://endpoint.helloservice/")
public class HelloResponse {


}
