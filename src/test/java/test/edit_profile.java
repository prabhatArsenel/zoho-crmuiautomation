package test;

import org.testng.annotations.Test;

import base.basetest;
import factory.driverFactory;
import pages.edit_profilepage;

public class edit_profile extends basetest {

    @Test
    public void edit_profileme() {
    	System.out.println("hi");

       edit_profilepage s=new edit_profilepage(driverFactory.getDriver());
       s.click_edit();
       s.Enter_lastname("thakur");
       s.save_profile();

       
    }
}