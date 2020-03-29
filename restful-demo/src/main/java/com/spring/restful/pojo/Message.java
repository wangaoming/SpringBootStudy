package com.spring.restful.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ASUS
 * @description : Message的持久层对象Persisent Object
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private String text;
    private String summary;
}
