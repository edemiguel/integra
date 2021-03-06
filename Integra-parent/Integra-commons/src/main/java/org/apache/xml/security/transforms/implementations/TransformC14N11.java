/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;

import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.Transforms;

/**
 * Implements the <CODE>http://www.w3.org/2006/12/xml-c14n11</CODE>
 * (C14N 1.1) transform.
 *
 * @author Sean Mullan
 */
public class TransformC14N11 extends TransformSpi {

    protected String engineGetURI() {
        return Transforms.TRANSFORM_C14N11_OMIT_COMMENTS;
    }

    protected XMLSignatureInput enginePerformTransform(
        XMLSignatureInput input, OutputStream os, Transform transform	
    ) throws CanonicalizationException {   
        Canonicalizer11_OmitComments c14n = new Canonicalizer11_OmitComments();
        if (os != null) {
            c14n.setWriter(os);
        }
        byte[] result = null;                
        result = c14n.engineCanonicalize(input);         		         	         
        XMLSignatureInput output = new XMLSignatureInput(result);
        if (os != null) {
            output.setOutputStream(os);
        }
        return output;     
    }
}
