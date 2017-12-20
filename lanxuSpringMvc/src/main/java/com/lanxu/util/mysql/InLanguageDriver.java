package com.lanxu.util.mysql;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月14 16:41
 **/
public class InLanguageDriver extends XMLLanguageDriver implements LanguageDriver {
  private final Pattern IN_PATTERN = Pattern.compile("\\(#\\{(\\w+)}\\)");
  private final Pattern CDATA_PATTERN = Pattern.compile("( [^ ]+? (<|>|<=|>=|<>) [^ ]+? )");

  public InLanguageDriver() {
  }

  public SqlSource createSqlSource(Configuration configuration, String script, Class<?>
      parameterType) {
    Matcher matcher = this.IN_PATTERN.matcher(script);
    if (matcher.find()) {
      script = matcher.replaceAll("<if test='$1.size==0'>(select 1 from menu_item " +
          "where 1=0)" +
          "</if><if " +
          "test='$1.size!=0'>" +
          "(<foreach " +
          "collection=\"$1\" " +
          "item=\"__item\" " +
          "separator=\",\" >#{__item}</foreach>)</if>");
    }

    Matcher cdataMatcher = this.CDATA_PATTERN.matcher(script);
    if (cdataMatcher.find()) {
      script = cdataMatcher.replaceAll(" <![CDATA[$1]]> ");
    }

    script = "<script>" + script + "</script>";
    return super.createSqlSource(configuration, script, parameterType);
  }
}