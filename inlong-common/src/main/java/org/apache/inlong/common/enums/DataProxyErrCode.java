/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.common.enums;

public enum DataProxyErrCode {

    SUCCESS(0, "Ok"),

    UNSUPPORTED_MSGTYPE(1, "Unsupported msgType"),
    EMPTY_MSG(2, "Empty message"),
    UNSUPPORTED_EXTENDFIELD_VALUE(3,
            "Unsupported extend field value"),
    UNCONFIGURED_GROUPID_OR_STREAMID(4,
            "Un-configured groupId or streamId"),

    UNKNOWN_ERROR(Integer.MAX_VALUE, "Unknown error");

    private final int errCode;
    private final String errMsg;

    DataProxyErrCode(int errorCode, String errorMsg) {
        this.errCode = errorCode;
        this.errMsg = errorMsg;
    }

    public static DataProxyErrCode valueOf(int value) {
        for (DataProxyErrCode msgErrCode : DataProxyErrCode.values()) {
            if (msgErrCode.getErrCode() == value) {
                return msgErrCode;
            }
        }

        return UNKNOWN_ERROR;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrCodeStr() {
        return String.valueOf(errCode);
    }

    public String getErrMsg() {
        return errMsg;
    }
}