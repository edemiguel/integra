// Copyright (C) 2012-15 MINHAP, Gobierno de España
// This program is licensed and may be used, modified and redistributed under the terms
// of the European Public License (EUPL), either version 1.1 or (at your
// option) any later version as soon as they are approved by the European Commission.
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing permissions and
// more details.
// You should have received a copy of the EUPL1.1 license
// along with this program; if not, you may find it at
// http://joinup.ec.europa.eu/software/page/eupl/licence-eupl

/** 
 * <b>File:</b><p>es.gob.afirma.integraws.beans.RequestValidateOCSP.java.</p>
 * <b>Description:</b><p> Class that represents the request object for VALIDATEOCSP service.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * <b>Date:</b><p>12/5/2016.</p>
 * @author Gobierno de España.
 * @version 1.0, 12/5/2016.
 */
package es.gob.afirma.integraws.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * <p>Class that represents the request object for VALIDATEOCSP service.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * @version 1.0, 12/5/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestValidateOCSP {

    /**
     * Attribute that represents id of WS client. 
     */
    private String idClient;
    
    /**
     * Attribute that represents the certificate to validate. 
     */
    private byte[] certificate;
    
    /**
     * Constructor method for the class RequestValidateOCSP.java. 
     */
    public RequestValidateOCSP() {
    }


    /**
     * Gets the value of the attribute {@link #idClient}.
     * @return the value of the attribute {@link #idClient}.
     */
    @XmlElement(required = true, defaultValue = "null")
    public final String getIdClient() {
        return idClient;
    }

    /**
     * Sets the value of the attribute {@link #idClient}.
     * @param idClientParam The value for the attribute {@link #idClient}.
     */
    public final void setIdClient(String idClientParam) {
        this.idClient = idClientParam;
    }

    /**
     * Gets the value of the attribute {@link #certificate}.
     * @return the value of the attribute {@link #certificate}.
     */
    @XmlElement(required = true, defaultValue = "null")
    public final byte[] getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the attribute {@link #certificate}.
     * @param certificateParam The value for the attribute {@link #certificate}.
     */
    public final void setCertificate(byte[] certificateParam) {
        this.certificate = certificateParam;
    }
    
    
}
