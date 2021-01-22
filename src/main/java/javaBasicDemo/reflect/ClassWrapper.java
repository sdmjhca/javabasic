package javaBasicDemo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassWrapper {
    private List<Field> fieldList;
    private List<Method> methodList;

    public ClassWrapper(Class clazz) {
        this.fieldList = getFields(clazz);
        this.methodList = getMethodList(clazz);
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    private List<Field> getFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        return getFields(fieldList, clazz);
    }

    private List<Method> getMethodList(Class clazz){
        List<Method> methodList = new ArrayList<>();
        return getMethods(methodList, clazz);
    }

    private List<Field> getFields(List<Field> fieldList, Class clazz) {
        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            getFields(fieldList, superClazz);
        }
        return fieldList;
    }

    private List<Method> getMethods(List<Method> methodList, Class clazz){
        methodList.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            getMethods(methodList, superClazz);
        }
        return methodList;
    }
}
