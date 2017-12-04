/*
 * Copyright (c) 2017 Couchbase, Inc.
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

package com.couchbase.client.core.logging;

/**
 * Represents a logging argument which is subject to redaction.
 *
 * @author Michael Nitschinger
 * @since 1.5.3
 */
public class RedactableArgument {

    /**
     * The type of the redactable argument.
     */
    private final ArgumentType type;

    /**
     * The message of the redactable argument.
     */
    private final String message;

    /**
     * Creates a new {@link RedactableArgument}.
     *
     * @param type type of the redactable argument.
     * @param message message of the redactable argument.
     */
    private RedactableArgument(final ArgumentType type, final String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * A redactable argument of user data.
     *
     * @param message the message to redact.
     * @return a new {@link RedactableArgument}.
     */
    public static RedactableArgument user(final String message) {
        return new RedactableArgument(ArgumentType.USER, message);
    }

    /**
     * A redactable argument of meta data.
     *
     * @param message the message to redact.
     * @return a new {@link RedactableArgument}.
     */
    public static RedactableArgument meta(final String message) {
        return new RedactableArgument(ArgumentType.META, message);
    }

    /**
     * A redactable argument of system data.
     *
     * @param message the message to redact.
     * @return a new {@link RedactableArgument}.
     */
    public static RedactableArgument system(final String message) {
        return new RedactableArgument(ArgumentType.SYSTEM, message);
    }

    /**
     * The type of this redactable argument.
     */
    public ArgumentType type() {
        return type;
    }

    /**
     * The message of this redactable argument.
     */
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    /**
     * The type of the redactable argument.
     */
    public enum ArgumentType {
        /**
         * User data is data that is stored into Couchbase by
         * the application user account.
         */
        USER,
        /**
         * Metadata is logical data needed by Couchbase to
         * store and process user data.
         */
        META,
        /**
         * System data is data from other parts of the system
         * Couchbase interacts with over the network.
         */
        SYSTEM
    }

}