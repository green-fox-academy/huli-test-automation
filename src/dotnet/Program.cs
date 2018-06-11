using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System.Collections.Generic;

namespace testApp
{
    class Program
    {
        static void Main(string[] args)
        {
			ChromeOptions options = new ChromeOptions();
			options.AddArguments(new List<string>() {
                "--silent-launch",
                "--no-startup-window",
                "no-sandbox",
                "headless",});
			var chromeDriverService = ChromeDriverService.CreateDefaultService();
			IWebDriver driver = new ChromeDriver(chromeDriverService, options);
			driver.Navigate().GoToUrl("https://google.com");
			IWebElement search_box = driver.FindElement(By.Name("q"));
			search_box.SendKeys("DevOps");
			search_box.Submit();
            
			IEnumerable<object> results = new List<IWebElement>(); 
			results = driver.FindElements(By.XPath("//div/div/div/div/div/div/div/div/cite"));
            
			foreach (IWebElement item in results)
			{
				Console.WriteLine(item.Text);
			}
		}
    }
}
