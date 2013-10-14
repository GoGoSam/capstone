package swordfish.controller.input;

/**
 * Represents a device that receives input from the user. Eg, a keyboard, mouse, or joystick.
 */
public interface InputDevice {
	/**
	 * Reset the last input receieved.
	 */
	public boolean resetLastInput ();

	/**
	 * Returns the last input received, or null if no input has been received.
	 */
	public Input getLastInput ();

	/**
	 * Updates the values of all inputs for this device.
	 * @return False if the device could not be polled (it is probably disconnected).
	 */
	public boolean poll ();
}
