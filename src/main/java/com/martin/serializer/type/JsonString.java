package com.martin.serializer.type;

public class JsonString implements JsonObject{

    private String value;

    @Override
    public JsonObjectType getType() {
        return JsonObjectType.STRING;
    }

    public JsonString(){}

    public JsonString(String value){
        this.value = value;
    }


    @Override
    public String toString(){
        return String.format("\"%s\"", value); // TODO escape slashes and other special symbols in value
    }

}
