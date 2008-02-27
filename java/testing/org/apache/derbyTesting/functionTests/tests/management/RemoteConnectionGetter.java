/*

 Derby - Class org.apache.derbyTesting.functionTests.tests.management.RemoteConnectionGetter

 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to you under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
package org.apache.derbyTesting.functionTests.tests.management;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * JMXConnectionGetter using a JMXServiceURL, currently
 * with no authentication and not using SSL.
 *
 */
class RemoteConnectionGetter implements JMXConnectionGetter {

    private final JMXServiceURL url;

    RemoteConnectionGetter(JMXServiceURL url) {
        this.url = url;
    }

    public MBeanServerConnection getMBeanServerConnection() throws Exception {
        // assumes that JMX authentication and SSL is not required (hence null)
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        return jmxc.getMBeanServerConnection();
    }
}
