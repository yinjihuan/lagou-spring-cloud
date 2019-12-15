package org.spring.cloud.multiple.demo.core.context;

import java.util.Map;

public interface RequestContext {
    RequestContext add(String key, String value);

    String get(String key);

    RequestContext remove(String key);

    Map<String, String> getAttributes();
}
