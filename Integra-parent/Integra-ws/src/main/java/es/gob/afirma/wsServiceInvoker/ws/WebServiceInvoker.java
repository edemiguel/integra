// Copyright (C) 2012-13 MINHAP, Gobierno de España
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
 * <b>File:</b><p>es.gob.afirma.wsServiceInvoker.ws.WebServiceInvoker.java.</p>
 * <b>Description:</b><p>Class that manages the invoke of @Firma and eVisor web services.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * <b>Date:</b><p>26/12/2014.</p>
 * @author Gobierno de España.
 * @version 1.2, 10/03/2020.
 */
package es.gob.afirma.wsServiceInvoker.ws;

import java.util.List;
import java.util.Properties;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.axis2.engine.Phase;
import org.apache.axis2.phaseresolver.PhaseException;
import org.apache.log4j.Logger;

import es.gob.afirma.i18n.ILogConstantKeys;
import es.gob.afirma.i18n.Language;
import es.gob.afirma.logger.IntegraLogger;
import es.gob.afirma.utils.GenericUtilsCommons;
import es.gob.afirma.utils.UtilsAxis;
import es.gob.afirma.wsServiceInvoker.WSServiceInvokerConstants;
import es.gob.afirma.wsServiceInvoker.WSServiceInvokerException;

/**
 * <p>Class that manages the invoke of @Firma and eVisor web services.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * @version 1.2, 10/03/2020.
 */
public class WebServiceInvoker {

    /**
     * Constant attribute that identifies not secure communication.
     */
    private static final String NO_SECURE_PROTOCOL = "http";

    /**
     * Constant attribute that identifies secure communication.
     */
    private static final String SECURE_PROTOCOL = "https";

    /**
     * Attribute that represents the object that manages the log of the class.
     */
    private static final Logger LOGGER = IntegraLogger.getInstance().getLogger(WebServiceInvoker.class);

    /**
     * Constant attribute that identifier the security Axis2 phase. 
     */
    private static final String PHASE_NAME_SECURITY = "Security";

    /**
     * Attribute that represents the properties defined on the configuration file.
     */
    private Properties properties;

    /**
     * Constructor method for the class WebServiceInvoker.java.
     * @param prop Parameter that represents the properties defined on the configuration file.
     */
    public WebServiceInvoker(Properties prop) {
	this.properties = prop;
    }

