package com.example.jdbcfiisrtdemo.filter;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;
//日志
@Slf4j
public class ConnLogFilter extends FilterEventAdapter {

    public class ConnectionLogFilter extends FilterEventAdapter {
        @Override
        public void connection_connectBefore(FilterChain chain, Properties info) {
            log.info("Before Connection! info:{}",info.toString());
        }

        @Override
        public void connection_connectAfter(ConnectionProxy connection) {
            log.info("After Connection:{}",connection.toString());
        }
    }

}
