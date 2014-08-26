/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.softlayer.features;

import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.softlayer.domain.VirtualGuestBlockDeviceTemplateGroup;

/**
 * Provides access to VirtualGuestBlockDeviceTemplateGroup via their REST API.
 * <p/>
 *
 * @see <a href="http://sldn.softlayer.com/reference/services/SoftLayer_Virtual_Guest_Block_Device_Template_Group" />
 */
@RequestFilters(BasicAuthentication.class)
@Path("/v{jclouds.api-version}")
@Consumes(MediaType.APPLICATION_JSON)
public interface VirtualGuestBlockDeviceTemplateGroupApi {

   String LIST_PUBLIC_IMAGES_MASK = "children.blockDevices.diskImage.softwareReferences.softwareDescription";

   /**
    * @return public images
    * @see <a href="http://sldn.softlayer.com/reference/services/SoftLayer_Virtual_Guest_Block_Device_Template_Group/getPublicImages" />
    */
   @Named("VirtualGuestBlockDeviceTemplateGroup:getPublicImages")
   @GET
   @Path("/SoftLayer_Virtual_Guest_Block_Device_Template_Group/getPublicImages")
   @QueryParams(keys = "objectMask", values = LIST_PUBLIC_IMAGES_MASK)
   @Fallback(Fallbacks.EmptySetOnNotFoundOr404.class)
   Set<VirtualGuestBlockDeviceTemplateGroup> getPublicImages();

}
