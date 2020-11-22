package com.martin.serializer.type;

public class JsonBoolean implements JsonObject{

    private Boolean value;

    @Override
    public JsonObjectType getType() {
        return JsonObjectType.BOOLEAN;
    }

    public JsonBoolean(Boolean value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
