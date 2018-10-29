package com.template.common

/**
 * Created by lizheng18 2018/10/29
 * 主要用于打印error日志
 */
def result = '';
def params="${_1}".replaceAll('[\\[|\\]|\\s]', '').split(',').toList();
def methodName="${_2}";
def className="${_3}";

result += "logger.error(\"#" + className + "." + methodName + "# error params:";
for (String param : params) {
    result += " " + param + "={}"
}
result += "\","
for (String param : params) {
    result += "JSON.toJSONString(" + param + "),"
}
result += "e);"

return result;