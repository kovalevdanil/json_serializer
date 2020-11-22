package com.martin.serializer.type;

import java.util.HashMap;
import java.util.Map;

public class JsonComplexObject implements JsonObject {

    private HashMap<JsonString, JsonObject> value = new HashMap<>();

    public JsonObjectType getType() {
        return JsonObjectType.COMPLEX_OBJECT;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (var entry : value.entrySet()){
            builder.append(entry.getKey().toString());
            builder.append(":");
            builder.append(entry.getValue().toString());
            builder.append(","); // TODO fix last comma
        }
        if (value.size() > 0){
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");

        return builder.toString();
    }

    public JsonObject put(JsonString key, JsonObject value ){
        return this.value.put(key, value);
    }
}
