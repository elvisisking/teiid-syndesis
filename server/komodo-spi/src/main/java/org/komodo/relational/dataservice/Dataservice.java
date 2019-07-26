/*
 * Copyright Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags and
 * the COPYRIGHT.txt file distributed with this work.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.komodo.relational.dataservice;

import org.komodo.relational.Named;
import org.komodo.spi.KException;
import org.komodo.spi.StringConstants;

/**
 * A model of a dataservice instance
 */
public interface Dataservice extends Named {
	
	static String getServiceVdbName(String name) {
		return name.toLowerCase() + StringConstants.SERVICE_VDB_SUFFIX;
	}

    /**
     * @return the service VDB name (may be <code>null</code> if not defined)
     * @throws KException
     *         if an error occurs
     */
    default String getServiceVdbName( ) throws KException {
    	return getServiceVdbName(getName());
    }

    /**
     * @return the value of the <code>description</code> property (can be empty)
     * @throws KException
     *         if an error occurs
     */
    String getDescription( );

    /**
     * @param newDescription
     *        the new value of the <code>description</code> property
     * @throws KException
     *         if an error occurs
     */
    void setDescription( 
                         final String newDescription );
    
}
