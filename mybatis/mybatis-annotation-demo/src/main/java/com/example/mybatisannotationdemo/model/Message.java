package com.example.mybatisannotationdemo.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lenovo
 */
@Data
@Builder
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
