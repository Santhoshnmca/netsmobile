package nets.mobile.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;


public class DataProviderUtils {
	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();

	@DataProvider(parallel = true, name="NetsMobile")
	public static Iterator <Object[]> parallelTestDataProvider(ITestContext context) throws IOException {
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		String driverInitilizeInfo = null;
		//	driverInitilizeInfo = configProperty.getBrowserName() + "_" + configProperty.getPlatform(); // dataProvider="NetsMobile", dataProviderClass=DataProviderUtils.class
			dataToBeReturned.add(new Object[] { driverInitilizeInfo });
		return dataToBeReturned.iterator();
	}
}