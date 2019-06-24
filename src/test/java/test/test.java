package test;
import org.testng.annotations.Test;
import utilities.ReadSpreadsheet;

public class test {
    ReadSpreadsheet test1=new ReadSpreadsheet();
    @Test
    public void tst1()throws Exception{
        test1.getOrgData();
    }

}
