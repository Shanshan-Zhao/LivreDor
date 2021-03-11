/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tplivoripm.metier;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.Arrays;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZssSy
 */
public class Outil {
    public static String checkLst(String s, String[] lst){     
        if(lst != null && Arrays.asList(lst).contains(s)){
            return "checked";
        }
        return "";
    }
}
