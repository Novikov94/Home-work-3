import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderFromFileTest {

    @DataProvider()
    public Object[][] dataFromSheet1() throws Exception {
        String path = "src/main/resources/Login.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        return excelReader.getSheetDataForTDD("Лист1");
    }
    @Test(dataProvider = "dataFromSheet1")
    public void test(String params1, String params2){
        System.out.println("UserName: " + params1);
        System.out.println("Password: " + params2);
    }
}
