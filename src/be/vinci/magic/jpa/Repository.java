package be.vinci.magic.jpa;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    public String getById(Long id, Class clazz) {
        return "SELECT * FROM " + clazz.getSimpleName() + " WHERE id = " + id;
    }

    public String selectAll(Class clazz) {
        return "SELECT " + getClassProperties(clazz).stream()
                .map(PropertyDescriptor::getName)
                .collect(Collectors.joining(", ")) + " FROM " + clazz.getSimpleName();
    }

    public String insertRow(Object bean) {
        return "INSERT INTO " + bean.getClass().getSimpleName() + " (" +
                getClassProperties(bean.getClass()).stream()
                        .map(PropertyDescriptor::getName)
                        .collect(Collectors.joining(", ")) +
                ") VALUES (" +
                getClassProperties(bean.getClass()).stream()
                        .map(pd -> {
                            try {
                                return pd.getReadMethod().invoke(bean);
                            } catch (Exception e) {
                                return null;
                            }
                        })
                        .map(value -> {
                            if (value instanceof String) {
                                return "'" + value + "'";
                            } else {
                                return value;
                            }
                        })
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                ")";
    }

    public List<PropertyDescriptor> getClassProperties(Class clazz) {
        try {
            return Arrays.stream(Introspector.getBeanInfo(clazz, Object.class)
                    .getPropertyDescriptors())
                    .filter(pd -> Objects.nonNull(pd.getReadMethod())).toList();
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }


    public Map<String, Object> getProperties(Object bean) {
            return getClassProperties(bean.getClass()).stream()
                    .collect(Collectors.toMap(
                            // bean property name
                            PropertyDescriptor::getName,
                            pd -> { // invoke method to get value
                                try {
                                    return pd.getReadMethod().invoke(bean);
                                } catch (Exception e) {
                                    // replace this with better error handling
                                    return null;
                                }
                            }));
    }

}
