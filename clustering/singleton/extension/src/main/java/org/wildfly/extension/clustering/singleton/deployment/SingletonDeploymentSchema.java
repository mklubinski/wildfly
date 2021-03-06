/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.wildfly.extension.clustering.singleton.deployment;

import javax.xml.namespace.QName;

import org.jboss.as.clustering.controller.Schema;

/**
 * Enumerates the singleton deployment configuration schemas.
 * @author Paul Ferraro
 */
public enum SingletonDeploymentSchema implements Schema<SingletonDeploymentSchema> {

    VERSION_1_0("singleton-deployment", 1, 0),
    ;
    public static final SingletonDeploymentSchema CURRENT = VERSION_1_0;
    private static final String NAMESPACE_URI_PATTERN = "urn:jboss:%s:%d.%d";

    private final String root;
    private final int major;
    private final int minor;

    SingletonDeploymentSchema(String root, int major, int minor) {
        this.root = root;
        this.major = major;
        this.minor = minor;
    }

    @Override
    public int major() {
        return this.major;
    }

    @Override
    public int minor() {
        return this.minor;
    }

    @Override
    public String getNamespaceUri() {
        return String.format(NAMESPACE_URI_PATTERN, this.root, this.major, this.minor);
    }

    public QName getRoot() {
        return new QName(this.getNamespaceUri(), this.root);
    }
}
