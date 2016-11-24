package Main;

public enum Menus {
	epicburger(120, "Epic Burger"),
	barnyardburger(130, "Barnyard Burger"),
	classicburger(130, "Classic Burger"),
	benderburger(140, "Bender Burger"),
	roastedicedcoffee(60, "Roasted Iced Coffee"),
	icedtea(30, "Iced Tea"),
	cocacola(25, "Coca Cola"),
	drpepper(25, "Dr Pepper"),
	dutchapplepie(50, "Dutch Apple Pie"),
	fudgesundae(60, "Chocolate Fudge Sundae"),
	sundaepie(70, "Hershey's Sundae Pie"),
	cinnamonroll(60, "Cinnamon Roll"),
	gardengrilledchickensalad(90, "Garden Grilled Chicked Salad"),
	gardensidesalad(60, "Garden Side Salad"),
	baconcheddarchickensalad(100, "Bacon Cheddar Chicken Salad"),
	crispychickensalad(80, "Crispy Chicken Salad");
	public double price;
	public String name;
	
	private Menus(double price, String name){
		this.price = price;
		this.name = name;
	}
}

