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
/*
 * Copyright 2005 Sun Microsystems, Inc. All rights reserved.
 */
/*
 * $Id: URIReferenceException.java 1101389 2011-05-10 09:54:48Z coheigea $
 */
package org.apache.xml.crypto;

import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * Indicates an exceptional condition thrown while dereferencing a 
 * {@link URIReference}.
 *
 * <p>A <code>URIReferenceException</code> can contain a cause: another 
 * throwable that caused this <code>URIReferenceException</code> to get thrown. 
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @see URIDereferencer#dereference(URIReference, XMLCryptoContext)
 * @see RetrievalMethod#dereference(XMLCryptoContext)
 */
public class URIReferenceException extends Exception {

    private static final long serialVersionUID = 7173469703932561419L;

    /**
     * The throwable that caused this exception to get thrown, or null if this
     * exception was not caused by another throwable or if the causative
     * throwable is unknown. 
     *
     * @serial
     */
    private Throwable cause;

    private URIReference uriReference;

    /**
     * Constructs a new <code>URIReferenceException</code> with 
     * <code>null</code> as its detail message.
     */
    public URIReferenceException() {
        super();
    }

    /**
     * Constructs a new <code>URIReferenceException</code> with the specified 
     * detail message. 
     *
     * @param message the detail message
     */
    public URIReferenceException(String message) {
        super(message);
    }

    /**
     * Constructs a new <code>URIReferenceException</code> with the 
     * specified detail message and cause.  
     * <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message 
     * @param cause the cause (A <tt>null</tt> value is permitted, and 
     *	      indicates that the cause is nonexistent or unknown.)
     */
    public URIReferenceException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    /**
     * Constructs a new <code>URIReferenceException</code> with the 
     * specified detail message, cause and <code>URIReference</code>.
     * <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message 
     * @param cause the cause (A <tt>null</tt> value is permitted, and 
     *	      indicates that the cause is nonexistent or unknown.)
     * @param uriReference the <code>URIReference</code> that was being
     *    dereferenced when the error was encountered
     * @throws NullPointerException if <code>uriReference</code> is
     *    <code>null</code>
     */
    public URIReferenceException(String message, Throwable cause, 
        URIReference uriReference) {
        this(message, cause);
        if (uriReference == null) {
            throw new NullPointerException("uriReference cannot be null");
        }
        this.uriReference = uriReference;
    }

    /**
     * Constructs a new <code>URIReferenceException</code> with the specified 
     * cause and a detail message of <code>(cause==null ? null : 
     * cause.toString())</code> (which typically contains the class and detail 
     * message of <code>cause</code>).
     *
     * @param cause the cause (A <tt>null</tt> value is permitted, and 
     *        indicates that the cause is nonexistent or unknown.)
     */
    public URIReferenceException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        this.cause = cause;
    }

    /**
     * Returns the <code>URIReference</code> that was being dereferenced
     * when the exception was thrown.
     *
     * @return the <code>URIReference</code> that was being dereferenced
     * when the exception was thrown, or <code>null</code> if not specified
     */
    public URIReference getURIReference() {
        return uriReference;
    }

    /**
     * Returns the cause of this <code>URIReferenceException</code> or 
     * <code>null</code> if the cause is nonexistent or unknown.  (The 
     * cause is the throwable that caused this 
     * <code>URIReferenceException</code> to get thrown.)
     *
     * @return the cause of this <code>URIReferenceException</code> or 
     *    <code>null</code> if the cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Prints this <code>URIReferenceException</code>, its backtrace and
     * the cause's backtrace to the standard error stream.
     */
    public void printStackTrace() {
        super.printStackTrace();
        cause.printStackTrace();
    }

    /**
     * Prints this <code>URIReferenceException</code>, its backtrace and
     * the cause's backtrace to the specified print stream.
     *
     * @param s <code>PrintStream</code> to use for output
     */
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        cause.printStackTrace(s);
    }

    /**
     * Prints this <code>URIReferenceException</code>, its backtrace and
     * the cause's backtrace to the specified print writer.
     *
     * @param s <code>PrintWriter</code> to use for output
     */
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        cause.printStackTrace(s);
    }
}
