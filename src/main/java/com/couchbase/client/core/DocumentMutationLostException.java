/*
 * Copyright (c) 2016 Couchbase, Inc.
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
package com.couchbase.client.core;

/**
 * The observed document was lost during a hard failover, because the document did not reach the replica in time.
 *
 * @author Michael Nitschinger
 * @since 1.2.0
 */
public class DocumentMutationLostException
    extends CouchbaseException
    implements OriginalMutationResult {

    private final Long cas;

    public DocumentMutationLostException(final String message, final Long cas) {
        super(message);
        this.cas = cas;
    }

    @Override
    public long mutationCas() {
        if (cas == null) {
            throw new IllegalStateException("Mutation CAS not available");
        }
        return cas;
    }
}
