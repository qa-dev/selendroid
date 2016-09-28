package io.selendroid.server.handler;

import io.selendroid.server.common.Response;
import io.selendroid.server.common.SelendroidResponse;
import io.selendroid.server.common.http.HttpRequest;
import io.selendroid.server.model.AndroidElement;
import io.selendroid.server.util.SelendroidLogger;
import org.json.JSONException;

public class ScrollToElement extends SafeRequestHandler {

  public ScrollToElement(String mappedUri) {
    super(mappedUri);
  }

  @Override
  public Response safeHandle(HttpRequest request) throws JSONException {
    SelendroidLogger.info("Scroll to element command");
    String id = getElementId(request);
    AndroidElement element = getElementFromCache(request, id);
    element.scrollTo();
    return new SelendroidResponse(getSessionId(request), "");
  }
}
