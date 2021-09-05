import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner;
public class AutoClicker
 {
    private Robot robot;

    // Delays clicks (ms)
    private int delay;

    // Constructor 
    public AutoClicker()
    {
        try{
        robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        delay = 300;
    }

    public void clickMouse(int button)
    {
        try
        {
         robot.mousePress(button);
         robot.delay(250);
         robot.mouseRelease(button);
         robot.delay(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDelay(int ms)
    {
        this.delay = ms;
    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("---Auto Clicker---");

        System.out.print("Enter the number of desire clicks: ");
        int clicks = sc.nextInt();

        System.out.print("Enter delay between clicks in (ms): ");
        int delay = sc.nextInt();
        System.out.println();

        System.out.println("Program will start in 3 seconds");

        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AutoClicker clicker = new AutoClicker();
        clicker.setDelay(delay);

        for(int i = 0; i < clicks; i++)
        {
            clicker.clickMouse(InputEvent.BUTTON1_MASK);

        }

        System.out.println("AutoClicker complete.");
    }
}
