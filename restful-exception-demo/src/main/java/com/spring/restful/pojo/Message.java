package com.spring.restful.pojo;

import lombok.Data;
import lombok.NonNull;

// Message的持久层对象Persisent Object


@Data
public class Message {
    private Long id;
    @NonNull
    private String text;
    private String summary;
}
