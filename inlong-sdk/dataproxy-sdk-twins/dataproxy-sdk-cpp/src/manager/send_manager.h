/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

#ifndef INLONG_SDK_SEND_MANAGER_H
#define INLONG_SDK_SEND_MANAGER_H

#include "../group/send_group.h"
#include "../utils/read_write_mutex.h"
#include <unordered_map>

namespace inlong {
using namespace inlong;

class SendManager : noncopyable {
private:
  read_write_mutex group_id_2_send_group_map_rwmutex_;
  std::unordered_map<std::string, std::vector<SendGroupPtr>>
      group_id_2_send_group_map_;
  SendGroupPtr DoGetSendGroup(const std::string &group_id);
  void DoAddSendGroup(const std::string &group_id);
  volatile uint32_t send_group_idx_;

public:
  SendManager();
  virtual ~SendManager(){};
  SendGroupPtr GetSendGroup(const std::string &group_id);
  bool AddSendGroup(const std::string &inlong_group_id);
};
} // namespace inlong

#endif // INLONG_SDK_SEND_MANAGER_H
