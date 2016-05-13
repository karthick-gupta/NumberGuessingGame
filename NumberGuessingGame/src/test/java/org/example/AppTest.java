package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AppTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void checkNumberHigherOrLowerTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("checkNumberHigherOrLower", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);

		Assert.assertEquals(1, checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "higher"));
		Assert.assertEquals(-1, checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "lower"));
		Assert.assertEquals(0, checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "Yes"));
	}

	@Test
	public void checkNumberHigherOrLowerInvalidTest()
			throws InvalidRespException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {

		thrown.expect(InvalidRespException.class);

		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("checkNumberHigherOrLower", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);

		try {
			checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "sdfasdf");
		} catch (InvocationTargetException e) {
			Assert.assertTrue("Invalid exception thrown", (e.getCause() instanceof InvalidRespException));
			throw (InvalidRespException) e.getCause();
		}

	}

	@Test
	public void isUserReadyTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("isUserReady", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);

		Assert.assertTrue((Boolean) checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "ready"));

	}

	@Test
	public void isUserReadyValidTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, InvalidRespException {

		thrown.expect(InvalidRespException.class);

		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("isUserReady", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);

		try {
			checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "hjhjhj");
		} catch (InvocationTargetException e) {
			Assert.assertTrue("Invalid exception thrown", (e.getCause() instanceof InvalidRespException));
			throw (InvalidRespException) e.getCause();
		}

	}

	@Test
	public void isUserReadyQuitTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, QuitException {

		thrown.expect(QuitException.class);

		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("isUserReady", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);

		try {
			checkNumberHigherOrLowerMethod.invoke(appClass.newInstance(), "quit");
		} catch (InvocationTargetException e) {
			Assert.assertTrue("Invalid exception thrown", (e.getCause() instanceof QuitException));
			throw (QuitException) e.getCause();
		}

	}

	@Test
	public void startTheGameTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		App app = new App();
		Class appClass = App.class;
		Method checkNumberHigherOrLowerMethod = appClass.getDeclaredMethod("findTheNumber", String.class);
		checkNumberHigherOrLowerMethod.setAccessible(true);
		int guessTheNum = 40;
		Field tempField = appClass.getDeclaredField("temp");
		tempField.setAccessible(true);
		int temp = (Integer) tempField.get(app);

		while (true) {
			temp = (Integer) tempField.get(app);
			if (guessTheNum == temp) {
				try {
					checkNumberHigherOrLowerMethod.invoke(app, "yes");
				} catch (InvocationTargetException e) {
					Assert.assertTrue("Invalid exception thrown", (e.getCause() instanceof SuccessException));
					Assert.assertEquals(temp, guessTheNum);
					break;
				}
			} else if (guessTheNum > temp) {
				checkNumberHigherOrLowerMethod.invoke(app, "higher");
			} else {
				checkNumberHigherOrLowerMethod.invoke(app, "lower");
			}
		}

	}

}
