package com.martin.serializer.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonArray implements JsonObject, Iterable<JsonObject> {

    private List<JsonObject> value = new ArrayList<>();

    public JsonObjectType getType() {
        return JsonObject.JsonObjectType.ARRAY;
    }

    public void add(JsonObject object){
        value.add(object);
    }

    public boolean remove(JsonObject object){
        return value.remove(object);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (var element : value) {
            builder.append(element.toString());
            builder.append(","); // TODO fix last comma
        }
        if (value.size() > 0){
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");

        return builder.toString();
    }

    @Override
    public Iterator<JsonObject> iterator() {
        return value.iterator();
    }
}
