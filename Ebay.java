package Ebay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {
WebDriver driver;
String url = "https://www.ebay.com/";

public static void main(String[] args) {
// TODO Auto-generated method stub
Ebay ebay = new Ebay();
ebay.openBrowser();
ebay.searchProducts("Apple Iphone", " Cell Phones & Accessories");
// ebay.printTotalResults();
//ebay.printNthResult(5);
ebay.printNthResultUsingXpath(5);
// ebay.printAllResult();
// ebay.printAllResultWithScroll();

}

public void openBrowser() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //for load the page fully
driver.get(url);;
}

public void searchProducts(String product, String category) {

driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(product);
driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).sendKeys(category);

WebElement Search = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
Search.click();


}

public void printTotalResults() {
String results = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1")).getAttribute("textContent");

System.out.println(results);

}

public void printNthResult(int num) {
List allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
int count = 1;
for( WebElement product : allProducts){

if(count == num) {
System.out.println("***********************");

System.out.println(product.getText());

System.out.println("***********************");
}
count++;


}
}

public void printNthResultUsingXpath(int num) {
WebElement Product = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"+"["+num+"]"));


System.out.println("***********************");

System.out.println(Product.getText());

System.out.println("***********************");

}



public void printAllResult() {
List allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));

for( WebElement product : allProducts){


System.out.println("***********************");

System.out.println(product.getText());

System.out.println("***********************");



}
}

public void printAllResultWithScroll() {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,-350)", "");

List allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));

for( WebElement product : allProducts){


System.out.println("***********************");

System.out.println(product.getText());

System.out.println("***********************");



}
}


}