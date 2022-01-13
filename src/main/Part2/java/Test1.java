import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class Test1 extends Main{
    ArrayList<String> example = new ArrayList<String>()  {{
        add("John");
        add("Frank");
        add("Jason");
        add("Tim");
    }};

    @Test(description = "checks if the site is open")
    public void test1() {
        String ans = driverFirst.toString();
        if(!ans.equals("null")) {
            System.out.println("Страница таблиц открыта");
        } else {
            System.out.println("Страница не открылась");
        }
    }

    @Test(description = "element is enabled or not")
    public void test2() {

        WebElement heading = driverFirst.findElement(By.xpath("//div[@id = 'content']//*[text()='Data Tables']"));
        String headin = heading.getText();

        if(heading.isEnabled()) {
            System.out.println("Элемент заголовка " + headin + " присутствует на странице");
        } else {
            System.out.println("Элемент заголовка " + headin + " отсутствует на странице");
        }
    }


    @Test(description = "find some elements")
    public void test3() {
        List<WebElement> temp = driverFirst.findElements(By.xpath("//table[@id = 'table1']//*[text() = 'John' or text() = 'Frank' or text() = 'Jason' or text() ='Tim']"));

        List<String> newWords = new ArrayList<String>();
        for(int i = 0;i < temp.size();i++) {
            newWords.add(temp.get(i).getText());
        }

        if(newWords.equals(example)) {
            System.out.println("Найдено 4 элемента");
        } else {
            System.out.println("Элементы не обнаружены");
        }

    }

    @Test(description = "checks if the site is open")
    public void test4() {

        String ans = driverSecond.toString();
        if(!ans.equals("null")) {
            System.out.println("Страница таблиц открыта");
        } else {
            System.out.println("Страница не открылась");
        }
    }

    @Test(description = "checks if element is enabled")
    public void test5() {

        WebElement element = driverSecond.findElement(By.xpath("//button[text() = 'Add Element']"));
        if(element.isEnabled()) {
            System.out.println("На странице присутствует кнопка 'Add Element'");
        } else {
            System.out.println("На странице отсутствует кнопка 'Add Element'");
        }


    }

    @Parameters({"button"})
    @Test(description = "checks if element is not enabled")
    public void test6(String button) {

        Assert.assertNotEquals(driverSecond.findElement(By.xpath("//button")).getText(), button);
        WebElement element = driverSecond.findElement(By.xpath("//button"));
        String word = element.getText();

        if(!word.equals(button)) {
            System.out.println("На странице отсутствует кнопка 'Delete'");
        } else {
            System.out.println("На странице присутствует кнопка 'Delete'");
        }

    }
}
