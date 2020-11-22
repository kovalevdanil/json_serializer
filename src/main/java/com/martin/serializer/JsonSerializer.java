package com.martin.serializer;

import com.martin.serializer.annotation.JsonInclude;
import com.martin.serializer.type.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class JsonSerializer {

    private static final Set<Class<?>> serializedClasses = new HashSet<>(Arrays.asList(
            Integer.class,
            Double.class,
            Boolean.class,
            String.class
    ));

    public static JsonObject serialize(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();


        if (Integer.class == clazz){
            return new JsonInteger((Integer) object);
        }

        if (Double.class == clazz){
            return new JsonDouble((Double) object);
        }

        if (String.class == clazz){
            return new JsonString((String) object);
        }

        if (Boolean.class == clazz){
            return new JsonBoolean((Boolean) object);
        }

        if (Date.class == clazz){
            return new JsonString(object.toString());
        }

        if (Collection.class.isAssignableFrom(clazz)){
            return serializeArray((Iterable<?>)object);
        }


        if (Map.class.isAssignableFrom(clazz)) {
            return serializeMap((Map<String, Object>)object); // TODO make it necessary
        }

        return serializeComplexObject(object);
    }

    public static <T extends Iterable<?>> JsonArray serializeArray(T objects) throws IllegalAccessException {

        JsonArray jsonArray = new JsonArray();

        for (var element : (Iterable<?>) objects){
            jsonArray.add(serialize(element));
        }
        return jsonArray;
    }

    public static JsonComplexObject serializeMap(Map<String, Object> map){

        return null;
    }

    public static JsonComplexObject serializeComplexObject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        JsonComplexObject result = new JsonComplexObject();

        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());

        List<Field> annotatedFields = fields.stream().filter(field -> field.getAnnotation(JsonInclude.class) != null).collect(Collectors.toList());

        for (var field : annotatedFields){
            JsonInclude jsonName = field.getAnnotation(JsonInclude.class);
            String fieldName = jsonName.value().isEmpty() ? field.getName() : jsonName.value();
            JsonString jsonFieldName = new JsonString(fieldName);

            field.setAccessible(true);
            Object value = field.get(object);

            if (value != null)
                result.put(jsonFieldName, serialize(value));
        }

        return result;
    }

}
