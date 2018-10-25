package com.template.common
/**
 * Created by lizheng18 2018/10/25
 *
 */

def result = '';
def params="${_1}".replaceAll('[\\[|\\]|\\s]', '').split(',').toList();
def paramName = params[0];
def returnName="${_2}";
returnName = returnName.substring(returnName.lastIndexOf(".")+1,returnName.length());
def param3 = "${_3}";
def tmp0 = returnName.substring(0,1);
def className = returnName.replaceFirst(tmp0,tmp0.toLowerCase());
result = "" + returnName + " " + className + "= " + "new " + returnName +"();\n";
List<String> properties = param3.split(";").toList();
for (String property : properties) {
    String[] properAry = property.trim().split("[ ]+");
    def temp1 = properAry[2].substring(0,1);
    String propertyName = properAry[2].replaceFirst(temp1,temp1.toUpperCase());
    if (!properAry[1].startsWith("boolean")){
        result += className + ".set" + propertyName + "(" + paramName + ".get" + propertyName + "());\n";
    }else{
        result += className + ".set" + propertyName + "(" + paramName + ".is" + propertyName + "());\n";
    }
}
return result;