/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package org.restcomm.connect.http;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.restcomm.connect.commons.annotations.concurrency.ThreadSafe;

/**
 * @author maria-farooq@live.com (Maria Farooq)
 */
@Path("/Accounts/{accountSid}/Conferences/{conferenceSid}/Participants")
@ThreadSafe
public final class ParticipantsXmlEndpoint extends ParticipantsEndpoint {
    public ParticipantsXmlEndpoint() {
        super();
    }

    @Path("/{callSid}")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getParticipantAsXml(@PathParam("accountSid") final String accountSid, @PathParam("conferenceSid") final String conferenceSid, @PathParam("callSid") final String callSid) {
        return getCall(accountSid, callSid, retrieveMediaType());
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getParticipants(@PathParam("accountSid") final String accountSid, @PathParam("conferenceSid") final String conferenceSid, @Context UriInfo info) {
        return getCalls(accountSid, conferenceSid, info, retrieveMediaType());
    }

    @Path("/{callSid}")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response modifyCall(@PathParam("accountSid") final String accountSid, @PathParam("conferenceSid") final String conferenceSid, @PathParam("callSid") final String callSid,
            final MultivaluedMap<String, String> data) {
        return updateCall(accountSid, callSid, data, retrieveMediaType());
    }

}