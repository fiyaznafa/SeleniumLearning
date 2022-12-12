package supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> new ChromeDriver();

    private static final Supplier<WebDriver> firefoxSupplier = FirefoxDriver::new;

    private static final Supplier<WebDriver> edgeSupplier = EdgeDriver::new;


    private static final Map<String,Supplier<WebDriver>> MAP = new HashMap<>();
    static {
        MAP.put("chrome",chromeSupplier);
        MAP.put("firefox",firefoxSupplier);
        MAP.put("edge",edgeSupplier);
    }


    public static WebDriver getDriver(String browser){
        return MAP.get(browser.toLowerCase()).get();
    }
}
