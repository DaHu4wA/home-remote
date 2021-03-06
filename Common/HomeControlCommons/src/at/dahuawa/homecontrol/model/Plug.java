package at.dahuawa.homecontrol.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Plug object. Every object represents a remote controlled plug.
 * 
 * @author Stefan Huber
 */
@XmlRootElement
public class Plug {
	
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String ENABLED = "enabled";

	private char id; // The ID of the Switch (A,B,C,D)
	private String name; // The name that should be shown on the clients
	private boolean enabled; // enabled = true --> plug turned on

	public Plug() {
		this.id = ' ';
		this.name = null;
		this.enabled = false;
	}

	public Plug(char id, String name, boolean enabled) {
		this.id = id;
		this.name = name;
		this.enabled = enabled;
	}

	public char getId() {
		return id;
	}

	public void setId(String id) {
		this.id = (char) Integer.parseInt(id);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Plug [id=" + id + ", name=" + name + ", enabled=" + enabled
				+ "]";
	}
}