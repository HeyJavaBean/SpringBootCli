package com.imlehr.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lehr
 * @create: 2020-04-13
 */
public class HeaderUtils {

        public static String getVisitorId(HttpServletRequest request)
        {
            return request.getAttribute("userId").toString();
        }

}

