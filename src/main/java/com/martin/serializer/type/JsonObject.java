package com.martin.serializer.type;

import java.util.HashMap;
import java.util.Map;

public interface JsonObject {

    enum JsonObjectType {
        ARRAY, STRING, INTEGER, DOUBLE, BOOLEAN, COMPLEX_OBJECT
    }

    JsonObjectType getType();
}
