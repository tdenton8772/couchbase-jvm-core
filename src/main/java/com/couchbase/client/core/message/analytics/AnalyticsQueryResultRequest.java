/*
 * Copyright (c) 2018 Couchbase, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.couchbase.client.core.message.analytics;

import com.couchbase.client.core.annotations.InterfaceStability;
import com.couchbase.client.core.message.AbstractCouchbaseRequest;
import com.couchbase.client.core.message.PrelocatedRequest;

import java.net.InetAddress;

/**
 * Deferred analytics query result request
 */
@InterfaceStability.Experimental
public class AnalyticsQueryResultRequest extends AbstractCouchbaseRequest implements AnalyticsRequest, PrelocatedRequest {

    private final String target;
    private final String resultPath;

    public AnalyticsQueryResultRequest(String uri, String bucket, String username, String password) {
        this(uri, bucket, username, password, null);
    }

    public AnalyticsQueryResultRequest(String uri, String bucket, String username, String password, String target) {
        super(bucket, username, password);
        String requestIdentifier = uri.substring(uri.lastIndexOf('/') + 1);
        this.resultPath = "/analytics/service/result/" + requestIdentifier;
        this.target = target;
    }

    @Override
    public String path() {
        return resultPath;
    }

    @Override
    public String sendTo() {
        return target;
    }
}