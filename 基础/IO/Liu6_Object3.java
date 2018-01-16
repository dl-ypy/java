import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
 * date:2017年5月22日22:51:06 
 * target:序列化静态变量的问题。
 * @author ypy
 * conclusion:
 *     从中可以看出，xPos，yPos 以及dim的值都已成功保存和恢复出来。但在获取 static信息时却出现了问题。
 *     所有颜色的“3”都已进入，但没有正常地出来。
 *     Circle 有一个 1值（定义为 RED），而Square 有一个 0值（它们是在构建器里初始化的），而直线的却正常显示出来。
 *     所以假如想序列化static值，必须亲自动手。
 *     这正是Line 中的 serializeStaticState()和deserializeStaticState()两个static方法的用途。
 *     要注意的另一个问题是安全，因为序列化处理也会将private 数据保存下来。
 *     若有需要保密的字段，应将其标记成transient。
 *     但在这之后，必须设计一种安全的信息保存方法。这样一来，一旦需要恢复，就可以重设那些private 变量。
 */
//图形类
abstract class Shape implements Serializable {//实现了可序列化，其子类都可序列化
	public static final int RED = 1, BLUE = 2, GREEN = 3;//颜色
	private int xPos, yPos, dimension;//坐标，尺寸
	private static Random r = new Random();
	private static int counter = 0;

	abstract public void setColor(int newColor);//设置颜色

	abstract public int getColor();//得到颜色

	public Shape(int xVal, int yVal, int dim) {
		this.xPos = xVal;
		this.yPos = yVal;
		this.dimension = dim;
	}

	@Override
	public String toString() {
		return getClass().toString() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim["
				+ dimension + "]\n";
	}

	//创建图形
	public static Shape randomFactory() {
		int xVal = r.nextInt() % 100;
		int yVal = r.nextInt() % 100;
		int dim = r.nextInt() % 100;
		switch (counter++ % 3) {//确保在3以内循环
		default:
		case 0:
			return new Circle(xVal, yVal, dim);
		case 1:
			return new Square(xVal, yVal, dim);
		case 2:
			return new Line(xVal, yVal, dim);
		}
	}
}

//圆形类
class Circle extends Shape {
	private static int color = RED;

	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

//正方形类
class Square extends Shape {
	private static int color;

	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

//直线类
class Line extends Shape {
	private static int color = RED;

	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
		os.writeInt(color);
	}

	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
		color = os.readInt();
	}

	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

public class Liu6_Object3 {
	public static void main(String[] args) {
		Vector shapeTypes, shapes;
		shapes = new Vector<>();//用来容纳Shape类
		shapeTypes = new Vector<>();//用来容纳class类
		
		File f = new File("CADState.out");
		if (!f.exists()) {//判断文件是否存在，不存在就创建，并写入数据，如果存在，就读取数据
			shapeTypes.addElement(Circle.class);
			shapeTypes.addElement(Square.class);
			shapeTypes.addElement(Line.class);
			
			for (int i=0; i<10; i++) {//创建10个图形类
				shapes.addElement(Shape.randomFactory());
			}
			
			for (int i=0; i<10; i++) {
				((Shape)shapes.elementAt(i)).setColor(Shape.GREEN);//设置颜色
			}
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
				out.writeObject(shapeTypes);
				Line.serializeStaticState(out);
				out.writeObject(shapes);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("写入时：");
			System.out.println(shapes);
		} else {
			System.out.println("读取时：");
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream("CADState.out"));
				shapeTypes = (Vector)in.readObject();
				Line.deserializeStaticState(in);
				shapes = (Vector)in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(shapes);
		}
	}
}
/*
 *************** jdk1.8运行结果*************** 
 没创建文件时：
 写入时：
[class dao.Circlecolor[3] xPos[-76] yPos[-88] dim[17]
, class dao.Squarecolor[3] xPos[-17] yPos[79] dim[80]
, class dao.Linecolor[3] xPos[-58] yPos[77] dim[51]
, class dao.Circlecolor[3] xPos[93] yPos[0] dim[60]
, class dao.Squarecolor[3] xPos[-70] yPos[99] dim[-26]
, class dao.Linecolor[3] xPos[68] yPos[89] dim[1]
, class dao.Circlecolor[3] xPos[33] yPos[54] dim[-86]
, class dao.Squarecolor[3] xPos[-13] yPos[-77] dim[-98]
, class dao.Linecolor[3] xPos[-43] yPos[-95] dim[-93]
, class dao.Circlecolor[3] xPos[62] yPos[-95] dim[46]
]


文件已经存在时：
读取时：
[class dao.Circlecolor[1] xPos[-76] yPos[-88] dim[17]
, class dao.Squarecolor[0] xPos[-17] yPos[79] dim[80]
, class dao.Linecolor[3] xPos[-58] yPos[77] dim[51]
, class dao.Circlecolor[1] xPos[93] yPos[0] dim[60]
, class dao.Squarecolor[0] xPos[-70] yPos[99] dim[-26]
, class dao.Linecolor[3] xPos[68] yPos[89] dim[1]
, class dao.Circlecolor[1] xPos[33] yPos[54] dim[-86]
, class dao.Squarecolor[0] xPos[-13] yPos[-77] dim[-98]
, class dao.Linecolor[3] xPos[-43] yPos[-95] dim[-93]
, class dao.Circlecolor[1] xPos[62] yPos[-95] dim[46]
]
 */
