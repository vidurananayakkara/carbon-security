/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.carbon.security.caas.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.security.caas.api.model.User;

import java.security.Principal;
import java.util.Objects;

/**
 * This class {@code CarbonPrincipal} is the principal representation of the carbon platform.
 * This is an implementation of {@code Principal}.
 *
 * @since 1.0.0
 */
public class CarbonPrincipal implements Principal {

    private static final Logger log = LoggerFactory.getLogger(CarbonPrincipal.class);

    private User user;

    public CarbonPrincipal() {

    }

    public CarbonPrincipal(User user) {
        this.setUser(user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String getName() {
        return getUser().getUsername();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    /**
     * Checks whether the current principal has a given {@code CarbonPermission}.
     *
     * @param carbonPermission CarbonPermission which needs to be checked with principal instance.
     * @return true if authorized.
     */
    public boolean isAuthorized(CarbonPermission carbonPermission) {

        return getUser().isUserAuthorized(carbonPermission);

    }
}
