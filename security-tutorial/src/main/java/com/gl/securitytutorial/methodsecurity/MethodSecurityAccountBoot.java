package com.gl.securitytutorial.methodsecurity;

import com.gl.securitytutorial.methodsecurity.config.AccountConfiguration;
import com.gl.securitytutorial.methodsecurity.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by gavin on 16-6-2.
 */
public class MethodSecurityAccountBoot {

    public static void main(String...args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AccountConfiguration.class);
        AccountService service = ctx.getBean(AccountService.class);

        List<String> accounts = null;

        System.out.println("1st time list accounts");
        accounts = service.getAccounts();
        printAccounts(accounts);

        service.addAccount("test1");
        service.addAccount("test2");

        System.out.println("2nd time list accounts");
        accounts = service.getAccounts();
        printAccounts(accounts);

        service.removeAccount("test1");

        System.out.println("3rd time list accounts");
        accounts = service.getAccounts();
        printAccounts(accounts);
    }

    private static void printAccounts(List<String> accounts){
        accounts.stream().forEach(System.out::println);
    }
}
