/*
 * Copyright 2013 selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.openqa.selendroid.server.handler;

import java.util.List;

import org.openqa.selendroid.server.RequestHandler;
import org.openqa.selendroid.server.Response;
import org.openqa.selendroid.server.exceptions.SelendroidException;
import org.openqa.selendroid.util.SelendroidLogger;
import org.webbitserver.HttpRequest;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SendKeyToActiveElement extends RequestHandler {

  public SendKeyToActiveElement(HttpRequest request, String mappedUri) {
    super(request, mappedUri);
  }

  @Override
  public Response handle() {
    SelendroidLogger.log("send key to active element command");
    JsonObject payload = getPayload();

    JsonElement value = payload.get("value");
    if (value.isJsonNull()) {
      return new Response(getSessionId(), new SelendroidException(
          "No key to send to an element was found."));
    }
    JsonArray valueArr = value.getAsJsonArray();
    List<CharSequence> temp = Lists.newArrayList();

    for (int i = 0; i < valueArr.size(); i++) {
      temp.add(valueArr.get(i).getAsString());
    }
    String[] keysToSend = temp.toArray(new String[0]);
    
    getAndroidDriver().getKeyboard().sendKeys(keysToSend);

    return new Response(getSessionId(), "");
  }
}
