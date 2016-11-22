package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data holder for food information.
 *
 * @author William Wen
 *
 */
@XmlRootElement
public class Food {
	private String name;
	private int calories;
	private String servingSize;


	/**
	 * Constructor, must be here.
	 */
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int calories, String servingSize) {
		super();
		this.name = name;
		this.calories = calories;
		this.servingSize = servingSize;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", servingSize=" + servingSize + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

}
