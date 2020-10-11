package com.amsidh.mvc.main;

import com.amsidh.mvc.domain.Person;
import com.amsidh.mvc.mapping.Attribute;
import com.amsidh.mvc.mapping.PersonSdpMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.beanutils.PropertyUtils.getNestedProperty;

public class MainApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonSdpMapping personSdpMapping = objectMapper.readValue(new File("C:\\Users\\amsidhlokhande\\Projects\\XmlToJsonProject\\src\\main\\resources\\mapping\\person-sdp.json"), PersonSdpMapping.class);
        System.out.println(objectMapper.writeValueAsString(personSdpMapping));
        System.out.println("\n\n");
        Person person = new Person();
        personSdpMapping.getAttributeMappings().forEach(attributeMapping -> {

            attributeMapping.getArrayMappings().forEach(attribute -> {
                mappingAttribute(person, attribute);
            });

            attributeMapping.getDirectMappings().forEach(attribute -> {
                mappingAttribute(person, attribute);
            });
        });

        System.out.println(objectMapper.writeValueAsString(person));

    }

    private static void mappingAttribute(Object object, Attribute attribute) {
        String attributeType = attribute.getAttributeType();
        if (attributeType.contains("java.util.List")) {
            String attributeName = attribute.getAttributeName();
            Object childObject = getFieldObject(object, attributeName);
            List list = (List) childObject;

            String className = getClassName(attributeType);
            Object obj = getObjectOf(className);


            attribute.getAttributes().forEach(attr -> {
                Object nestedObj = getObjectOf(getClassName(attribute.getAttributeType()));
                if (attr.getAttributeType().contains("java.util.List")) {
                    mappingAttribute(nestedObj, attr);
                } else {
                    setProperty(nestedObj, attr.getAttributeName(), "Test");
                }
                System.out.println(nestedObj.toString());
            });

            list.add(obj);
            System.out.println(list);
        } else {
            setProperty(object, attribute.getAttributeName(), "Test");
        }
    }

    private static String getClassName(String attributeType) {
        return attributeType.substring(attributeType.indexOf("<") + 1, attributeType.indexOf(">"));
    }

    public static Object getFieldObject(Object object, String attributeName) {
        try {
            return getNestedProperty(object, attributeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static Object getObjectOf(String classPath) {
        Class<?> aClass = Class.forName(classPath);
        Constructor<?> cons = aClass.getConstructor();
        return cons.newInstance();
    }

    @SneakyThrows
    public static void setProperty(Object object, String propertyName, Object value) {
        PropertyUtils.setProperty(object, propertyName, value);
    }
}
