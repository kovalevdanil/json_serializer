package com.martin.serializer.type;

public class JsonInteger implements JsonObject{

    private Integer value;

    public JsonInteger(Integer value) {
        this.value = value;
    }

    @Override
    public JsonObjectType getType() {
        return JsonObjectType.INTEGER;
    }

    @Override
    public String toString(){
        return value.toString();
    }

}
