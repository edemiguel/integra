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
 * <b>File:</b><p>es.gob.afirma.tsl.exceptions.TSLValidationException.java.</p>
 * <b>Description:</b><p>Class that manages the validation exceptions of the Integra-TSL module.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * <b>Date:</b><p> 16/11/2020.</p>
 * @author Gobierno de España.
 * @version 1.0, 16/11/2020.
 */
package es.gob.afirma.tsl.exceptions;


/** 
 * <p>Class that manages the validation exceptions of the Integra-TSL module.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * @version 1.0, 16/11/2020.
 */
public class TSLValidationException extends TSLException {

    /**
     * Constant attribute that represents the serial version UID.
     */
    private static final long serialVersionUID = -2308024307268001447L;

    /**
     * Constructor method for the class TSLValidationException.java. 
     */
    public TSLValidationException() {
    }

    /**
     * Constructor method for the class TSLValidationException.java.
     * @param message
     * @param cause 
     */
    public TSLValidationException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructor method for the class TSLValidationException.java.
     * @param message 
     */
    public TSLValidationException(String message) {
	super(message);
    }

    /**
     * Constructor method for the class TSLValidationException.java.
     * @param cause 
     */
    public TSLValidationException(Throwable cause) {
	super(cause);
    }

}