    /**
     * Method that performs the invocation to a method form @Firma and eVisor web services.
     * @param methodName Parameter that represents the name of the method to invoke.
     * @param params List of parameters related to the method to invoke.
     * @return the response of the web service.
     * @throws WSServiceInvokerException If the method fails.
     */
    final Object performCall(String methodName, Object[ ] params) throws WSServiceInvokerException {
	String endPointURL, securityOption, secureMode, timeout, afirmaService,
		protocol, endPoint, servicePath;
	Object res = null;
	ClientHandler requestHandler;
	ResponseHandler responseHandler;

	try {
	    // Recuperamos todas las propiedades necesarias para formar el end
	    // point.
	    afirmaService = this.properties.getProperty(WSServiceInvokerConstants.AFIRMA_SERVICE);
	    secureMode = this.properties.getProperty(WSServiceInvokerConstants.SECURE_MODE_PROPERTY);
	    protocol = NO_SECURE_PROTOCOL;
	    if (secureMode != null && secureMode.equals("true")) {
		protocol = SECURE_PROTOCOL;
	    }
	    endPoint = this.properties.getProperty(WSServiceInvokerConstants.WS_ENDPOINT_PROPERTY);
	    checkSvcInvokerParams(WSServiceInvokerConstants.WS_ENDPOINT_PROPERTY, endPoint);
	    servicePath = this.properties.getProperty(WSServiceInvokerConstants.WS_SRV_PATH_PROPERTY);
	    checkSvcInvokerParams(WSServiceInvokerConstants.WS_SRV_PATH_PROPERTY, servicePath);

	    // Obtenemos el endpoint. Ejemplo:
	    // https://localhost:8080/afirmaws/services/ValidarCertificado.
	    endPointURL = protocol + "://" + endPoint + "/" + servicePath + "/" + afirmaService;

	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG001, new Object[ ] { afirmaService }));
	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG002, new Object[ ] { endPointURL }));

	    LOGGER.debug(Language.getResIntegra(ILogConstantKeys.WSI_LOG003));
	    securityOption = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP);
	    checkSvcInvokerParams(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP, securityOption);
	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG004, new Object[ ] { securityOption }));
	    requestHandler = newRequestHandler(securityOption);
	    responseHandler = newResponseHandler();

	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG007, new Object[ ] { methodName }));

	    timeout = this.properties.getProperty(WSServiceInvokerConstants.WS_CALL_TIMEOUT_PROP);
	    checkSvcInvokerParams(WSServiceInvokerConstants.WS_CALL_TIMEOUT_PROP, timeout);
	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG008, new Object[ ] { timeout }));

	    // Creamos la factoria de objetos XML de AXIS2.
	    OMFactory fac = OMAbstractFactory.getOMFactory();

	    // Creamos el namespace de la petición.
	    OMNamespace ns = fac.createOMNamespace("http://soapinterop.org/", "ns1");
	    // Creamos el elemento XML raíz del SOAP body que indica la
	    // operación a realizar.
	    OMElement operationElem = fac.createOMElement(methodName, ns);
	    // Creamos el elemento XML que contendrá la petición SOAP completa.
	    OMElement inputParamElem = fac.createOMElement("arg0", ns);
	    // Añadimos la petición al parámetro de entrada principal.
	    inputParamElem.setText((String) params[0]);
	    // Incluimos el parámetro a la operación para formar el body del
	    // SOAP
	    // completamente.
	    operationElem.addChild(inputParamElem);

	    // Creamos un objeto Option que albergará la configuración de
	    // conexión al servicio.
	    LOGGER.debug(Language.getResIntegra(ILogConstantKeys.WSI_LOG006));
	    Options options = new Options();
	    options.setTimeOutInMilliSeconds(Integer.valueOf(timeout));
	    options.setTo(new EndpointReference(endPointURL));

	    // Creamos el cliente y le añadimos la configuración anterior.
	    LOGGER.debug(Language.getResIntegra(ILogConstantKeys.WSI_LOG005));
	    ServiceClient client = new ServiceClient();
	    client.setOptions(options);

	    // Añadimos los handler generados al flujo de handlers de Axis2.
	    addHandlers(client, requestHandler, responseHandler);

	    // Realizamos la llamada.
	    LOGGER.debug(Language.getResIntegra(ILogConstantKeys.WSI_LOG009));
	    OMElement result = client.sendReceive(operationElem);
	    if (result != null && result.getFirstElement() != null && !result.getFirstElement().getText().isEmpty()) {
		res = result.getFirstElement().getText();
	    } else {

	    }
	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG011, new Object[ ] { res }));
	} catch (Exception e) {
	    throw new WSServiceInvokerException(e);
	}

	return res;
    }

    /**
     * Auxiliary method that adds the generated handlers to the 'phases' of Axis2.
     * @param client Service client.
     * @param requestHandler Request handler.
     * @param responseHandler Response handler.
     */
    private void addHandlers(ServiceClient client, ClientHandler requestHandler, ResponseHandler responseHandler) {

	// Añadimos el handler de seguridad de salida.
	AxisConfiguration config = client.getAxisConfiguration();
	List<Phase> phasesOut = config.getOutFlowPhases();
	for (Phase phase: phasesOut) {
	    if (PHASE_NAME_SECURITY.equals(phase.getPhaseName())) {
		try {
		    if (!UtilsAxis.isHandlerInPhase(phase, requestHandler)) {
			phase.setPhaseLast(requestHandler);
		    }
		    break;
		} catch (PhaseException e) {
		    e.printStackTrace();
		}
	    }
	}

	// Añadimos el handler de seguridad de entrada.
	if (responseHandler != null) {
	    List<Phase> phasesIn = config.getInFlowPhases();
	    for (Phase phase: phasesIn) {
		if (PHASE_NAME_SECURITY.equals(phase.getPhaseName())) {
		    try {
			if (!UtilsAxis.isHandlerInPhase(phase, requestHandler)) {
			    phase.setPhaseLast(responseHandler);
			}
			break;
		    } catch (PhaseException e) {
			e.printStackTrace();
		    }
		}
	    }
	}
    }

    /**
     * Method that verifies if a value is not empty and not null.
     * @param parameterName Parameter that represents the name of the element to check.
     * @param parameterValue Parameter that represents the value to check.
     * @throws WSServiceInvokerException If the value is empty or null.
     */
    private void checkSvcInvokerParams(String parameterName, String parameterValue) throws WSServiceInvokerException {
	if (!GenericUtilsCommons.assertStringValue(parameterValue)) {
	    throw new WSServiceInvokerException(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG012, new Object[ ] { parameterName, properties.getProperty(WSServiceInvokerConstants.APPLICATION_NAME) }));
	}
    }

    /**
     * Method that creates a new instance of {@link ClientHandler}.
     * @param securityOption Parameter that represents the security options.
     * @return the created instance of {@link ClientHandler}.
     * @throws WSServiceInvokerException If the method fails.
     */
    private ClientHandler newRequestHandler(String securityOption) throws WSServiceInvokerException {
	String autUser, autPassword, autPassType, keystorePath, keystorePass,
		keystoreType;
	autUser = "";
	autPassword = "";
	autPassType = "";
	keystorePath = "";
	keystorePass = "";
	keystoreType = "";
	String securityOpt = securityOption;
	if (securityOpt != null) {
	    if (!securityOpt.equals(ClientHandler.NONEOPTION)) {
		autUser = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZ_METHOD_USER_PROP);
		autPassword = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PASS_PROP);
		LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG013, new Object[ ] { autUser }));
		if (securityOpt.equals(ClientHandler.USERNAMEOPTION)) {
		    autPassType = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PASS_TYPE_PROP);
		    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG014, new Object[ ] { autPassType }));
		} else if (securityOpt.equals(ClientHandler.CERTIFICATEOPTION)) {
		    keystorePath = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_PROP);
		    keystorePass = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_PASS_PROP);
		    keystoreType = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_TYPE_PROP);
		    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG015, new Object[ ] { keystorePath, keystoreType }));
		}
	    }
	} else {
	    securityOpt = ClientHandler.NONEOPTION;
	}
	ClientHandler sender = new ClientHandler(securityOpt);
	sender.setUserAlias(autUser);
	sender.setPassword(autPassword);
	// Este parámetro solo tiene sentido si la autorizacion se realiza
	// mediante el tag de seguridad UserNameToken
	sender.setPasswordType(autPassType);
	// Propiedades para binarySecurityToken
	sender.setUserKeystore(keystorePath);
	sender.setUserKeystorePass(keystorePass);
	sender.setUserKeystoreType(keystoreType);
	return sender;
    }

    /**
     * Method that creates a new instance of {@link ResponseHandler}.
     * @return the created instance of {@link ResponseHandler}.
     */
    private ResponseHandler newResponseHandler() {
	if (Boolean.valueOf(this.properties.getProperty(WSServiceInvokerConstants.PREFIX_RESPONSE_PROPERTY + "." + WSServiceInvokerConstants.RESPONSE_VALIDATE_PROPERTY))) {
	    String keystorePath = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_PROP);
	    String keystorePass = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_PASS_PROP);
	    String keystoreType = this.properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_USERKEYSTORE_TYPE_PROP);
	    String autUser = this.properties.getProperty(WSServiceInvokerConstants.PREFIX_RESPONSE_PROPERTY + "." + WSServiceInvokerConstants.RESPONSE_ALIAS_CERT_PROPERTY);
	    String autPassword = properties.getProperty(WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PROP + "." + WSServiceInvokerConstants.WS_AUTHORIZATION_METHOD_PASS_PROP);
	    LOGGER.debug(Language.getFormatResIntegra(ILogConstantKeys.WSI_LOG016, new Object[ ] { keystorePath, keystoreType, autUser }));
	    return new ResponseHandler(keystorePath, keystorePass, keystoreType, autUser, autPassword);
	} else {
	    LOGGER.debug(Language.getResIntegra(ILogConstantKeys.WSI_LOG017));
	    return null;
	}
    }

    /**
     * Gets the value of the attribute {@link #properties}.
     * @return the value of the attribute {@link #properties}.
     */
    public final Properties getWSCallerProperties() {
	return this.properties;
    }

    /**
     * Sets the value of the attribute {@link #properties}.
     * @param wsProperties The value for the attribute {@link #properties}.
     */
    public final void setWSCallerProperties(Properties wsProperties) {
	this.properties = wsProperties == null ? new Properties() : wsProperties;
    }

}
