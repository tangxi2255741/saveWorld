package com.tx.saveWorld.common.enums;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by tangxi on 2018/2/8.
 */
public interface EnumCode<T> {
    T getCode();

    String getDesc();

    class Parser {

        public Parser() {
        }

        /**
         * 通过枚举的code返回对应的枚举
         * @param type 枚举
         * @param code
         * @return
         */
        public static EnumCode parseTo(Class type, Object code) {
            // 创建type类型的所有枚举值set
            EnumSet enums = EnumSet.allOf(type);
            Iterator it = enums.iterator();

            Enum en;
            EnumCode enumCode;
            do {
                if(!it.hasNext()) {
                    throw new IllegalArgumentException(String.format("Invalid argument [%s] cannot convert to enum[%s]", new Object[]{code, type}));
                }

                en = (Enum)it.next();
                if(!(en instanceof EnumCode)) {
                    throw new IllegalArgumentException(type + " is not implemented " + EnumCode.class);
                }

                enumCode = (EnumCode)en;
            } while(!enumCode.getCode().equals(code));

            return enumCode;
        }
    }
}