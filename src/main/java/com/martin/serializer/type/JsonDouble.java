package com.martin.serializer.type;

public class JsonDouble  implements JsonObject{

    private Double value;

    public JsonDouble(Double value) {
        this.value = value;
    }

    @Override
    public JsonObjectType getType() {
        return JsonObjectType.DOUBLE;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
