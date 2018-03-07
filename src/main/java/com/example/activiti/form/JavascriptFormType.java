package com.example.activiti.form;
import org.activiti.engine.form.AbstractFormType;
public class JavascriptFormType extends AbstractFormType {


    public String getName()
    { return "javascript";}

    @Override
    public Object convertFormValueToModelValue(String propertyValue)
    { return propertyValue;}

    @Override
    public String convertModelValueToFormValue(Object modelValue)
    { return (String) modelValue;}
}
