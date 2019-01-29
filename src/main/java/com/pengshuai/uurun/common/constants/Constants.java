package com.pengshuai.uurun.common.constants;

/**
 * Created by YangPeng on 2018/12/8.
 */
public class Constants {

    public enum DATE_PATTERN {
        yyyyMMdd("yyyyMMdd", "^\\d{2,4}\\d{1,2}\\d{1,2}$"),
        yyyy_MM("yyyy/MM", "^\\d{2,4}/\\d{1,2}$"),
        yyyy_MM2("yyyy-MM", "^\\d{2,4}-\\d{1,2}$"),
        yyyy_MM_dd("yyyy/MM/dd", "^\\d{2,4}/\\d{1,2}/\\d{1,2}$"),
        yyyy_MM_dd2("yyyy-MM-dd", "^\\d{2,4}-\\d{1,2}-\\d{1,2}$"),
        yyyy_MM_dd_HH_mm("yyyy/MM/dd HH:mm", "^\\d{2,4}/\\d{1,2}/\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}$"),
        yyyy_MM_dd_HH_mm2("yyyy-MM-dd HH:mm", "^\\d{2,4}-\\d{1,2}-\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}$"),
        yyyy_MM_dd_HH_mm_ss("yyyy/MM/dd HH:mm:ss", "^\\d{2,4}/\\d{1,2}/\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}$"),
        yyyy_MM_dd_HH_mm_ss2("yyyy-MM-dd HH:mm:ss", "^\\d{2,4}-\\d{1,2}-\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}$"),
        yyyy_MM_dd_HH_mm_ss_S("yyyy/MM/dd HH:mm:ss.S", "^\\d{2,4}/\\d{1,2}/\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{1}$"),
        yyyy_MM_dd_HH_mm_ss_S2("yyyy-MM-dd HH:mm:ss.S", "^\\d{2,4}-\\d{1,2}-\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{1}$"),
        yyyy_MM_dd_HH_mm_ss_SS("yyyy/MM/dd HH:mm:ss.SS", "^\\d{2,4}/\\d{1,2}/\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{2}$"),
        yyyy_MM_dd_HH_mm_ss_SS2("yyyy-MM-dd HH:mm:ss.SS", "^\\d{2,4}-\\d{1,2}-\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{2}$"),
        yyyy_MM_dd_HH_mm_ss_SSS("yyyy/MM/dd HH:mm:ss.SSS", "^\\d{2,4}/\\d{1,2}/\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{3,}$"),
        yyyy_MM_dd_HH_mm_ss_SSS2("yyyy-MM-dd HH:mm:ss.SSS", "^\\d{2,4}-\\d{1,2}-\\d{1,2}\\s.{1,2}\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{3,}$");

        private String value;
        private String pattern;

        DATE_PATTERN(String value, String pattern) {
            this.value = value;
            this.pattern = pattern;
        }
        public String getValue() {
            return this.value;
        }
        public String getPattern(){
            return this.pattern;
        }
    }

    public enum COMMON {
        //系统参数名-平台抽取佣金比例
        SERVICE_COST_PROPORTION("平台抽取佣金比例");

        private String value;
        COMMON(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
}
