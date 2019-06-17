package spam_everyone;
import java.awt.Robot;
import java.awt.PointerInfo;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;

public class scriptTemplate{
	public static void main(String[] args){		
		int numberOfRepetitions = 50; //how many times the actions will be repeated until it automatically stops
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		wait(3000);
		
		for(int repetitions = 0; repetitions < numberOfRepetitions; repetitions++){ //repeats action 10 times
			a = MouseInfo.getPointerInfo();
			b = a.getLocation();
			
			if(b.getX() < 100 && b.getY() < 100){ //emergency exit, move mouse to top left corner
				System.out.println("Aborted");
				break;
			}
			
			//insert actual commands here
			//*************


      //*************
		}
		
		System.out.println("End of program");
	}
	
	public static void enterEmail() {
        // email format: *****#@ocdsb.ca
        Random rand = new Random();
        for (int x = 0; x < 5; x++) {
            pressKey(rand.nextInt(26) + 65);
        }
        
        pressKey(rand.nextInt(4)+49); // numeric
        
        try{
            Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_2);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        // type @
        
        typeWord("ocdsb");
        pressKey(46);
        typeWord("ca");
    }
	
	public static void wait(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mouseMove(int x, int y){
        try{
        	Robot robot = new Robot();
	        robot.mouseMove(x, y);
        } catch(Exception e){
        	e.printStackTrace();
        }
	}

	public static void rightClick(){
        try{
        	Robot robot = new Robot();
        
		robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        } catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public static void leftClick(){
        try{
        	Robot robot = new Robot();
        
		robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public static void typeWord(String s){
		for(int i = 0; i < s.length(); i++){
			int asciiVal;
			
			if(s.charAt(i)!=32){
			asciiVal = s.charAt(i) - 32;
			} else{
				asciiVal = 32;
			}
			pressKey(asciiVal);
			
		}
	}
	
	public static void pressKey(int keyNum){
        try{
        	Robot robot = new Robot();
        
		robot.keyPress(keyNum);
		robot.keyRelease(keyNum);
        } catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public static void mouseScroll(int ticks){
        try{
        	Robot robot = new Robot();
        
        	robot.mouseWheel(ticks);
        } catch(Exception e){
        	e.printStackTrace();
        }
	}
	
}
