package com.lanxu.util.mysql;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月11 11:19
 **/
@Intercepts({
    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
        Object.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,
        Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class,
        Integer.class})})
public class DaoCacheInterceptor implements Interceptor {

  //添加一个日志器
  private static final Logger logger = LoggerFactory.getLogger(DaoCacheInterceptor.class);

  //拦截方法,在这里处理拦截器的业务逻辑
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("invocation name: " + invocation.getMethod().getName());
    return invocation.proceed();
  }

  /**
   * 把目标对象封装成Plugin对象
   * target就是Executor和StatementHandler
   */
  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {

  }
}