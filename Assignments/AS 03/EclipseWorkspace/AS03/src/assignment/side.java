package assignment;

public class side {
	public void set(int y) {
		x = y;
	}

	public void set_x(int y) {
		x = y;
	}

	public int get() {
		return x;
	}

	private int x;
}

 class A extends side {
	public final void set(int y) {
		if (y < 10) {
			set_x(10);
		} else {
			set_x(y);
		}
	}
} 

 class B extends side {
	public final void set(int y) {
		if (y < 25) {
			set_x(25);
		} else {
			set_x(y);
		}
	}
} 


 class C extends side {
	public final void set(int y) {
		if (y < 0) {
			set_x(0);
		} else {
			set_x(y);
		}
	}
} 


 class D extends B {
	public final int get() {
		if (super.get() < 0) {
			return 0;
		} else {
			return super.get();
		}
	}
} 
class problem1 {
	public static int F(int a, int b, int c, int d) {
		side pa;
		side pb;
		side pc;
		side t;
		pa = new A();
		pc = new C();
		pa.set(a);
		pc.set(c);
		if (pa.get() < pc.get()) { // Line#6
			t = pa;
			pa = pc; // Exchange pa pc
			pc = t;
		}
		if (d < 0) {
			pb = new D();  // pb --> D
		} else {
			pb = new B();  // pb --> B Done
		}
		pb.set(b);
		if (pa.get() > pc.get()) { // Line#14
			t = pa;
			pa = pb; // Exchange pa pb
			pb = t;
		}
		if (pa.get() > pb.get()) { //Line#18    corrected
			t = pc;
			pc = pb;  // Exchange pb pc
			pb = t;
		}
		if (pa.get() + pc.get() <= pb.get()) { // Line#22
			return 0;
		} else {
			return 1;
		}
	}
}

