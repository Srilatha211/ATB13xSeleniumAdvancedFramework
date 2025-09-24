package org.example.Listners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListner implements IAnnotationTransformer {

    //This is used if any testcase,constructor,method,class,
    // are failing then it wil call the analyser

//This transform function is avlaible once u clickon generate and override
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyser.class);

    }
}
