package test;

import org.testng.annotations.Test;

import base.basetest;
import factory.driverFactory;
import pages.create_leadpge;

public class create_lead extends basetest {

 @Test
 public void create_lead() {
	 create_leadpge c=new create_leadpge(driverFactory.getDriver());
	 c.icon_click();
	 //c.click_searchiconcrm("CRM");
	 c.click_crm();
     c.Search_leads("Leads");
     c.create_lead("prabhat pvt ltd", "kumar");
 }
}
