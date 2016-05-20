package com.kaishengit.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

import java.util.AbstractCollection;
import java.util.Map;

/**
 * Created by qiyawei on 2016/5/9.
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        ActionProxy actionProxy = actionInvocation.getProxy();
        String actionName = actionProxy.getActionName();
        String methodNmae =  actionProxy.getMethod();
        String nameSpace  = actionProxy.getNamespace();

        if((("index".equals(actionName)||"login".equals(actionName))&&"/".equals(nameSpace))){

            return actionProxy.execute();
        } else{
            Map<String,Object> session  = ActionContext.getContext().getSession();
            if(session.get("curr_user") != null){
                return actionProxy.execute();
            }else{

                return Action.LOGIN;
            }
        }

    }



}
