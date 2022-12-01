package com.actitime.testsript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ListenersAnnotation;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskPage;

@Listeners(com.actitime.generic.ListenersImplementation.class)
public class CustamerModule extends BaseClass {
	
	@Test 
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("CreateCustomer",true);
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String expCustName = wb.getSheet("CreateCustomer").getRow(1).getCell(2).getStringCellValue();
		String custDesp = wb.getSheet("CreateCustomer").getRow(1).getCell(3).getStringCellValue();
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskPage t=new TaskPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOption().click();
		t.getEnterCustNameTbx().sendKeys(expCustName);
		t.getEnterCustDespTbx().sendKeys(custDesp);
		t.getSelectCustDD().click();
		t.getOurCompanyTxt().click();
		t.getCreateCustBtn().click();
		Thread.sleep(4000);
		String actualCustName = t.getActualCustCreated().getText();
		Assert.assertEquals(actualCustName, expCustName);
		
	}

}
