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
 * date:2017��5��22��22:51:06 
 * target:���л���̬���������⡣
 * @author ypy
 * conclusion:
 *     ���п��Կ�����xPos��yPos �Լ�dim��ֵ���ѳɹ�����ͻָ����������ڻ�ȡ static��Ϣʱȴ���������⡣
 *     ������ɫ�ġ�3�����ѽ��룬��û�������س�����
 *     Circle ��һ�� 1ֵ������Ϊ RED������Square ��һ�� 0ֵ���������ڹ��������ʼ���ģ�����ֱ�ߵ�ȴ������ʾ������
 *     ���Լ��������л�staticֵ���������Զ��֡�
 *     ������Line �е� serializeStaticState()��deserializeStaticState()����static��������;��
 *     Ҫע�����һ�������ǰ�ȫ����Ϊ���л�����Ҳ�Ὣprivate ���ݱ���������
 *     ������Ҫ���ܵ��ֶΣ�Ӧ�����ǳ�transient��
 *     ������֮�󣬱������һ�ְ�ȫ����Ϣ���淽��������һ����һ����Ҫ�ָ����Ϳ���������Щprivate ������
 */
//ͼ����
abstract class Shape implements Serializable {//ʵ���˿����л��������඼�����л�
	public static final int RED = 1, BLUE = 2, GREEN = 3;//��ɫ
	private int xPos, yPos, dimension;//���꣬�ߴ�
	private static Random r = new Random();
	private static int counter = 0;

	abstract public void setColor(int newColor);//������ɫ

	abstract public int getColor();//�õ���ɫ

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

	//����ͼ��
	public static Shape randomFactory() {
		int xVal = r.nextInt() % 100;
		int yVal = r.nextInt() % 100;
		int dim = r.nextInt() % 100;
		switch (counter++ % 3) {//ȷ����3����ѭ��
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

//Բ����
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

//��������
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

//ֱ����
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
		shapes = new Vector<>();//��������Shape��
		shapeTypes = new Vector<>();//��������class��
		
		File f = new File("CADState.out");
		if (!f.exists()) {//�ж��ļ��Ƿ���ڣ������ھʹ�������д�����ݣ�������ڣ��Ͷ�ȡ����
			shapeTypes.addElement(Circle.class);
			shapeTypes.addElement(Square.class);
			shapeTypes.addElement(Line.class);
			
			for (int i=0; i<10; i++) {//����10��ͼ����
				shapes.addElement(Shape.randomFactory());
			}
			
			for (int i=0; i<10; i++) {
				((Shape)shapes.elementAt(i)).setColor(Shape.GREEN);//������ɫ
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
			System.out.println("д��ʱ��");
			System.out.println(shapes);
		} else {
			System.out.println("��ȡʱ��");
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
 *************** jdk1.8���н��*************** 
 û�����ļ�ʱ��
 д��ʱ��
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


�ļ��Ѿ�����ʱ��
��ȡʱ��
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
