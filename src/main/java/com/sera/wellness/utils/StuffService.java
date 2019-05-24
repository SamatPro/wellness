package com.sera.wellness.utils;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class StuffService {
    public static String generateUniqueFileNameForUsersUploads(String type,Long userId) {
        StringBuilder result = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        result.append(type)
                .append(now.getYear())
                .append(now.getMonth())
                .append(now.getDayOfMonth())
                .append(now.getHour())
                .append(now.getMinute())
                .append(now.getSecond())
                .append("uuu")//потому что из-за секунд уникальность может сломаться
                .append(userId);
        return result.toString();
    }
}
